package com.example.atividaderomariorevisao.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class EnderecoDTO {
    private String rua;
    @Positive
    private Integer numero;
    private String cidade;
    private String estado;
    private String bairro;
    @Min(value = 10000000L)
    @Max(value = 99999999L)
    private Long cep;
}
