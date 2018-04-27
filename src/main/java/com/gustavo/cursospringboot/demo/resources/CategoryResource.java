package com.gustavo.cursospringboot.demo.resources;

import com.gustavo.cursospringboot.demo.domain.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listar(){

        List<Categoria> lista = new ArrayList<>();

        lista.add(new Categoria(1,"Informática"));
        lista.add(new Categoria(2,"Escritório"));

        return lista;
    }
}
