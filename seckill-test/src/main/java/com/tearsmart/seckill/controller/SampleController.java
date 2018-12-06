package com.tearsmart.seckill.controller;

import com.tearsmart.seckill.result.CodeMessage;
import com.tearsmart.seckill.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  样例
 * </p>
 * @author liuyl
 * @date 2018-12-05
 */
@Controller
@RequestMapping("sample")
public class SampleController {
    @RequestMapping("thy")
    public String thymeleaf(Model model){
        model.addAttribute("username", "tear-smart");
        return "hello";
    }
    @RequestMapping("result")
    @ResponseBody
    public Result result(){
        // return Result.success("Success!");
        return Result.error(CodeMessage.SERVER_ERROR);
    }
}
