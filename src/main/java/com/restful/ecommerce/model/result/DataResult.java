package com.restful.ecommerce.model.result;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class DataResult<T> extends Result{
    private T data;

    public DataResult(T data,boolean success,String message){
        super(success,message);
        this.data=data;
    }

    public DataResult(T data,boolean success){
        super(success);
        this.data=data;
    }

    public DataResult(boolean success){
        super(success);
    }

    public T getData() {
        return data;
    }
}
