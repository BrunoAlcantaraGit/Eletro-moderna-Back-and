package com.eletro.moderna.eletromoderna.service;

import com.eletro.moderna.eletromoderna.model.Cliente;
import com.eletro.moderna.eletromoderna.repository.ClienteRepository;
import com.eletro.moderna.eletromoderna.repository.PedidoRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Data
public class ClienteService {
    ClienteRepository clienteRepository;
    PedidoRepository pedidoRepository;
    EntityManager entityManager;

    public Cliente salvarCliente(Cliente cliente) throws Exception {

        Optional<Cliente> retorno = clienteRepository.findClienteBydocumento(cliente.getDocumento());

        if (retorno.isEmpty()) {
            return clienteRepository.save(cliente);
        } else {
            throw new Exception("CNPJ já existe na base de dados");
        }

    }

    public List<Cliente> listarCliente() throws Exception {
        List<Cliente> resultado = clienteRepository.findAll();
        if (resultado.isEmpty()) {
            throw new Exception("Não existe dados a serem listados");
        } else {
            return resultado;
        }
    }

    public void deletarTudo() {
        clienteRepository.deleteAll();

    }


    public Optional<Cliente> listarPorId(Long id) throws Exception {
        Optional<Cliente> retorno = clienteRepository.findById(id);
        if (retorno.isEmpty()) {
            throw new Exception("usuário inexistente ou id inválido");
        } else {
            return retorno;
        }

    }

    public void deletarPorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> consultarPorDocumento(String documento) throws Exception {
        Optional<Cliente> consulta = clienteRepository.findClienteBydocumento(documento);

        if (consulta.isPresent()) {
            return consulta;
        } else {
            throw new Exception("Não existe cliente com o documento informado.");
        }
    }


    public Optional<Cliente> atualizar(Cliente cliente, Long id) throws Exception {
        Optional<Cliente> retorno = clienteRepository.findById(id);
        if (retorno.isPresent()) {
            return Optional.of(clienteRepository.save(cliente));
        } else {
            throw new Exception("Cliente inexistente, ou id inválido");
        }
    }

    public Optional<Cliente> deletarPorDoc(String documento) throws Exception {
        Optional<Cliente> verificar = clienteRepository.findClienteBydocumento(documento);
        if (verificar.isPresent()) {

            return clienteRepository.deleteBydocumento(documento);
        } else {

            throw new Exception("Documento inválido, ou cliente inexistente");
        }
    }




}



