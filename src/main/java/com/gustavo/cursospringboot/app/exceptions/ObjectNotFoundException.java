package com.gustavo.cursospringboot.app.exceptions;

/**
 * O melhor seria utilizar diretamente a runtime Exception
 * */
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg){
        super(msg);
    }
    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg,cause);
    }
}
