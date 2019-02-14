package com.tearsmart.seckill.exception;

import com.tearsmart.seckill.result.CodeMessage;
import com.tearsmart.seckill.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 全局的异常处理类
 * </p>
 * @author tear-smart
 * @date 2018-12-10
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        e.printStackTrace();
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            return Result.error(globalException.getCodeMessage());
        } else if (e instanceof BindException) {
            BindException bind = (BindException) e;
            //返回出异常的方法
            // Map<String, Object> model = bind.getModel();
            List<ObjectError> errors = bind.getAllErrors();
            return Result.error(CodeMessage.BIND_EXCEPTION.fillArgs(errors.get(0).getDefaultMessage()));
        } else {
            return Result.error(CodeMessage.SERVER_ERROR);
        }
    }
}
