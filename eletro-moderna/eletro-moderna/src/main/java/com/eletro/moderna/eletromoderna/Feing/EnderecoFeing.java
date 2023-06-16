package com.eletro.moderna.eletromoderna.Feing;

import com.eletro.moderna.eletromoderna.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//API que puxa o endereço via CEP
@FeignClient(url = "viacep.com.br/ws",name = "viacep")
public interface EnderecoFeing {
    @GetMapping("/{cep}/json")
    Endereco executa (@PathVariable ("cep") String cep);
}
