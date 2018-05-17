package com.gustavo.cursospringboot.app.services;

import com.gustavo.cursospringboot.app.domain.Categoria;
import com.gustavo.cursospringboot.app.exceptions.DataIntegrityExeption;
import com.gustavo.cursospringboot.app.exceptions.ObjectNotFoundException;
import com.gustavo.cursospringboot.app.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        //return obj.orElse(null);
        return obj.orElseThrow(()->new ObjectNotFoundException(
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

    public void delete(Integer id){
        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityExeption("Nao é possivel excluir uma categoria que possua produtos.");
        }

    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }
}
