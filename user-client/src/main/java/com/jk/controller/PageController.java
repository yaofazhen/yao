package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /*蚂蚁前台登录*/
    @RequestMapping("main")
    public String mian(){
        return "main";
    }


    /*蚂蚁前台登录*/
    @RequestMapping("comLoginList")
    public String comLogin(){
        return "login";
    }
    /*点击注册去的两个注册页面*/
    @RequestMapping("regs")
    public String regs(){
        return "regs";
    }

    /*点击注册去的两个注册页面,发货方*/
    @RequestMapping("regsFaHuo")
    public String regsFaHuo(){
        return "faHuo";
    }

    /*点击注册去的两个注册页面,物流*/
    @RequestMapping("regsWuLiu")
    public String regsWuLiu(){
        return "wuLiu";
    }
}
