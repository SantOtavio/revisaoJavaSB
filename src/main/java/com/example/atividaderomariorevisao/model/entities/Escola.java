package com.example.atividaderomariorevisao.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ESCOLA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Escola {

    //o id (Long)
    //o nome (String)
    //o endereco (Endereco)
    //o email (String) Validar
    //o listaDeProfessores (List<Professor>)
    //o listaDeCursos (List<Curso>)

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, name = "nome")
    private String nome;

    @OneToOne()
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Column(name = "email", length = 50)
    private String email;

    @OneToMany(mappedBy = "escola")
    private List<Professor> listaDeProfessores;

    @ManyToMany()
    @JoinTable(name = "escola_curso",
            joinColumns = @JoinColumn(name = "escola_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> listaDeCursos;
}
