package com.tearsmart.seckill.cache;

public class InventoryQueryCacheRequest implements Request {
    private InventoryProductBiz inventoryProductBiz;  
    private Integer productId;  
    private boolean isForceFefresh;  
      
    public InventoryQueryCacheRequest(Integer productId,InventoryProductBiz inventoryProductBiz,boolean isForceFefresh) {  
        this.productId = productId;  
        this.inventoryProductBiz = inventoryProductBiz;  
        this.isForceFefresh = isForceFefresh;  
    }  
    @Override  
    public void process() {  
      InventoryProduct  inventoryProduct = inventoryProductBiz.loadInventoryProductByProductId(productId);  
      inventoryProductBiz.setInventoryProductCache(inventoryProduct);  
    }  
    @Override  
    public Integer getProductId() {  
        // TODO Auto-generated method stub  
        return productId;  
    }  
    public boolean isForceFefresh() {  
        return isForceFefresh;  
    }  
    public void setForceFefresh(boolean isForceFefresh) {  
        this.isForceFefresh = isForceFefresh;  
    }  
      
  
}  