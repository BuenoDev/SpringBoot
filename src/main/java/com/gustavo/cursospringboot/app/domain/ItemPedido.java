package com.gustavo.cursospringboot.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ItemPedido implements Serializable {

    @EmbeddedId
    @JsonIgnore
    private ItemPedidoPK id;

    private Double desconto;
    private Integer quantidade;
    private Double preço;

    public ItemPedido(){}

    public ItemPedido(Pedido pedido,Produto produto, Double desconto, Integer quantidade, Double preço) {
        this.id = new ItemPedidoPK(pedido,produto);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preço = preço;
    }

    public ItemPedidoPK getId() {
        return id;
    }

    @JsonIgnore
    public Pedido getPedido(){
        return this.id.getPedido();
    }


    public Produto getProduto(){
        return this.id.getProduto();
    }

    private void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreço() {
        return preço;
    }

    public void setPreço(Double preço) {
        this.preço = preço;
    }
}
