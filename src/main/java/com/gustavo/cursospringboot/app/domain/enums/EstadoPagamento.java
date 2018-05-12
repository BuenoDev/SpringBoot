package com.gustavo.cursospringboot.app.domain.enums;

public enum EstadoPagamento {
    PENDENTE(1,"Pendente"),
    QUITADO(2,"Quitado"),
    CANCELADO(3,"Cancelado");

    private Integer cod;
    private String desc;

    EstadoPagamento(Integer cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static EstadoPagamento toEnum(Integer cod){
        if(cod == null) return null;
        for(EstadoPagamento estado : EstadoPagamento.values()){
            if(cod.equals(estado.getCod())) return estado;
        }
        throw new IllegalArgumentException("Id Inválido:"+cod);
    }

}
