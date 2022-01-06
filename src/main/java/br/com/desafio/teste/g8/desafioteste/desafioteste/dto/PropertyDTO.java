package br.com.desafio.teste.g8.desafioteste.desafioteste.dto;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Property;
import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Room;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
public class PropertyDTO {

    /**
     * @author Everson Okuhara
     * @description validações de entrada do nome da Property
     */
    @NotNull
    @NotEmpty(message = "O nome da propriedade não pode estar vazio.")
    @Pattern(regexp = "^([A-Z]{1})([a-z]{1,})$", message = "O nome da propriedade deve começar com letra maiúscula") //quando o nome for composto, o que fazer?
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres")
    private String name;
    @NotNull
    @NotEmpty(message = "O bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres.")
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