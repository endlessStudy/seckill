package com.tearsmart.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 *
 * </p>
 * @author tear-smart
 * @date 2018-12-09
 */
@Controller
public class Index {
    @RequestMapping("/")
    public String test() {
        return "login";
    }
}
