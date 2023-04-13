package com.example.atividaderomariorevisao.repository;

import com.example.atividaderomariorevisao.model.entities.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
