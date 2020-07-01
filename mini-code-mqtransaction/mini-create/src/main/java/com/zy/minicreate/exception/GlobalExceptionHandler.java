package com.zy.minicreate.exception;


import com.zy.minicreate.common.Result;
import com.zy.minicreate.common.ResultUtil;
import com.zy.minicreate.enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@ControllerAdvice(basePackages = {"com.zy"})
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result defaultExceptionHandler(Exception exception) {

        return ResultUtil.error(ErrorCodeEnum.BIZ_ERR.getCode(), exception.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public Result businessExceptionHandler(BusinessException ex) {

        return ResultUtil.error(ex.getCode(), ex.getMessage());
    }
}
