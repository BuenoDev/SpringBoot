package com.gustavo.cursospringboot.app.repositories;

import com.gustavo.cursospringboot.app.domain.Cidade;
import com.gustavo.cursospringboot.app.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
