package com.example.atividaderomariorevisao.DTO;

import com.example.atividaderomariorevisao.model.entities.Disciplina;
import com.example.atividaderomariorevisao.model.entities.Endereco;
import com.example.atividaderomariorevisao.model.entities.Escola;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
public class ProfessorDTO {
    private String nome;
    @Email
    private String email;
    private String telefone;
    private List<Disciplina> listaDeDisciplinas;
    private Endereco endereco;
    private Escola escola;
}
