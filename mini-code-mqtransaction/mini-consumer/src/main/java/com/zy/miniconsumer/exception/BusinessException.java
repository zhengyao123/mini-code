package com.zy.miniconsumer.exception;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BusinessException extends RuntimeException {

    private Integer code;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}
