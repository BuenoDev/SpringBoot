package com.gustavo.cursospringboot.app.repositories;

import com.gustavo.cursospringboot.app.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Integer> {
}
