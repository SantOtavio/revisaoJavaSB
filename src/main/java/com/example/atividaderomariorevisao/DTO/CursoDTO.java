package com.example.atividaderomariorevisao.DTO;

import com.example.atividaderomariorevisao.model.entities.Disciplina;
import lombok.Data;

import java.util.List;

@Data
public class CursoDTO {
    private String nome;
    private List<Disciplina> listaDeDisciplinas;
}
