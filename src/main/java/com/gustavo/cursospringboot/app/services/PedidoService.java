package com.gustavo.cursospringboot.app.services;

import com.gustavo.cursospringboot.app.domain.Cliente;
import com.gustavo.cursospringboot.app.domain.Pedido;
import com.gustavo.cursospringboot.app.exceptions.ObjectNotFoundException;
import com.gustavo.cursospringboot.app.repositories.ClienteRepository;
import com.gustavo.cursospringboot.app.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido buscar(Integer id){
        Optional<Pedido> obj = repository.findById(id);
        //return obj.orElse(null);
        return obj.orElseThrow(()->new ObjectNotFoundException(
                "Objeto nao encontrado! Id:"+id+", tipo:"+Pedido.class.getName()
        ));
    }
}
