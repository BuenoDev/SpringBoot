package com.gustavo.cursospringboot.app.repositories;

import com.gustavo.cursospringboot.app.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
