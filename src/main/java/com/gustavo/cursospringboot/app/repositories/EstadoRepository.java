package com.gustavo.cursospringboot.app.repositories;

import com.gustavo.cursospringboot.app.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado,Integer> {
}
