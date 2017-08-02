package com.example.demo.iframework.login;

/**
 * @author ${mayong}
 *         创建时间 2017/8/2.
 */

public class LoginResponse {
    private int code = 1;
    private String msg = "请求成功";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
