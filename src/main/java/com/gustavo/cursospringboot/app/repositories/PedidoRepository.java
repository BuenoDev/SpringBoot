package com.gustavo.cursospringboot.app.repositories;

import com.gustavo.cursospringboot.app.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {
}
