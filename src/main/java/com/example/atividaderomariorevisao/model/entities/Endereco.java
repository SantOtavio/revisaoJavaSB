package com.example.atividaderomariorevisao.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ENDERECO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    //o id (Long)
    //o rua (String)
    //o numero (Integer) Validar
    //o cidade (String)
    //o estado (String)
    //o bairro (String)
    //o cep (Long) Validar

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cep")
    private Long cep;
}
