package com.jk.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserBean {
    private Integer id;
    private String phoneNumber;//手机号
    private String password;//密码
    private String types;//注册类型
    private String referrer;//推荐人
    private String companyName;//公司名称
    private String qqNumber;//关联的qq
    private String memberId;//推荐人会员ID
    private Integer sex;//性别 1男  2女
    private Integer usertype;//大类型,1发货方,2物流公司
    private String phoneMember;//会员号
    private String name;//真实名字
    private Double money;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date createTime;//注册日期
    private Integer remPwd;//记住密码

}
