package br.com.desafio.teste.g8.desafioteste.desafioteste.dto;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Property;
import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Room;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PropertyDTO {
    private String name;
    private String district;
    private List<Room> quartoList;


    public static PropertyDTO toPropDto (Property property) {
        return PropertyDTO.builder()
                .name(property.getName())
                .district(property.getDistrict())
                .quartoList(property.getQuartoList())
                .build();
    }

    public static Property toProperty (PropertyDTO dto) {
        return Property.builder()
                .name(dto.getName())
                .district(dto.getDistrict())
                .quartoList(dto.getQuartoList())
                .build();
    }
}