package com.eletro.moderna.eletromoderna.repository;
import com.eletro.moderna.eletromoderna.model.Categoria;
import com.eletro.moderna.eletromoderna.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
List<Produto> findByCategoria(Optional<Categoria> categoria);
@Query(nativeQuery = true,value = "select * " +
        "from produto p " +
        "where p.preco > ?")
List<Produto> findByPreco(BigDecimal preco);
}
