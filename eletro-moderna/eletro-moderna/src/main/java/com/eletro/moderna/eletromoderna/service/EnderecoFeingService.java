package com.eletro.moderna.eletromoderna.service;

import com.eletro.moderna.eletromoderna.Feing.EnderecoFeing;
import com.eletro.moderna.eletromoderna.model.Endereco;
import com.eletro.moderna.eletromoderna.model.EnderecoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Data
public class EnderecoFeingService {
    EnderecoFeing enderecoFeing;
    public Endereco buscarEndereco (EnderecoRequest enderecoRequest){
      return enderecoFeing.executa(enderecoRequest.getCep());
    }
}


