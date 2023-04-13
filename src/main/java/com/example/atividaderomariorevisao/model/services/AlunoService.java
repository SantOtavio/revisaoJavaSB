package com.example.atividaderomariorevisao.model.services;

import com.example.atividaderomariorevisao.model.entities.Aluno;
import com.example.atividaderomariorevisao.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public <S extends Aluno> S save(S entity) {
        return alunoRepository.save(entity);
    }

    public Optional<Aluno> findById(Long aLong) {
        return alunoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return alunoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        alunoRepository.deleteById(aLong);
    }


}
