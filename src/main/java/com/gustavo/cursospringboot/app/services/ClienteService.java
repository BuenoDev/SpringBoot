package com.gustavo.cursospringboot.app.services;

import com.gustavo.cursospringboot.app.domain.Categoria;
import com.gustavo.cursospringboot.app.repositories.CategoriaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        //return obj.orElse(null);
        return obj.orElseThrow(()->new RuntimeException(
                "Objeto nao encontrado! Id:"+id+", tipo:"+Categoria.class.getName()
        ));
    }
}
