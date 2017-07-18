package com.ysys520.mall.controller;

import com.google.gson.Gson;
import com.ysys520.mall.entity.Result;
import com.ysys520.mall.entity.User;
import com.ysys520.mall.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by hejingzhou on 2017/7/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService iUserService;

    private Gson mGson = new Gson();

    @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
    @ResponseBody
    public void registerUser(HttpServletRequest request, HttpServletResponse response) {
        String result = "";
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        if (username != null && password != null && sex != null && phone != null) {
            if (sex.equals("男") || sex.equals("女")) {
                System.out.println(sex);
                if (phone.length() != 11 || !phone.matches("^[0-9]*$")) {
                    result = mGson.toJson(new Result(1, "手机号不正确", new Date().toString()));
                    returnResult(response, result);
                }
                iUserService.registerUser(username, password, sex, phone);
                result = mGson.toJson(new Result(0, "注册成功", new Date().toString()));
                returnResult(response, result);
            } else {
                result = mGson.toJson(new Result(1, "性别数据错误", new Date().toString()));
                returnResult(response,result);
            }
        } else {
            result = mGson.toJson(new Result(1, "请完整信息", new Date().toString()));
            returnResult(response, result);
        }
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    @ResponseBody
    public Result loginUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String result;
        if (username != null && password != null) {
            User user = iUserService.loginUser(username, password);
            if (user != null) {
//                result = mGson.toJson(new Result(0, "登陆成功", new Date().toString()));
//                returnResult(response, result);
                return new Result(0, "登陆成功", new Date().toString());
            } else {
                result = mGson.toJson(new Result(1, "登录失败", new Date().toString()));
                returnResult(response, result);
            }
        } else {
            result = mGson.toJson(new Result(1, "登录失败", new Date().toString()));
            returnResult(response, result);
        }
        return new Result();
    }

    /**
     * String --->  sonJ 直接return 有问题
     * @param response
     * @param result
     */
    private void returnResult(HttpServletResponse response, String result) {
        try {
            response.getWriter().write(result);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
