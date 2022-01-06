package br.com.desafio.teste.g8.desafioteste.desafioteste.dto;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Room;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
public class RoomDTO {

    /**
     * @author Everson Okuharan / Vinicius Feitoza
     * @description validações de entrada do nome da Room
     */
    @NotNull
    @NotEmpty(message = "O campo não pode estar vazio.")
    @Pattern(regexp = "^([A-Z]{1})([a-z]{1,})$", message = "O nome do cômodo deve começar com letra maiúscula") //quando o nome for composto, o que fazer?
    @Size(max=30, message = "O comprimento do cômodo não pode exceder 30 caracteres")
    private String name;
    private Double width;
    private Double length;

    public static RoomDTO toRoomDto (Room room) {
        return RoomDTO.builder()
                .name(room.getName())
                .width(room.getWidth())
                .length(room.getLength())
                .build();
    }

    public static Room toRoom (RoomDTO dto) {
        return Room.builder()
                .name(dto.getName())
                .width(dto.getWidth())
                .length(dto.getLength())
                .build();
    }
}