package com.example.atividaderomariorevisao.controller;

import com.example.atividaderomariorevisao.DTO.TurmaDTO;
import com.example.atividaderomariorevisao.model.entities.Turma;
import com.example.atividaderomariorevisao.model.services.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/turma")
public class TurmaController {

    //exemplo de json para cadastro de turma: {
    //    "nome": "MI 70",
    //    "escola": { "id": 1},
    //    "listaDeAlunos": [
    //        { "id": 1},{"id":2}
    //    ]
    //}

    @Autowired
    TurmaService turmaService;

    @PostMapping()
    ResponseEntity<Object> cadastrarTurma(
            @RequestBody @Validated @Valid TurmaDTO turmaDTO
    ) {
        Turma turma = new Turma();
        BeanUtils.copyProperties(turmaDTO, turma);
        return ResponseEntity.ok(turmaService.save(turma));
    }

    @GetMapping()
    ResponseEntity<Object> listarTurmas() {
        return ResponseEntity.ok(turmaService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> listarTurmaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(turmaService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Object> atualizarTurma(
            @PathVariable Long id,
            @RequestBody @Validated @Valid TurmaDTO turmaDTO
    ) {
        Optional<Turma> turma = turmaService.findById(id);
        if (turma.isPresent()) {
            BeanUtils.copyProperties(turmaDTO, turma.get());
            return ResponseEntity.ok(turmaService.save(turma.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deletarTurma(@PathVariable Long id) {
        Optional<Turma> turma = turmaService.findById(id);
        if (turma.isPresent()) {
            turmaService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
