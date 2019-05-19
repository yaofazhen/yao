/** 
 * <pre>项目名称:ssm-area-yfz 
 * 文件名称:ConstantConf.java 
 * 包名:com.jk.yfz 
 * 创建日期:2019年3月8日下午3:10:40 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */
package com.jk;


/** 
 * <pre>项目名称：ssm-area-yfz    
 * 类名称：ConstantConf    
 * 类描述：    
 * 创建人：姚法祯
 * 创建时间：2019年3月8日 下午3:10:40    
 * 修改人：姚法祯
 * 修改时间：2019年3月8日 下午3:10:40    
 * 修改备注：       
 * @version </pre>    
 */
public class ConstantConf {
public  static  final  String  SMS_URL="https://api.miaodiyun.com/20150822/industrySMS/sendSMS";//短信接口地址
public static final String ACCOUNTSID = "0374867b2c1844dbbe0bf019bf0def28";
public static final String AUTH_TOKEN = "d05d06f418974fc6aceb9233e38b7539";
public static final String TEMPLATEID = "164547838";//模板
public static final String SMS_SUCCESS="00000";
public static final String SMS_LOGIN_CODE="dlyzm";//短信验证码缓存
public static final Integer SMS_LOGIN_CODE_TIME_OUT=60;//短信验证码有效时间
public static final Integer SMS_LOGIN_LOCK_TIME_OUT=1;//短信验证码锁一分钟
public static final String SMS_LOGIN_LOCK="lock";//短信验证码不到一分钟不能再次获取的锁
    //cookie 保存的常量
public static final  String COOKIEUUID = "COOKIEJIAUUID";
    //记住密码的分隔
    public static final  String cookieNamePaw = "1810b";//勾选记住密码的标记
    public static final  String splitC = "sdfghj";//密码和用户之间的分割
}
