package com.example.atividaderomariorevisao.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "ALUNO")
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    //o id (Long)
    //o nome (String)
    //o email (String) Validar
    //o telefone (String)
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

    @JoinColumn(name = "endereco")
    @OneToOne()
    private Endereco endereco;
}
