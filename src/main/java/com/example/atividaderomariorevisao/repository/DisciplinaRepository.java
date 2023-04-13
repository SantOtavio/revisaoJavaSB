package com.example.atividaderomariorevisao.repository;

import com.example.atividaderomariorevisao.model.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {

}
