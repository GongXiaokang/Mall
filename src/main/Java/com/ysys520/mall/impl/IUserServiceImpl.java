package com.ysys520.mall.impl;

import com.ysys520.mall.dao.IUserDao;
import com.ysys520.mall.entity.User;
import com.ysys520.mall.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by hejingzhou on 2017/7/16.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class IUserServiceImpl implements IUserService {

    @Resource
    private IUserDao iUserDao;

    public void registerUser(String username, String password, String sex, String phone) {
        iUserDao.insertUserByUsernameAndPassword(username, password, sex, phone);
    }

    public User loginUser(String username, String password) {
        return iUserDao.selectUserByUsernameAndPassword(username,password);
    }
}
