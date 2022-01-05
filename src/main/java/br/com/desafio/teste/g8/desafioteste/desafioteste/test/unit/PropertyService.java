package br.com.desafio.teste.g8.desafioteste.desafioteste.test.unit;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Property;
import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Room;
import br.com.desafio.teste.g8.desafioteste.desafioteste.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Service
public class PropertyService {

    private PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository repository) {
        this.propertyRepository = repository;
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
        HashMap<String, Double> roomArea = this.getRoomArea(p.toString());
        double propertyArea = roomArea.values().stream().reduce((a, b) -> a + b).get();
        return propertyArea ;
    }
}