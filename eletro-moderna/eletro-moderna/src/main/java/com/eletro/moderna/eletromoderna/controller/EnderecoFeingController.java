package com.eletro.moderna.eletromoderna.controller;

import com.eletro.moderna.eletromoderna.service.EnderecoFeingService;
import com.eletro.moderna.eletromoderna.model.Endereco;
import com.eletro.moderna.eletromoderna.model.EnderecoRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/endereco")
public class EnderecoFeingController {
    EnderecoFeingService enderecoFeingService;

    @GetMapping("/buscar-cep")
    public ResponseEntity<Endereco> buscarEndereco(@RequestBody EnderecoRequest enderecoRequest) {
        return ResponseEntity.ok(enderecoFeingService.buscarEndereco(enderecoRequest));
    }
}