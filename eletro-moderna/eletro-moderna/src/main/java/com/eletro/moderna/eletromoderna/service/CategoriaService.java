package com.eletro.moderna.eletromoderna.service;

import com.eletro.moderna.eletromoderna.model.Categoria;
import com.eletro.moderna.eletromoderna.repository.CategoriaRepository;
import com.eletro.moderna.eletromoderna.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Data
public class CategoriaService {
    CategoriaRepository categoriaRepository;
    ProdutoRepository produtoRepository;

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
