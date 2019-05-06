package com.jk.aspect;

import com.alibaba.fastjson.JSON;
import com.jk.MyLog;
import com.jk.pojo.LogLogin;
import com.jk.pojo.User;
import com.jk.utils.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LoginLogAspect {
@Autowired
private MongoTemplate mongoTemplate;
    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.jk.MyLog)")
    public void logPoinCut() {

    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        System.out.println("切面。。。。。");
        //保存日志
        LogLogin logLogin = new LogLogin();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null) {
            String value = myLog.value();
            logLogin.setOperation(value);//保存获取的操作
        }


        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        logLogin.setMethod(className + "." + methodName);

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);
        logLogin.setParams(params);

        logLogin.setCreateDate(new Date());
        //获取用户名
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = sra.getRequest();
        HttpSession session = request.getSession();
        User attribute = (User) session.getAttribute(session.getId());
        logLogin.setUsername(attribute.getName());
        //获取用户ip地址
        logLogin.setIp(IpUtils.getIpAddr(request));
        mongoTemplate.insert(logLogin);
    }
	//今天是个好日子
}
