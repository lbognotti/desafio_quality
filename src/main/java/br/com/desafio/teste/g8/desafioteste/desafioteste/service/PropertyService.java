package br.com.desafio.teste.g8.desafioteste.desafioteste.service;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Property;
import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Room;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PropertyService {
    /**
     * @author Vinicius Feitoza
     * @description Método que determina a área de cada comodo.
     * @param property
     * @return Retorna um Hashmap de comodos com suas áreas.
     */
    public HashMap<String, Double> getRoomArea(Property property) {
        HashMap<String, Double> roomArea = new HashMap<String, Double>();
        for (Room room: property.getQuartoList()){
            double area = room.getWidth() * room.getLength();
            roomArea.put(room.getName(), area);
        }
        return roomArea;
    }
}