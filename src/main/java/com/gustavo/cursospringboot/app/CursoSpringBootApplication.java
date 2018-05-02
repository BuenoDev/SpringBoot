package com.gustavo.cursospringboot.app;

import com.gustavo.cursospringboot.app.domain.Categoria;
import com.gustavo.cursospringboot.app.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CursoSpringBootApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringBootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Categoria> list = new ArrayList<Categoria>();
        list.add(new Categoria(null,"Informática"));
        list.add(new Categoria(null,"Escritório"));


        categoriaRepository.saveAll(list);
    }
}
