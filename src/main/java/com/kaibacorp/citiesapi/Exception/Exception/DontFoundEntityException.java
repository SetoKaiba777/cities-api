package com.kaibacorp.citiesapi.Exception.Exception;

public class DontFoundEntityException extends RuntimeException{
    private static final long serialVersionUID= 1L;

    public DontFoundEntityException(String msg) {
        super(msg);
    }
}
