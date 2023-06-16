package com.eletro.moderna.eletromoderna.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreationTimestamp
    private String dataCompra;
    private BigDecimal valorTotal;

    @ManyToOne
    Cliente cliente;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Produto> produto;



}
