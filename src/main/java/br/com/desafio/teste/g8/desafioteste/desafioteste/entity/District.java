package br.com.desafio.teste.g8.desafioteste.desafioteste.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Wolsen
 * @description classe District, guarda os bairror. contem name (nome do bairro) e pricePerM2 (preco por metro quadrado). Data e Build tras
 */
@Data
@Builder
public class District {
    String name;
    BigDecimal pricePerM2;
}
