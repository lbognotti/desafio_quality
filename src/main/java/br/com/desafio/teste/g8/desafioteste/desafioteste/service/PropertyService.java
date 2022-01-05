package br.com.desafio.teste.g8.desafioteste.desafioteste.service;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Property;
import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Room;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Service
public class PropertyService {
    /**
     * @author Vinicius Feitoza
     * @description Método que determina a área de cada comodo.
     * @param property
     * @return Retorna um Hashmap de comodos com suas áreas.
     */
    public Map<String, Double> getRoomArea(Property property) {
        Map<String, Double> roomArea = new HashMap<>();
        for (Room room: property.getQuartoList()){
            roomArea.put(room.getName(), room.area());
        }
        return roomArea;
    }

    /**
     * @author Ronaldd Pinho
     * @description Retorna o maior quarto de uma propriedade.
     * @param property Objeto da propiedade com a lista de quartos.
     * @return Objeto de Room.
     */
    public Room getBiggestRoom(Property property) {
        return property.getQuartoList().stream().max(Comparator.comparing(Room::area)).get();
    }
}