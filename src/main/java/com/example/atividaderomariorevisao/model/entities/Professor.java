package com.example.atividaderomariorevisao.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "PROFESSOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor {

    //o id (Long)
    //o nome (String)
    //o email (String) Validar
    //o telefone (String)
    //o escola (Escola)
    //o listaDeDisciplinas (List<Disciplina>)
    //o endereco (Endereco)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "telefone", length = 50)
    private String telefone;

    @ManyToMany(mappedBy = "listaDeProfessores")
    @JsonIgnore
    private List<Disciplina> listaDeDisciplinas;

    @JoinColumn(name = "endereco")
    @ManyToOne()
    private Endereco endereco;

    @ManyToOne()
    @JoinColumn(name = "escola_id")
    @JsonIgnore
    private Escola escola;


}
