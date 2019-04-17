package com.tearsmart.seckill.cache;

import com.tearsmart.seckill.result.CodeMessage;
import com.tearsmart.seckill.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 ********************************************** 
 *  描述：提交更新请求 
 * Simba.Hua 
 * 2017年9月1日 
 ********************************************** 
**/  
@Controller("/inventory")
public class InventoryUpdateDBController {  
    private @Autowired
    InventoryProductBiz inventoryProductBiz;
    private @Autowired IRequestAsyncProcessBiz requestAsyncProcessBiz;  
    @RequestMapping("/updateDBInventoryProduct")
    @ResponseBody
    public Result updateDBInventoryProduct(InventoryProduct  inventoryProduct){
        Request request = new InventoryUpdateDBRequest(inventoryProduct,inventoryProductBiz);  
        requestAsyncProcessBiz.process(request);  
       return new Result(CodeMessage.SUCCESS);
    }  
}  