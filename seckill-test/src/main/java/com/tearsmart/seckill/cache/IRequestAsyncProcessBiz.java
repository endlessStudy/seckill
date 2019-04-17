package com.tearsmart.seckill.cache;

/**
 ********************************************** 
 *  描述：请求异步处理接口，用于路由队列并把请求加入到队列中 
 * Simba.Hua 
 * 2017年8月30日 
 ********************************************** 
**/  
public interface IRequestAsyncProcessBiz {  
    void process(Request request);  
}  