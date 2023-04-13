package com.example.atividaderomariorevisao.controller;

import com.example.atividaderomariorevisao.DTO.AlunoDTO;
import com.example.atividaderomariorevisao.model.entities.Aluno;
import com.example.atividaderomariorevisao.model.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*")
public class AlunoController {

    //exemplo de json para cadastro de aluno: {
    //    "nome": "Aluno 1",
    //    "email": "aluno1@gmail.com",
    //    "telefone": "(47) 9 1234-5678",
    //    "endereco": {"id":8}
    //}

    @Autowired
    AlunoService alunoService;

    @PostMapping()
    ResponseEntity<Object> cadastrarAluno(
            @RequestBody @Validated @Valid AlunoDTO alunoDTO
    ) {
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDTO, aluno);
        return ResponseEntity.ok(alunoService.save(aluno));
    }

    @GetMapping()
    ResponseEntity<Object> listarAlunos() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> listarAlunoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Object> atualizarAluno(
            @PathVariable Long id,
            @RequestBody @Validated @Valid AlunoDTO alunoDTO
    ) {
        Optional<Aluno> aluno = alunoService.findById(id);
        if (aluno.isPresent()) {
            BeanUtils.copyProperties(alunoDTO, aluno.get());
            return ResponseEntity.ok(alunoService.save(aluno.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deletarAluno(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoService.findById(id);
        if (aluno.isPresent()) {
            alunoService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
