package com.gustavo.cursospringboot.app.repositories;


import com.gustavo.cursospringboot.app.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {
}
