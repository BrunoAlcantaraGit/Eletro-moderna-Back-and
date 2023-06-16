package com.eletro.moderna.eletromoderna.repository;

import com.eletro.moderna.eletromoderna.model.Cliente;
import com.eletro.moderna.eletromoderna.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Pedido findByCliente(Optional<Cliente> cliente);
    Pedido findBydataCompra(String dataCompra);

    @Query(nativeQuery = true, value = "select count(*) from pedido p")
    Long findByValorTotalPedidos();

}
