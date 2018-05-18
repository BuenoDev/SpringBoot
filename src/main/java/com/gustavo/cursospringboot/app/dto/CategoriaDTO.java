package com.gustavo.cursospringboot.app.dto;

import com.gustavo.cursospringboot.app.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "O campo nao pode ser nulo")
    @Length(min = 5, max = 25 , message = "Deve ser entre 5 e 25 caracteres")
    private String nome;


    private CategoriaDTO(){}

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
