package com.example.atividaderomariorevisao.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "DISCIPLINA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disciplina {

    //id (Long)
    //o nome (String)
    //o listaDeProfessores (List<Professor>)

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 50)
    private String nome;

    @ManyToMany()
    @JoinTable(name = "disciplina_professor",
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<Professor> listaDeProfessores;

}
