package com.example.atividaderomariorevisao.controller;

import com.example.atividaderomariorevisao.DTO.DisciplinaDTO;
import com.example.atividaderomariorevisao.model.entities.Disciplina;
import com.example.atividaderomariorevisao.model.services.DisciplinaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping()
    ResponseEntity<Object> cadastrarDisciplina(
            @RequestBody @Validated @Valid DisciplinaDTO disciplinaDTO
    ) {
        Disciplina disciplina = new Disciplina();
        BeanUtils.copyProperties(disciplinaDTO, disciplina);
        return ResponseEntity.ok(disciplinaService.save(disciplina));
    }

    @GetMapping()
    ResponseEntity<Object> listarDisciplinas() {
        return ResponseEntity.ok(disciplinaService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> listarDisciplinaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(disciplinaService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Object> atualizarDisciplina(
            @PathVariable Long id,
            @RequestBody @Validated @Valid DisciplinaDTO disciplinaDTO
    ) {
        Optional<Disciplina> disciplina = disciplinaService.findById(id);
        if (disciplina.isPresent()) {
            BeanUtils.copyProperties(disciplinaDTO, disciplina.get());
            return ResponseEntity.ok(disciplinaService.save(disciplina.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deletarDisciplina(@PathVariable Long id) {
        Optional<Disciplina> disciplina = disciplinaService.findById(id);
        if (disciplina.isPresent()) {
            disciplinaService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
