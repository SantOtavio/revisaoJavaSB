package com.example.atividaderomariorevisao.repository;

import com.example.atividaderomariorevisao.model.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
