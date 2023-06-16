package com.eletro.moderna.eletromoderna.repository;

import com.eletro.moderna.eletromoderna.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findClienteBydocumento(String documento);

    Optional<Cliente> deleteBydocumento(String documento);
}
