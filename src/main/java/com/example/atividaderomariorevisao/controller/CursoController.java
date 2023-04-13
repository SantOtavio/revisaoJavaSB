package com.example.atividaderomariorevisao.controller;

import com.example.atividaderomariorevisao.DTO.CursoDTO;
import com.example.atividaderomariorevisao.model.entities.Curso;
import com.example.atividaderomariorevisao.model.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/curso")
public class CursoController {

    //exemplo de json para cadastro de curso: {
    //    "nome": "AI Programador de Sistemas de Informação",
    //    "listaDeDisciplinas": [
    //        {"id":1},
    //        {"id":2}
    //    ]
    //}

    @Autowired
    private CursoService cursoService;

    @PostMapping()
    ResponseEntity<Object> cadastrarCurso(
            @RequestBody @Validated @Valid CursoDTO cursoDTO
    ) {
        Curso curso = new Curso();
        BeanUtils.copyProperties(cursoDTO, curso);
        return ResponseEntity.ok(cursoService.save(curso));
    }

    @GetMapping()
    ResponseEntity<Object> listarCursos() {
        return ResponseEntity.ok(cursoService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> listarCursoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cursoService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Object> atualizarCurso(
            @PathVariable Long id,
            @RequestBody @Validated @Valid CursoDTO cursoDTO
    ) {
        Optional<Curso> curso = cursoService.findById(id);
        if (curso.isPresent()) {
            BeanUtils.copyProperties(cursoDTO, curso.get());
            return ResponseEntity.ok(cursoService.save(curso.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deletarCurso(@PathVariable Long id) {
        Optional<Curso> curso = cursoService.findById(id);
        if (curso.isPresent()) {
            cursoService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
