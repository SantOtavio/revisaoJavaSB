package com.example.atividaderomariorevisao.model.services;

import com.example.atividaderomariorevisao.model.entities.Curso;
import com.example.atividaderomariorevisao.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public <S extends Curso> S save(S entity) {
        return cursoRepository.save(entity);
    }

    public Optional<Curso> findById(Long aLong) {
        return cursoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return cursoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        cursoRepository.deleteById(aLong);
    }
}
