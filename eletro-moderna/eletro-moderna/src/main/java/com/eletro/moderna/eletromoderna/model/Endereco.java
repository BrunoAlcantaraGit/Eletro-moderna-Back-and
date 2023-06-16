package com.eletro.moderna.eletromoderna.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false,length = 10)
    private String cep;
    @Column(nullable = false,length = 250)
    private String logradouro;
    @Column(nullable = false, length = 10)
    private String numero;
    private String complemento;
    @Column(nullable = false, length = 100)
    private String bairro;
    @Column(nullable = false,length = 2)
    private String uf;
    @Column(nullable = false, length = 50)
    private String localidade;
}
