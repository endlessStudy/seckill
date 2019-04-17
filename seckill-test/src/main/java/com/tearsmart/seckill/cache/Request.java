package com.tearsmart.seckill.cache;

public interface Request {
    public void process();  
    public Integer getProductId();  
    public boolean isForceFefresh();  
}  