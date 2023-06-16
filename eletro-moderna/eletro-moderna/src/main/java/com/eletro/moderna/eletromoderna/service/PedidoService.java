package com.eletro.moderna.eletromoderna.service;

import com.eletro.moderna.eletromoderna.model.Cliente;
import com.eletro.moderna.eletromoderna.model.Pedido;
import com.eletro.moderna.eletromoderna.model.Produto;
import com.eletro.moderna.eletromoderna.repository.ClienteRepository;
import com.eletro.moderna.eletromoderna.repository.PedidoRepository;
import com.eletro.moderna.eletromoderna.repository.ProdutoRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class PedidoService {
    PedidoRepository pedidoRepository;
    ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;
    private EntityManager entityManager;

    public Pedido realizarPedido(Pedido pedido) {

        List<Produto> produtos = pedido.getProduto();
        BigDecimal soma = BigDecimal.ZERO;

        for (Produto produto : produtos) {
            soma = soma.add(produto.getPreco());
        }
        pedido.setValorTotal(soma);
        return pedidoRepository.save(pedido);

    }

    public Pedido buscarPorIdCliente(Long id) throws Exception {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        return pedidoRepository.findByCliente(cliente);
    }

    public List<Pedido> ListarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido dataDaCompra(String dataCompra) {
        return pedidoRepository.findBydataCompra(dataCompra);
    }


    public Long valortotalPedidos() {
        return pedidoRepository.findByValorTotalPedidos();
    }


}
