package br.com.desafio.teste.g8.desafioteste.desafioteste.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class DistrictDTO {

    //Há por mais de uma biblioteca, qual escolher?
    //Corrigir primeira letra maiuscula em cada inicio de palavra
    @NotNull
    @NotEmpty (message = "O nome da propriedade não pode estar vazio.")
    @Size(max =45, message = "O comprimento do bairro nao pode exceder 45 caracteres.")
    @Pattern(regexp = "^([A-Z]{1})([a-zA-Z]{1,})$", message = "O nome da propriedade deve começar com letra maiúscula")
     String name;

    //Se der tratar excessao de bigdecimal ter um string
    //É preciso verificar métodos para dígitos
    @NotNull
    @NotEmpty (message =  "O valor do metro quadrado no bairro não pode estar vazio")
    @Digits(integer = 11, fraction = 2, message = "O valor do metro quadrado no bairro não pode exceder 13 dígitos")
     BigDecimal pricePerM2;
}
