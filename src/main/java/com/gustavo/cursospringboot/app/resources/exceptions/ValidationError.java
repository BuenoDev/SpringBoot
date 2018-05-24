package com.gustavo.cursospringboot.app.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {

    }

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
        this.errors = errors;
    }

    public List<FieldMessage> getErrors(){
        return this.errors;
    }

    public void addError(String fieldName, String message){
        errors.add(new FieldMessage(fieldName,message));
    }
}
