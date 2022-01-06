package br.com.desafio.teste.g8.desafioteste.desafioteste.dto;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Room;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDTO {
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