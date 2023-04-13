package com.example.atividaderomariorevisao.DTO;

import com.example.atividaderomariorevisao.model.entities.Endereco;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class AlunoDTO {
    private String nome;
    @Email
    private String email;
    private String telefone;
    private Endereco endereco;
}
