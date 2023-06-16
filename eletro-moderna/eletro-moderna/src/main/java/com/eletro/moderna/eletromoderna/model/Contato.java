package com.eletro.moderna.eletromoderna.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 3)
    private String ddd;
    @Column(nullable = false, length = 13)
    private String numero;
    private String descricao;
    @Column(nullable = false,length = 150)
    private String email;
}
