package com.example.atividaderomariorevisao.controller;

import com.example.atividaderomariorevisao.DTO.EscolaDTO;
import com.example.atividaderomariorevisao.model.entities.Escola;
import com.example.atividaderomariorevisao.model.services.EscolaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/escola")
public class EscolaController {

    //Exemplo json cadastro escola: {
    //    "nome": "Escola ABC",
    //    "endereco": {"id": 2},
    //    "email": "escolaabc@educacao.com",
    //    "listaDeCursos":[
    //        {"id":1},{"id":2}
    //    ]
    //}

    @Autowired
    private EscolaService escolaService;

    @PostMapping()
    ResponseEntity<Object> cadastrarEscola(
            @RequestBody @Validated @Valid EscolaDTO escolaDTO
    ) {
        Escola escola = new Escola();
        BeanUtils.copyProperties(escolaDTO, escola);
        return ResponseEntity.ok(escolaService.save(escola));
    }

    @GetMapping()
    ResponseEntity<Object> listarEscolas() {
        return ResponseEntity.ok(escolaService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> listarEscolaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(escolaService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Object> atualizarEscola(
            @PathVariable Long id,
            @RequestBody @Validated @Valid EscolaDTO escolaDTO
    ) {
        Optional<Escola> escola = escolaService.findById(id);
        if (escola.isPresent()) {
            BeanUtils.copyProperties(escolaDTO, escola.get());
            return ResponseEntity.ok(escolaService.save(escola.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deletarEscola(@PathVariable Long id) {
        Optional<Escola> escola = escolaService.findById(id);
        if (escola.isPresent()) {
            escolaService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
