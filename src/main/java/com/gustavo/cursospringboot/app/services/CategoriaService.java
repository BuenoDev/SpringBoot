package com.gustavo.cursospringboot.app.services;

import com.gustavo.cursospringboot.app.domain.Categoria;
import com.gustavo.cursospringboot.app.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        //return obj.orElse(null);
        return obj.orElseThrow(()->new RuntimeException(
                "Objeto nao encontrado! Id:"+id+", tipo:"+Categoria.class.getName()
        ));
    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Categoria obj){
        return repository.save(obj);
    }
}
