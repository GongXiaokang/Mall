package com.ysys520.mall.dao;

import com.ysys520.mall.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by hejingzhou on 2017/7/16.
 */
@Repository
public interface IUserDao {
    //    插入User
    void insertUserByUsernameAndPassword(@Param("userName") String userName, @Param("password") String password, @Param("sex") String sex, @Param("phone") String phone);

    User selectUserByUsernameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
