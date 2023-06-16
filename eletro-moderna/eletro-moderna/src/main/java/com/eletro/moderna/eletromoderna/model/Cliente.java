package com.eletro.moderna.eletromoderna.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente")
    private Long id;
    @Column(nullable = false, length = 250)
    private String nome;
    @Column(nullable = false, length = 20)
    private String documento;
    @Column(nullable = false, length = 10)
    private String dataNascimento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private List<Contato> contatos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private List<Endereco> enderecos;


}
