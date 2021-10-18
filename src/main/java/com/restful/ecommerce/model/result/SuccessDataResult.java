package com.restful.ecommerce.model.result;

public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data,  String message){
        super(data,true,message);
    }
    public SuccessDataResult(T data ){

        super(data,true);
    }
    public SuccessDataResult(){
        super(true);
    }
    public SuccessDataResult(String message){
        super(null,true,message);
    }

}
