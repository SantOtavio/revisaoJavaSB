package com.example.atividaderomariorevisao.model.services;

import com.example.atividaderomariorevisao.model.entities.Professor;
import com.example.atividaderomariorevisao.repository.ProfessorRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public <S extends Professor> S save(S entity) {
        return professorRepository.save(entity);
    }

    public Optional<Professor> findById(Long aLong) {
        return professorRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return professorRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        professorRepository.deleteById(aLong);
    }
}
