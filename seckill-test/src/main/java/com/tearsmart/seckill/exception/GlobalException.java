package com.tearsmart.seckill.exception;

import com.sun.org.apache.bcel.internal.classfile.Code;
import com.tearsmart.seckill.result.CodeMessage;

/**
 * <p>
 * 全局的异常信息类
 * </p>
 * @author tear-smart
 * @date 2018-12-10
 */
public class GlobalException extends RuntimeException {

    private final CodeMessage codeMessage;
    public GlobalException(CodeMessage codeMessage) {
        this.codeMessage = codeMessage;
    }

    CodeMessage getCodeMessage() {
        return codeMessage;
    }

}
