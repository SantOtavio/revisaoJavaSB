package com.example.atividaderomariorevisao.DTO;

import com.example.atividaderomariorevisao.model.entities.Curso;
import com.example.atividaderomariorevisao.model.entities.Endereco;
import com.example.atividaderomariorevisao.model.entities.Professor;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
public class EscolaDTO {
    private String nome;
    private Endereco endereco;
    @Email
    private String email;
    private List<Professor> listaDeProfessores;
    private List<Curso> listaDeCursos;
}
