package com.gustavo.cursospringboot.app.repositories;

import com.gustavo.cursospringboot.app.domain.Cidade;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade,Integer> {
}
