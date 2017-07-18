package com.ysys520.mall.entity;

/**
 * Created by hejingzhou on 2017/7/16.
 */
public class Result {
    private int errorCode;
    private String msg;
    private String date;

    public Result() {
    }

    public Result(int errorCode, String msg, String date) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.date = date;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
