package com.gustavo.cursospringboot.app.resources;

import com.gustavo.cursospringboot.app.domain.Cliente;
import com.gustavo.cursospringboot.app.dto.ClienteDTO;
import com.gustavo.cursospringboot.app.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping(value = "/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> find(@PathVariable Integer id) {
        Cliente obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT )
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDTO, @PathVariable Integer id){
        Cliente obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                                                     @RequestParam(value = "linesPerPage",defaultValue = "24") Integer linesPerPage,
                                                     @RequestParam(value = "orderBy",defaultValue = "nome") String orderBy,
                                                     @RequestParam(value = "direction",defaultValue = "ASC") String direction){
        Page<Cliente> list  = service.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> listDTO = list.map(cliente -> new ClienteDTO(cliente));
        return ResponseEntity.ok().body(listDTO);
    }
}
