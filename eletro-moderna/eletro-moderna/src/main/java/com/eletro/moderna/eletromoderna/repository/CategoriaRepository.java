package com.eletro.moderna.eletromoderna.repository;

import com.eletro.moderna.eletromoderna.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
