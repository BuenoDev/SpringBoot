package com.gustavo.cursospringboot.app.repositories;

import com.gustavo.cursospringboot.app.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> { }
