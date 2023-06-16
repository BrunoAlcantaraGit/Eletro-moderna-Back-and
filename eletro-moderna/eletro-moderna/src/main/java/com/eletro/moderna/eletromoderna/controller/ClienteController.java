package com.eletro.moderna.eletromoderna.controller;

import com.eletro.moderna.eletromoderna.model.Cliente;
import com.eletro.moderna.eletromoderna.model.Pedido;
import com.eletro.moderna.eletromoderna.service.ClienteService;
import com.eletro.moderna.eletromoderna.service.PedidoService;
import com.eletro.moderna.eletromoderna.service.ProdutoService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {
    ClienteService clienteService;
    EntityManager entityManager;



    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) throws Exception {
        try {
            return new ResponseEntity<>(clienteService.salvarCliente(cliente), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> listarCliente() throws Exception {
        try {
            return new ResponseEntity<>(clienteService.listarCliente(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deletar-tudo")
    public void deletarTudo() throws Exception {
        clienteService.deletarTudo();
    }

    @GetMapping("/buscar-id/{id}")
    public ResponseEntity<Optional<Cliente>> listarPorId(@PathVariable Long id) throws Exception {
        try {
            return new ResponseEntity<>(clienteService.listarPorId(id), HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deletar-id/{id}")
    public void deletarporID(@PathVariable Long id) {
        clienteService.deletarPorId(id);
    }

    @GetMapping("/consultar-doc/{doc}")
    public ResponseEntity<Optional<Cliente>> consultarPorDocumento(@PathVariable("doc") String documento) throws Exception {
        try {
            return new ResponseEntity<>(clienteService.consultarPorDocumento(documento), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Optional<Cliente>> atualziar(@RequestBody Cliente cliente, @PathVariable Long id) throws Exception {
        try {
            return new ResponseEntity<>(clienteService.atualizar(cliente, id), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Optional<Cliente>>(HttpStatus.NOT_FOUND);
        }

    }

    @Transactional
    @DeleteMapping("/dell-doc/{doc}")
    public ResponseEntity<Optional<Cliente>> deletarPorDoc(@PathVariable("doc") String documento) throws Exception {
        try {
            return new ResponseEntity<>(clienteService.deletarPorDoc(documento), HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}

