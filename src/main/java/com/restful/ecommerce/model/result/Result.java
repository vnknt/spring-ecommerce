package com.restful.ecommerce.model.result;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
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

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
