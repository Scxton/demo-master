package com.example.demo.utils;


import java.io.Serializable;

/**
 *  200  表示成功
 *  500  表示未知错误
 *  1000~1999  表示参数错误   1001:参数为空，1002:参数为空，1003:参数类型错误，1004:参数缺失
 *  2000~2999  表示用户错误    2001:用户未登录，2002:账号已过期，2003:密码过期，2004:密码错误，2005:账号不可用，2006:账号被锁定，2007:账号已存在，2008:账号已下线，2009:账号异地登录，2010:账号不存在，
 *  3000~3999   表示接口错误   3001:没有权限,
 */


public class JSONResult implements Serializable {

    private String type;    //
    private int resultCode;     //结果码
    private String resultMsg;   //结果描述
    private Object data;   //结果数据

    public static JSONResult build() {
        return new JSONResult();
    }

    public JSONResult() {
    }

    public JSONResult(String type, int code, String msg, Object object) {
        this.type = type;
        this.resultCode = code;
        this.resultMsg = msg;
        this.data = object;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JSONResult ok(String msg, Object object) {
        return new JSONResult("success",200,msg,object);
    }

    public static JSONResult error(int code,String msg) {
        return new JSONResult("error",code,msg, null);
    }
}

