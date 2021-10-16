package com.restful.ecommerce.model.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Result {
    private String message;
    private boolean success;

    public Result(boolean success, String message){
        this.message=message;
        this.success=success;
    }

    public Result(boolean success){
        this.success=success;
    }
}
