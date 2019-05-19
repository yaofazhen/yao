package com.jk.controller;

import com.jk.pojo.RegType;
import com.jk.pojo.UserBean;
import com.jk.rmi.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserClient userClient;

    //登录完以后页面,点击注销按钮,注销
  /*  @RequestMapping("loginOut")
   public String loginOut(HttpServletRequest request) {
        return userClient.loginOut(request);
   }*/

    //判断手机号是否注册
    @RequestMapping("findUserByPhone")
    @ResponseBody
    public HashMap<String, Object> findUserByPhone(String phoneNumber) {
        return userClient.findUserByPhone(phoneNumber);
    }

    //短信验证码
    @RequestMapping("phoneTest")
    @ResponseBody
    public HashMap<String, Object> phoneTest(String phoneNumber) {
        return userClient.phoneTest(phoneNumber);
    }

    //用户注册类型
    @RequestMapping("findRegType")
    @ResponseBody
    public List<RegType> findRegType() {
        return userClient.findRegType();
    }

    //发货方 物流 注册
    @RequestMapping("reg")
    @ResponseBody
    public HashMap<String, Object> saveUser(UserBean userBean,String phonecode) {
        System.out.println(userBean.getTypes());
        return userClient.saveUser(userBean,phonecode);
    }

    // 前台登录+记住密码     usertype 1发货方,2物流公司
    @RequestMapping("login")
    @ResponseBody
    public HashMap<String, Object> login(UserBean userBean) {
        return userClient.login(userBean);
    }

    //后台登录+记住密码   usertype 1发货方,2物流公司
    @RequestMapping("comLogin")
    @ResponseBody
    public HashMap<String, Object> comLogin(UserBean userBean) {
        return userClient.comLogin(userBean);
    }
}