package br.com.desafio.teste.g8.desafioteste.desafioteste.test.unit;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Property;
import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Room;
import br.com.desafio.teste.g8.desafioteste.desafioteste.repository.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class PropertyServiceTest {

    private PropertyService propertyService;

    @Mock
    private PropertyRepository propertyRepositoryMock;
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

    @BeforeEach
    public void init() {
        openMocks(this);
        this.fakeProperty = this.createFakeProperty();
        this.propertyService = new PropertyService(this.propertyRepositoryMock);
    }

    @Test
    public void deveRetornarAAreaTotalDaPropriedade() {
        Mockito.when(this.propertyRepositoryMock.findByName(anyString()))
                .thenReturn(fakeProperty);

        double totalArea = this.propertyService.getPropertyArea(this.fakeProperty.getName());
        assertEquals(totalArea, 75.0);
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
}
