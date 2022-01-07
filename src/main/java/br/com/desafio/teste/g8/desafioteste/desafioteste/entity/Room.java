package br.com.desafio.teste.g8.desafioteste.desafioteste.entity;

import lombok.Builder;
import lombok.Data;


/**
 * @author Everson Okuhara
 * @description classe Room (comodos), contem name(nome), width (largura), lenght(comprimento)
 * @return
 */
@Data
@Builder
public class Room {
    private String name;
    private Double width;
    private Double length;

    /**
     * @author Ronald Pinho
     * @description calcula a area do comodo
     * @return retorna a area total
     */
    public double area() {
        return this.width * this.length;
    }
}