package com.tearsmart.seckill.service.impl;

import com.tearsmart.seckill.exception.GlobalException;
import com.tearsmart.seckill.result.CodeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2019-01-24
 */
@Service
@Slf4j
public class AsyncServiceImpl {

    public void test(){
        asyncInvokeSimplest();
    }

      /**
     * 最简单的异步调用，返回值为void
     */
    @Async
    public void asyncInvokeSimplest() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new GlobalException(CodeMessage.SERVER_ERROR);
        }
        log.info("asyncSimplest");
    }

    /**
     * 带参数的异步调用 异步方法可以传入参数
     *
     * @param s
     */
    @Async
    public void asyncInvokeWithParameter(String s) {
        log.info("asyncInvokeWithParameter, parementer={}", s);
    }

    /**
     * 异常调用返回Future
     *
     * @param i
     * @return
     */
    @Async
    public Future<String> asyncInvokeReturnFuture(int i) {
        log.info("asyncInvokeReturnFuture, parementer={}", i);
        Future<String> future;
        try {
            Thread.sleep(1000 * 1);
            future = new AsyncResult<String>("success:" + i);
        } catch (InterruptedException e) {
            future = new AsyncResult<String>("error");
        }
        return future;
    }
}
