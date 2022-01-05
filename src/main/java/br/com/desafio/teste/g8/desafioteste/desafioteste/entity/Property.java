package br.com.desafio.teste.g8.desafioteste.desafioteste.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Property {
    private String name;
    private String district;
}