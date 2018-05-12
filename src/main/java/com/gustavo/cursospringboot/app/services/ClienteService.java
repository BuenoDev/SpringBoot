package com.gustavo.cursospringboot.app.services;

import com.gustavo.cursospringboot.app.domain.Cliente;
<<<<<<< HEAD
import com.gustavo.cursospringboot.app.exceptions.ObjectNotFoundException;
import com.gustavo.cursospringboot.app.repositories.ClienteRepository;
=======
import com.gustavo.cursospringboot.app.repositories.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
>>>>>>> a2b35d3a8e7b5423e0f332090ee321cf94ba7c22
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
<<<<<<< HEAD
        return obj.orElseThrow(()->new ObjectNotFoundException(
=======
        return obj.orElseThrow(()->new RuntimeException(
>>>>>>> a2b35d3a8e7b5423e0f332090ee321cf94ba7c22
                "Objeto nao encontrado! Id:"+id+", tipo:"+Cliente.class.getName()
        ));
    }
}
