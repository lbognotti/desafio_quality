package br.com.desafio.teste.g8.desafioteste.desafioteste.test.unit;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.District;
import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Property;
import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Room;
import br.com.desafio.teste.g8.desafioteste.desafioteste.repository.DistrictRepository;
import br.com.desafio.teste.g8.desafioteste.desafioteste.repository.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PropertyServiceTest {

    private PropertyService propertyService;

    @Mock
    private PropertyRepository propertyRepositoryMock;
    @Mock
    private DistrictRepository districtRepositoryMock;

    private Property fakeProperty;

    public Property createFakeProperty() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(Room.builder().name("sala").length(10.0).width(5.0).build());
        rooms.add(Room.builder().name("quarto 1").length(4.0).width(4.0).build());
        rooms.add(Room.builder().name("cozinha").length(3.0).width(3.0).build());

        return Property.builder()
                .name("AP")
                .district("Centro")
                .quartoList(rooms)
                .build();
    }

    public District createFakeDistrict() {
        return District.builder().name("Vila").pricePerM2(new BigDecimal("20.0")).build();
    }

    @BeforeEach
    public void init() {
        openMocks(this);
        this.fakeProperty = this.createFakeProperty();
        this.propertyService = new PropertyService(this.propertyRepositoryMock, this.districtRepositoryMock);
    }

    @Test
    public void deveRetornarAAreaTotalDaPropriedade() {
        Mockito.when(this.propertyRepositoryMock.findByName(anyString()))
                .thenReturn(fakeProperty);

        double totalArea = this.propertyService.getPropertyArea(this.fakeProperty.getName());
        assertEquals(totalArea, 75.0);
    }

    /**
     * @author Lucas Matos
     * @descripton Teste para validar se os valores da propriedade sao 0
     */
    @Test
    public void naoDeveCadastrarUmComodoComValoresDeAreasIgual0() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(Room.builder().name("sala").length(0.0).width(2.2).build());
        rooms.add(Room.builder().name("quarto 1").length(2.0).width(4.0).build());
        rooms.add(Room.builder().name("cozinha").length(3.0).width(5.0).build());

        Property property = Property.builder()
                .name("AP")
                .district("Centro")
                .quartoList(rooms)
                .build();


        Mockito.when(this.propertyRepositoryMock.save(property))
                .thenReturn(property);

       NullPointerException nullExp = assertThrows(NullPointerException.class, () -> this.propertyService.createProperty(property));

       assertTrue(nullExp.getMessage().contains(""));

    }

    /**
     * @author Lucas Matos
     * @descripton Teste para validar se os valores da propriedade sao negativos
     */
    @Test
    public void naoDeveCadastrarUmComodoComValoresDeAreasNegativos() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(Room.builder().name("sala").length(2.0).width(2.2).build());
        rooms.add(Room.builder().name("quarto 1").length(2.0).width(4.0).build());
        rooms.add(Room.builder().name("cozinha").length(3.0).width(-5.0).build());

        Property property = Property.builder()
                .name("AP")
                .district("Centro")
                .quartoList(rooms)
                .build();


        Mockito.when(this.propertyRepositoryMock.save(property))
                .thenReturn(property);

        NullPointerException nullExp = assertThrows(NullPointerException.class, () -> this.propertyService.createProperty(property));

        nullExp.getMessage();
        assertTrue(true);
    }

    /**
     * @author Lucas Matos
     * @descripton Teste para validar o cadastro de uma nova propriedade
     */
    @Test
    public void deveCadastrarUmComodoComValoresInteiroPositivo() {
        Property property = this.createFakeProperty();

        Mockito.when(this.propertyRepositoryMock.save(property)).thenReturn(property);

        assertEquals(this.propertyService.createProperty(property), property);
    }

    @Test
    public void deveRetornarOMaiorComodoDaPropriedade() {
        Property mockedProperty = this.createFakeProperty();
        Room mockedBiggestRoom = mockedProperty.getQuartoList().get(0);

        when(this.propertyRepositoryMock.findByName(anyString()))
                .thenReturn(mockedProperty);

        Room result = this.propertyService.getBiggestRoom(mockedProperty.getName());

        assertEquals(result, mockedBiggestRoom);
    }

    /**
     * @author Lucas Matos
     * @descripton Teste retorna uma excessao ao buscar uma propridade que nao esta cadastrada
     */
    @Test
    public void deveRetornarUmaExceptionQuandoNaoEncontrarUmaProperty() {
        Property property = this.createFakeProperty();
        District district = this.createFakeDistrict();

        Mockito.when(this.propertyRepositoryMock.findByName(property.getName())).thenReturn(null);
        Mockito.when(this.districtRepositoryMock.findByName(property.getDistrict())).thenReturn(district);

        NullPointerException nullExpDistrict = assertThrows(NullPointerException.class, () -> this.propertyService.getTotalValueProperty(property.getName()));

        nullExpDistrict.getMessage();
        assertTrue(true);
    }

    /**
     * @author Lucas Matos
     * @descripton Teste retorna uma excessao ao buscar um bairro que nao esta cadastrado
     */
    @Test
    public void deveRetornarUmaExceptionQuandoNaoEncontrarUmDistrict() {
        Property property = this.createFakeProperty();

        Mockito.when(this.propertyRepositoryMock.findByName(property.getName())).thenReturn(property);
        Mockito.when(this.districtRepositoryMock.findByName(property.getDistrict())).thenReturn(null);

        NullPointerException nullExpDistrict = assertThrows(NullPointerException.class, () -> this.propertyService.getTotalValueProperty(property.getName()));

        nullExpDistrict.getMessage();
        assertTrue(true);
   }

    /**
     * @author Lucas Matos
     * @descripton Teste para validar o total da propridade
     */
   @Test
    public void deveRetornarOvalorTotalDaPropriedade() {
       Property property = this.createFakeProperty();
       District district = this.createFakeDistrict();

       Mockito.when(this.propertyRepositoryMock.findByName(property.getName())).thenReturn(property);
       Mockito.when(this.districtRepositoryMock.findByName(property.getDistrict())).thenReturn(district);

       BigDecimal totalValue = this.propertyService.getTotalValueProperty(property.getName());

       assertEquals(new BigDecimal("1500.0"), totalValue);
   }
}
