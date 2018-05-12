package com.gustavo.cursospringboot.app.resources;

import com.gustavo.cursospringboot.app.domain.Cliente;
import com.gustavo.cursospringboot.app.services.ClienteService;

import com.gustavo.cursospringboot.app.domain.Cliente;
import com.gustavo.cursospringboot.app.services.ClienteService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Cliente obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}
