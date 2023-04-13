package com.example.atividaderomariorevisao.repository;

import com.example.atividaderomariorevisao.model.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {


}
