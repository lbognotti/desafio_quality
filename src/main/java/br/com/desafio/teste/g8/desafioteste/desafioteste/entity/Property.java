package br.com.desafio.teste.g8.desafioteste.desafioteste.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Everson Okuhara
 * @description classe proprierty , refente a propriedade que é o imovel. Contem atributos district(District/bairro_, name (nome do imovel), Lista de comodos (Room)
 */
@Data
@Builder
public class Property {
    private String name;
    private String district;
    private List<Room> quartoList;
}