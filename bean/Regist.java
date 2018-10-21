package com.bw.jingdong.bean;

import com.google.gson.Gson;

/**
 * Created by 择木 on 2018/10/18.
 */

public class Regist {
    /**
     * msg : 天呢！用户已注册
     * code : 1
     * data : {}
     */

    private String msg;
    private String code;
    private String data;

    public static Regist objectFromData(String str) {

        return new Gson().fromJson(str, Regist.class);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
