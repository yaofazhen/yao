package com.jk.controller;

import com.jk.pojo.RegType;
import com.jk.pojo.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
   //登录完以后页面,点击退出按钮,退出
   /* @RequestMapping("loginOut")
    @ResponseBody
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();//获取session
        session.removeAttribute(session.getId());//移出账号
        return "login";//跳转到登录页面
    }*/

   //判断手机号是否注册
    @RequestMapping("findUserByPhone")
    @ResponseBody
    public HashMap<String, Object>  findUserByPhone(String phoneNumber) {
        return userService. findUserByPhone(phoneNumber);
    }

   //短信验证码
    @RequestMapping("phoneTest")
    @ResponseBody
    public HashMap<String, Object>  phoneTest(String phoneNumber) {
        return userService. phoneTest(phoneNumber);
    }

    //用户注册类型
    @RequestMapping("findRegType")
    @ResponseBody
    public List<RegType> findRegType(){
        List<RegType> list = userService.findRegType();
        return list;
    }
    //发货方 物流 注册
    @RequestMapping("reg")
    @ResponseBody
    public HashMap<String,Object> saveUser(@RequestBody UserBean userBean,String phonecode){
        return userService.saveUser(userBean,phonecode);
    }
    // 前台登录+记住密码     usertype 1发货方,2物流公司
    @RequestMapping("login")
    @ResponseBody
    public HashMap<String, Object> login(@RequestBody UserBean userBean) {
        return userService.login(userBean);
    }

    //后台登录+记住密码   usertype 1发货方,2物流公司
    @RequestMapping("comLogin")
    @ResponseBody
    public HashMap<String, Object> comLogin(@RequestBody UserBean userBean) {
        HashMap<String, Object> hashmap = new HashMap<>();
        if(userBean.getUsertype()== 1){
            hashmap.put("code",1);
            hashmap.put("msg","您没有权限登录");
            return hashmap;
        }
        //调前台登录的方法
        return userService.login(userBean);
    }
}
