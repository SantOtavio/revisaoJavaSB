package com.example.atividaderomariorevisao.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TURMA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turma {
    //o id (Long)
    //o nome (String)
    //o escola (Escola)
    //o listaDeAlunos (List<Aluno>)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @ManyToOne()
    @JoinColumn(name = "ESCOLA_ID")
    private Escola escola;

    @OneToMany()
    @JoinColumn(name = "TURMA_ID")
    private List<Aluno> listaDeAlunos;

}
