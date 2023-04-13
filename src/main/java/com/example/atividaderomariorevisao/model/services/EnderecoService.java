package com.example.atividaderomariorevisao.model.services;

import com.example.atividaderomariorevisao.model.entities.Endereco;
import com.example.atividaderomariorevisao.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public <S extends Endereco> S save(S entity) {
        return enderecoRepository.save(entity);
    }

    public Optional<Endereco> findById(Long aLong) {
        return enderecoRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return enderecoRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        enderecoRepository.deleteById(aLong);
    }
}
