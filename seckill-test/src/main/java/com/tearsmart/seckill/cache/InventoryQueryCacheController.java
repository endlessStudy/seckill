package com.tearsmart.seckill.cache;

import com.tearsmart.seckill.exception.GlobalException;
import com.tearsmart.seckill.result.CodeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 ********************************************** 
 *  描述：提交查询请求 
 *  1、先从缓存中取数据 
 *  2、如果能从缓存中取到数据，则返回 
 *  3、如果不能从缓存取到数据，则等待20毫秒，然后再次去数据，直到200毫秒，如果超过200毫秒还不能取到数据，则从数据库中取，并强制刷新缓存数据 
 * @author Simba.Hua
 * 2017年9月1日 
 ********************************************** 
**/  
@Controller("/inventory")
public class InventoryQueryCacheController {  
    @Autowired
    private InventoryProductBiz inventoryProductBiz;
     @Autowired
     private IRequestAsyncProcessBiz requestAsyncProcessBiz;
    @RequestMapping("/queryInventoryProduct")
    public InventoryProduct queryInventoryProduct(Integer productId) {  
         Request request = new InventoryQueryCacheRequest(productId,inventoryProductBiz,false);  
         //加入到队列中
         requestAsyncProcessBiz.process(request);
         long startTime = System.currentTimeMillis();  
         long allTime = 0L;  
         long endTime;
         InventoryProduct inventoryProduct = null;
        while (allTime <= 200) {
            //如果超过了200ms,那就直接退出，然后从数据库中查询
            try {
                inventoryProduct = inventoryProductBiz.loadInventoryProductCache(productId);
                if (inventoryProduct != null) {
                    return inventoryProduct;
                } else {
                    //如果查询不到就等20毫秒
                    Thread.sleep(20);
                }
                endTime = System.currentTimeMillis();
                allTime = endTime - startTime;
            } catch (Exception e) {
                throw new GlobalException(CodeMessage.SERVER_ERROR);
            }
        }
         /*
          * 代码执行到这来，只有以下三种情况 
          * 1、缓存中本来有数据，由于redis内存满了，redis通过LRU算法清除了缓存，导致数据没有了 
          * 2、由于之前数据库查询比较慢或者内存太小处理不过来队列中的数据，导致队列里挤压了很多的数据，所以一直没有从数据库中获取数据然后插入到缓存中 
          * 3、数据库中根本没有这样的数据，这种情况叫数据穿透，一旦别人知道这个商品没有，如果一直执行查询，就会一直查询数据库，如果过多，那么有可能会导致数据库瘫痪 
          */
         inventoryProduct = inventoryProductBiz.loadInventoryProductByProductId(productId);  
         if (inventoryProduct != null) {  
             Request forceRrequest = new InventoryQueryCacheRequest(productId,inventoryProductBiz,true);
             //这个时候需要强制刷新数据库，使缓存中有数据
             requestAsyncProcessBiz.process(forceRrequest);
             return inventoryProduct;  
         }  
         return null;  
           
     }  
}  
