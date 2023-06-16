package com.eletro.moderna.eletromoderna.service;

import com.eletro.moderna.eletromoderna.model.Categoria;
import com.eletro.moderna.eletromoderna.model.Produto;
import com.eletro.moderna.eletromoderna.repository.CategoriaRepository;
import com.eletro.moderna.eletromoderna.repository.ProdutoRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Data
public class ProdutoService {
    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;
    private EntityManager entityManager;

    public Produto salvarProduto(Produto produto) throws Exception {
        Long categoriaId = produto.getCategoria().getId();
        Categoria buscarCategoria = entityManager.find(Categoria.class, categoriaId);

        if (buscarCategoria == null) {
            throw new Exception("Categoria não encontrada para o produto");

        } else {
            produto.setCategoria(buscarCategoria);
            return produtoRepository.save(produto);
        }

    }

    public List<Produto> listarProduto() throws Exception {
        List<Produto> resultado = produtoRepository.findAll();
        if (resultado.isEmpty()) {
            throw new Exception("Não existe produto cadastrado");
        } else {
            return resultado;
        }

    }

    public List<Produto> listarPorCategoria(Long id) throws Exception {
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isEmpty()) {
            throw new Exception("Categoria não encontrada");

        } else {
            return produtoRepository.findByCategoria(categoria);
        }

    }

    public void deletarProdutoId(Long id) {
        produtoRepository.deleteById(id);
    }

    public List<Produto> pesquisaPrecoProduto(BigDecimal preco) throws Exception {
        List<Produto> verificacao = produtoRepository.findByPreco(preco);
        if (verificacao.isEmpty()) {
            throw new Exception("Não existe nenhum produto com esse valor");
        } else {
            return produtoRepository.findByPreco(preco);
        }

    }
}