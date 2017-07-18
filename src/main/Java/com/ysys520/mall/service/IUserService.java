package com.ysys520.mall.service;


import com.ysys520.mall.entity.User;

/**
 * Created by hejingzhou on 2017/7/16.
 */
public interface IUserService {
    /**
     * 注册用户
     *
     * @param username 用户名
     * @param password 密码
     * @param sex      性别
     * @param phone    手机号
     * @return 这个用户数据
     */
    void registerUser(String username, String password, String sex, String phone);

    /**y用户登录
     * @param username
     * @param password
     * @return
     */
    User loginUser(String username, String password);
}
