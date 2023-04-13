package com.example.atividaderomariorevisao.controller;

import com.example.atividaderomariorevisao.DTO.ProfessorDTO;
import com.example.atividaderomariorevisao.model.entities.Professor;
import com.example.atividaderomariorevisao.model.services.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/professor")
public class ProfessorController {

    //exemplo de json de cadastro professor: {
    //    "nome": "AI Programador de Sistemas de Informação",
    //    "listaDeDisciplinas": [
    //        {"id":1},
    //        {"id":2}
    //    ]
    //}

    @Autowired
    ProfessorService professorService;

    @PostMapping()
    ResponseEntity<Object> cadastrarProfessor(
            @RequestBody @Validated @Valid ProfessorDTO professorDTO
    ) {
        Professor professor = new Professor();
        BeanUtils.copyProperties(professorDTO, professor);
        return ResponseEntity.ok(professorService.save(professor));
    }

    @GetMapping()
    ResponseEntity<Object> listarProfessores() {
        return ResponseEntity.ok(professorService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> listarProfessorPorId(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Object> atualizarProfessor(
            @PathVariable Long id,
            @RequestBody @Validated @Valid ProfessorDTO professorDTO
    ) {
        Optional<Professor> professor = professorService.findById(id);
        if (professor.isPresent()) {
            BeanUtils.copyProperties(professorDTO, professor.get());
            return ResponseEntity.ok(professorService.save(professor.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deletarProfessor(@PathVariable Long id) {
        Optional<Professor> professor = professorService.findById(id);
        if (professor.isPresent()) {
            professorService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
