package com.gustavo.cursospringboot.app.domain;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {
    private Integer id;
    private String nome;
    private Double preço;

    public Produto(){}

    public Produto(Integer id, String nome, Double preço) {
        this.id = id;
        this.nome = nome;
        this.preço = preço;
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

    public Double getPreco() {
        return preço;
    }

    public void setPreco(Double preço) {
        this.preço = preço;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) &&
                Objects.equals(nome, produto.nome) &&
                Objects.equals(preço, produto.preço);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, preço);
    }
}
