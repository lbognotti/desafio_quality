package br.com.desafio.teste.g8.desafioteste.desafioteste.service;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.District;
import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Property;
import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Room;
import br.com.desafio.teste.g8.desafioteste.desafioteste.repository.DistrictRepository;
import br.com.desafio.teste.g8.desafioteste.desafioteste.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Lucas Matos
 * @description Regras de negocio a serem aplicadas. base da resolucao das historias de usuario. Fica a logica base do negocio, que chama varios metodos.
 */
@Service
public class PropertyService {

    /**
     * @author Vinicius Feitoza
     * @description instancia classes para serem usadas e ligar com o repositorio
     */
    private PropertyRepository propertyRepository;
    private DistrictRepository districtRepository;
    
    @Autowired
    public PropertyService(PropertyRepository propertyRepository, DistrictRepository districtRepository) {
        this.propertyRepository = propertyRepository;
        this.districtRepository = districtRepository;
    }

    /**
     * @author Lucas Matos
     * @description cadastra uma propriedade propertyRepository a partir de uma property dada como parametro
     * @param property parametro recebido a ser cadastrado
     * @return a propriedade criada
     */
    public Property createProperty(Property property) {
       List<Room> propertyFailure = property.getQuartoList().stream()
                .filter(p -> p.getWidth() <= (0.0) || p.getLength() <= (0.0))
                .collect(Collectors.toList());

       if (propertyFailure.size() != 0) {
           throw new NullPointerException();
       }

        return this.propertyRepository.save(property);
    }

    /**
     * @author Vinicius Feitoza
     * @description Método que determina a área de cada comodo.
     * @param name
     * @return Retorna um Hashmap de comodos com suas áreas.
     */
    public HashMap<String, Double> getRoomArea(String name) {
        Property p = this.propertyRepository.findByName(name);
        HashMap<String, Double> roomArea = new HashMap<String, Double>();
        for (Room room: p.getQuartoList()){
            double area = room.getWidth() * room.getLength();
            roomArea.put(room.getName(), area);
        }
        return roomArea;
    }

    /**
     * @author Ronaldd Pinho
     * @description Retorna o maior quarto de uma propriedade.
     * @param name serve para buscar a propriedade
     * @return Objeto de Room.
     */
    public Room getBiggestRoom(String name) {
        return this.propertyRepository.findByName(name)
                .getQuartoList()
                .stream()
                .max(Comparator.comparing(Room::area))
                .get();
    }
  
    /**
     * @author Vinicius Feitoza
     * @description Método para calcular a área total do imóvel com base na soma dos comodos.
     * @param name
     * @return Retorna um double da área do imovel.
     */
    public double getPropertyArea(String name) {
        Property p = this.propertyRepository.findByName(name);
        HashMap<String, Double> roomArea = this.getRoomArea(p.getName());
        double propertyArea = roomArea.values().stream().reduce((a, b) -> a + b).get();
        return propertyArea ;
    }

    /**
     * @author Lucas Matos
     * @description Método para calcular a total do imóvel com base no valor do bairro.
     * @param name
     * @return Retorna o valor total da propriedade
     */
    public BigDecimal getTotalValueProperty(String name) {
        Property property = this.propertyRepository.findByName(name);
        if (property == null ) throw new NullPointerException();
        District district = this.districtRepository.findByName(property.getDistrict());
        if (district == null) throw new NullPointerException();

        double area = property.getQuartoList().stream().map(Room::area).reduce(Double::sum).get();

        return district.getPricePerM2().multiply(new BigDecimal(area));
    }
}
