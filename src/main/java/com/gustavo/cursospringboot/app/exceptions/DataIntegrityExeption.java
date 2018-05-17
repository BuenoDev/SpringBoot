package com.gustavo.cursospringboot.app.exceptions;

/**
 * O melhor seria utilizar diretamente a runtime Exception
 * */
public class DataIntegrityExeption extends RuntimeException {

    public DataIntegrityExeption(String msg){
        super(msg);
    }
    public DataIntegrityExeption(String msg, Throwable cause){
        super(msg,cause);
    }
}
