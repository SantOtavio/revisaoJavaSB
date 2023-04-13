package com.example.atividaderomariorevisao.DTO;

import com.example.atividaderomariorevisao.model.entities.Professor;
import lombok.Data;

import java.util.List;

@Data
public class DisciplinaDTO {
    private String nome;
    private List<Professor> listaDeProfessores;
}
