package com.eletro.moderna.eletromoderna.controller;

import com.eletro.moderna.eletromoderna.model.Categoria;
import com.eletro.moderna.eletromoderna.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {
    CategoriaService categoriaService;
@PostMapping("/salvar")
public ResponseEntity < Categoria> salvarCategoria(@RequestBody Categoria categoria){
    Categoria salvar = categoriaService.salvarCategoria(categoria);
    return new ResponseEntity<>(salvar, HttpStatus.CREATED);
}
}
