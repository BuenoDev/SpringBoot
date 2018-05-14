package com.gustavo.cursospringboot.app.repositories;

import com.gustavo.cursospringboot.app.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {
}
