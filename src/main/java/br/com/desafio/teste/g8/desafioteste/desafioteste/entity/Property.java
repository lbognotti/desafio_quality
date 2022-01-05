package br.com.desafio.teste.g8.desafioteste.desafioteste.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Property {
    private String name;
    private String district;
    private List<Room> quartoList;
}