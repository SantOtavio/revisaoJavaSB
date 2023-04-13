package com.example.atividaderomariorevisao.controller;

import com.example.atividaderomariorevisao.DTO.EnderecoDTO;
import com.example.atividaderomariorevisao.model.entities.Endereco;
import com.example.atividaderomariorevisao.model.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    //exemplo de json de cadastro endereco: {
    //    "rua": "Rua Dez",
    //    "numero": 123,
    //    "cidade": "Santa Catarina",
    //    "estado": "SC",
    //    "bairro": "Centenário",
    //    "cep": 11111111
    //}

    @PostMapping()
    ResponseEntity<Object> cadastrarEndereco(
            @RequestBody @Validated @Valid EnderecoDTO enderecoDTO
    ) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDTO, endereco);
        return ResponseEntity.ok(enderecoService.save(endereco));
    }

    @GetMapping()
    ResponseEntity<Object> listarEnderecos() {
        return ResponseEntity.ok(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Object> listarEnderecoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Object> atualizarEndereco(
            @PathVariable Long id,
            @RequestBody @Validated @Valid EnderecoDTO enderecoDTO
    ) {
        Optional<Endereco> endereco = enderecoService.findById(id);
        if (endereco.isPresent()) {
            BeanUtils.copyProperties(enderecoDTO, endereco.get());
            return ResponseEntity.ok(enderecoService.save(endereco.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deletarEndereco(@PathVariable Long id) {
        Optional<Endereco> endereco = enderecoService.findById(id);
        if (endereco.isPresent()) {
            enderecoService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
