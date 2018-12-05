package com.tearsmart.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *  样例
 * </p>
 * @author liuyl
 * @date 2018-12-05
 */
@Controller
@RequestMapping("/sample")
public class SampleController {
    @RequestMapping("/thy")
    public String thymeleaf(Model model){
        model.addAttribute("username", "tear-smart");
        return "/hello";
    }
}
