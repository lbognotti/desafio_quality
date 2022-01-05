package br.com.desafio.teste.g8.desafioteste.desafioteste.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Room {
    private String name;
    private Double width;
    private Double length;
}