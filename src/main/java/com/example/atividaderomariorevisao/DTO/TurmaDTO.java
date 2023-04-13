package com.example.atividaderomariorevisao.DTO;

import com.example.atividaderomariorevisao.model.entities.Aluno;
import com.example.atividaderomariorevisao.model.entities.Escola;
import lombok.Data;

import java.util.List;

@Data
public class TurmaDTO {
    private String nome;
    private Escola escola;
    private List<Aluno> listaDeAlunos;
}
