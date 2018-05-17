package com.gustavo.cursospringboot.app.resources;

import com.gustavo.cursospringboot.app.domain.Categoria;
import com.gustavo.cursospringboot.app.dto.CategoriaDTO;
import com.gustavo.cursospringboot.app.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = service.findAll();

        //Forma ensinada pelo curso
        List<CategoriaDTO> listDTO = list.stream().map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toList());

        //Como eu teria feito
        //List<CategoriaDTO> listDTO = new ArrayList<>();
        //for(Categoria cat : list) listDTO.add(new CategoriaDTO(cat));

        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> find(@PathVariable Integer id) {
        Categoria obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Categoria obj){
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().
                path("/{id}").
                buildAndExpand(obj).
                toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT )
    public ResponseEntity<Void> update(@RequestBody Categoria obj,@PathVariable Integer id){
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
