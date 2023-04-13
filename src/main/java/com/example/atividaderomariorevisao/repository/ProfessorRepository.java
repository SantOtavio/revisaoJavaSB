package com.example.atividaderomariorevisao.repository;

import com.example.atividaderomariorevisao.model.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
