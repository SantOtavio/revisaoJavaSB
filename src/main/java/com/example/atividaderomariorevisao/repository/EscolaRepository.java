package com.example.atividaderomariorevisao.repository;

import com.example.atividaderomariorevisao.model.entities.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {

}
