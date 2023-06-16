package com.eletro.moderna.eletromoderna.controller;

import com.eletro.moderna.eletromoderna.model.Produto;
import com.eletro.moderna.eletromoderna.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    ProdutoService produtoService;

    @PostMapping("/salvar")
    public ResponseEntity<Produto> saltavar(@RequestBody Produto produto) throws Exception {
        try {
            return new ResponseEntity<>(produtoService.salvarProduto(produto), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listarProdutos() throws Exception {
        try {
            return (new ResponseEntity<>(produtoService.listarProduto(), HttpStatus.OK));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/listar-categoria/{id}")
    public ResponseEntity<List<Produto>> listarPorCategoria(@PathVariable Long id) throws Exception {
        try {
            List<Produto> categoriaId = produtoService.listarPorCategoria(id);
            return new ResponseEntity<>(categoriaId, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deletar-produto/{id}")
    public void deletarProdutoId(@PathVariable Long id) {
        produtoService.deletarProdutoId(id);
    }
    @GetMapping("pesquisar-produto-preco/{valor}")
    public ResponseEntity<List<Produto>> pesquisaPrecoProduto(@PathVariable ("valor") BigDecimal preco) throws Exception{
       try{
          return new ResponseEntity<>(produtoService.pesquisaPrecoProduto(preco),HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

    }
}


