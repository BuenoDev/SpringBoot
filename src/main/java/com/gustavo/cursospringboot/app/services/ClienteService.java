package com.gustavo.cursospringboot.app.services;

import com.gustavo.cursospringboot.app.domain.Cliente;
import com.gustavo.cursospringboot.app.dto.ClienteDTO;
import com.gustavo.cursospringboot.app.exceptions.DataIntegrityExeption;
import com.gustavo.cursospringboot.app.exceptions.ObjectNotFoundException;
import com.gustavo.cursospringboot.app.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        //return obj.orElse(null);
        return obj.orElseThrow(()->new ObjectNotFoundException(
                "Objeto nao encontrado! Id:"+id+", tipo:"+Cliente.class.getName()
        ));
    }

    public Cliente update(Cliente obj){
        Cliente newObj =  find(obj.getId());
        updateData(newObj,obj);
        return repository.save(obj);
    }

    private void updateData(Cliente newObj, Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

    public void delete(Integer id){
        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityExeption("Nao é possivel excluir cliente que há entidades relacionadas.");
        }

    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page,linesPerPage,Sort.Direction.valueOf(direction),orderBy);
        return repository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO DTO){
        return new Cliente(DTO.getId(),DTO.getNome(),DTO.getEmail(),null,null);
    }
}
