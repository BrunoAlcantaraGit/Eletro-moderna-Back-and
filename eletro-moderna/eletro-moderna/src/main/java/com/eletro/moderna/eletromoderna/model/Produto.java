package com.eletro.moderna.eletromoderna.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String cor;
    @ManyToOne
    private Categoria categoria;

    @ManyToMany
    private List<Pedido> pedidos;

}