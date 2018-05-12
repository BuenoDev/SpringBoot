package com.gustavo.cursospringboot.app.services;

import com.gustavo.cursospringboot.app.domain.Cliente;
import com.gustavo.cursospringboot.app.exceptions.ObjectNotFoundException;
import com.gustavo.cursospringboot.app.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        //return obj.orElse(null);
        return obj.orElseThrow(()->new ObjectNotFoundException(
                "Objeto nao encontrado! Id:"+id+", tipo:"+Cliente.class.getName()
        ));
    }
}
