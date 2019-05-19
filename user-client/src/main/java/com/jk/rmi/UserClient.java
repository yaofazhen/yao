package com.jk.rmi;

import com.jk.pojo.RegType;
import com.jk.pojo.UserBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@FeignClient("USERSERVER")//调用生产者注入到注册中心的值
public interface UserClient {
    //登录完以后页面,点击注销按钮,注销
   /* @RequestMapping("loginOut")
    public String loginOut(HttpServletRequest request);*/

   //判断手机号是否注册
   @RequestMapping("findUserByPhone")
   public HashMap<String, Object>  findUserByPhone(@RequestParam("phoneNumber") String phoneNumber);

   //短信验证码
   @RequestMapping("phoneTest")
   public HashMap<String, Object> phoneTest(@RequestParam("phoneNumber") String phoneNumber);

   //用户注册类型
   @RequestMapping("findRegType")
   List<RegType> findRegType();

   //发货方 物流 注册
   @RequestMapping("reg")
   HashMap<String, Object> saveUser(@RequestBody UserBean userBean,@RequestParam("phonecode") String phonecode);

   // 前台登录+记住密码     usertype 1发货方,2物流公司
   @RequestMapping("login")
   /*@TimedInterrupt(value = 300L, unit = TimeUnit.SECONDS)*/
    HashMap<String, Object> login(@RequestBody UserBean userBean);

   //后台登录+记住密码   usertype 1发货方,2物流公司
   @RequestMapping("comLogin")
   HashMap<String, Object> comLogin(@RequestBody UserBean userBean);
}
