package br.com.desafio.teste.g8.desafioteste.desafioteste.dto;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.District;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@Builder
/**
 * @author Tiago Wolsen
 * @description
 * @param DistrictDTO classe District em formato de DTO. Possui validacoes e build um em outro
 */
public class DistrictDTO {

    //Há por mais de uma biblioteca, qual escolher?
    //Corrigir primeira letra maiuscula em cada inicio de palavra
    /**
     * @author Tiago Wolsen
     * @description Validações de entrada nome do distric
     * @param name nome do distric
     */
    @NotNull
    @NotEmpty (message = "O nome do bairro não pode estar vazio.")
    @Size(max =45, message = "O comprimento do bairro nao pode exceder 45 caracteres.")
    @Pattern(regexp = "^([A-Z]{1})([a-zA-Z]{1,})$", message = "O nome do bairro deve começar com letra maiúscula")
     String name;

    //Se der tratar excessao de bigdecimal ter um string
    //É preciso verificar métodos para dígitos
    /**
     * @author Tiago Wolsen
     * @description Validações de entrada preco do metro quadrado
     * @param pricePerM2 preco do metro quadrado
     */
    @NotNull
    @NotEmpty (message =  "O valor do metro quadrado no bairro não pode estar vazio")
    @Digits(integer = 11, fraction = 2, message = "O valor do metro quadrado no bairro não pode exceder 13 dígitos")
     BigDecimal pricePerM2;

    /**
     * @author Tiago Wolsen
     * @description Metodo converte district em districtDTO
     * @param district instancia district que sera transformada em DTO
     */
    public DistrictDTO toDistrictDTO (District district){
        return DistrictDTO.builder().
                name(district.getName()).pricePerM2(district.getPricePerM2()).
                build();
    }

    /**
     * @author Tiago Wolsen
     * @description Metodo converte districtDTO em district
     * @param districtDTO instancia districtDTO que sera transformada em district
     */
    public District toDistric (DistrictDTO districtDTO){
        return District.builder().
                name(districtDTO.getName()).
                pricePerM2(districtDTO.pricePerM2).
                build();
    }
}
