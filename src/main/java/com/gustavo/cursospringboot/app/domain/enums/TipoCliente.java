package com.gustavo.cursospringboot.app.domain.enums;

public enum TipoCliente {

    PESSOA_FISICA(1,"Pessoa Física"),
    PESSOA_JURIDICA(2,"Pessoa Jurídica");

    private Integer cod;
    private  String desc;

    TipoCliente(Integer cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static TipoCliente toEnum(Integer cod){
        if(cod == null) return null;
        for(TipoCliente tipo : TipoCliente.values()){
            if(cod.equals(tipo.getCod())) return tipo;
        }
        throw new IllegalArgumentException("Id Inválido:"+cod);
    }
}
