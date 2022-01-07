package br.com.desafio.teste.g8.desafioteste.desafioteste.dto;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Room;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

/**
 * @author Vinicius Feitoza
 * @description Classe RoomDTO, realiza as validações de entradas de room.
 */
@Data
@Builder
public class RoomDTO {

    /**
     * @author Everson Okuharan / Vinicius Feitoza
     * @description validações de entrada dos atributos name, widht, length da Room
     */
    @NotNull
    @NotEmpty(message = "O campo não pode estar vazio.")
    @Pattern(regexp = "^([A-Z]{1})([\\sa-zA-Z]{1,})$", message = "O nome do cômodo deve começar com letra maiúscula") //quando o nome for composto, o que fazer?
    @Size(max=30, message = "O comprimento do cômodo não pode exceder 30 caracteres")
    private String name;
    @NotNull
    @Min(value = 1, message = "A largura mínima permitida por cômodo é de 1 metro.")
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros.")
    private Double width;
    @NotNull
    @Min(value = 1, message = "O comprimento mínimo permitido por cômodo é de 1 metro.")
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros")
    private Double length;

    /**
     * @author Vinicius Feitoza
     * @description recebe um room e transforma em dto. retorna o dto criado a partir dos dados do dto.
     * @param room room recebido a ser transformado em dto
     * @return RoomDTO - DTO criado a partir de room
     */
    public static RoomDTO toRoomDto (Room room) {
        return RoomDTO.builder()
                .name(room.getName())
                .width(room.getWidth())
                .length(room.getLength())
                .build();
    }
    /**
     * @author Vinicius Feitoza
     * @description recebe um dto e transforma em room, e retorna o room criado. Esse DTO em especifico é igual a um room.
     * @param dto dto que sera transformado em Room
     * @return  retorna um room feito a partir do dto
     */
    public static Room toRoom (RoomDTO dto) {
        return Room.builder()
                .name(dto.getName())
                .width(dto.getWidth())
                .length(dto.getLength())
                .build();
    }
}