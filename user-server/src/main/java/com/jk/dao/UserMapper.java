package com.jk.dao;

import com.jk.pojo.RegType;
import com.jk.pojo.UserBean;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    UserBean findUserByPhone(String phoneNumber);

    List<RegType> findRegType();

    void saveOneUser(UserBean userBean);

    void saveComUser(UserBean userBean);

    /*判断用户名密码是否正确*/
    @Select("select * from t_user where phoneNumber=#{phoneNumber} and password=#{password}")
    UserBean getUserByPasPhone(UserBean userBean);
}
