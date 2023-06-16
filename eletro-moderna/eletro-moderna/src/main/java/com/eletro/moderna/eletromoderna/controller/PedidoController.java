package com.eletro.moderna.eletromoderna.controller;

import com.eletro.moderna.eletromoderna.model.Pedido;
import com.eletro.moderna.eletromoderna.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {
    PedidoService pedidoService;

    @PostMapping("/salvar-pedido")
    public ResponseEntity<Pedido> adicionarPedido(@RequestBody Pedido pedido) {
        return new ResponseEntity<>(pedidoService.realizarPedido(pedido), HttpStatus.OK);
    }


    @GetMapping("/buscar-por-Idcliente/{id}")
    public ResponseEntity<Pedido> buscarPorIdCliente(@PathVariable Long id) throws Exception {
        try {
            return new ResponseEntity<>(pedidoService.buscarPorIdCliente(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listarTudo")
    public ResponseEntity<List<Pedido>> ListarTodosPedidos() {
        return new ResponseEntity<>(pedidoService.ListarTodosPedidos(), HttpStatus.OK);
    }

    @GetMapping("/buscar-por-data/{dataCompra}")
    public ResponseEntity<Pedido> dataDacompra(@PathVariable String dataCompra) {
        Pedido retorno = pedidoService.dataDaCompra(dataCompra);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

    @GetMapping("/total-pedidos")
    public ResponseEntity<Long> totalDePedidos() {
        Long retonor = pedidoService.valortotalPedidos();
        return new ResponseEntity<>(retonor, HttpStatus.OK);
    }

}
