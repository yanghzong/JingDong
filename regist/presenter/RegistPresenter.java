package com.bw.jingdong.regist.presenter;

import android.text.TextUtils;

import com.bw.jingdong.ICallBack.ICallBack;
import com.bw.jingdong.bean.Regist;
import com.bw.jingdong.regist.model.RegistModel;
import com.bw.jingdong.regist.view.RegistView;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Created by 择木 on 2018/10/18.
 */

public class RegistPresenter {
    private RegistView iv;
    private RegistModel registModel;
    public void attach(RegistView iv){
        this.iv=iv;
        registModel=new RegistModel();
    }

    public void check(){
        String username = iv.getUsername();
        String password = iv.getPassword();
        String confirmPassword = iv.getConfirmPassword();
        if (TextUtils.isEmpty(username)){
            iv.check(false,"用户名不能为空");
        }else if (TextUtils.isEmpty(password)){
            iv.check(false,"密码不能为空");
        }else if (TextUtils.isEmpty(confirmPassword)){
            iv.check(false,"请再次输入密码");
        }else if (!confirmPassword.equals(password)){
            iv.check(false,"俩次密码不一致");
        }else {
            iv.check(true,"");
        }
    }

    public void Regist(String url){
        String username = iv.getUsername();
        String password = iv.getPassword();
        url=url.concat("?mobile=").concat(username).concat("&password=").concat(password);
        Type type=new TypeToken<Regist>(){}.getType();
        registModel.regist(url, new ICallBack() {
            @Override
            public void success(Object obj) {
                iv.success(obj);
                iv.dissmiss();
            }



            @Override
            public void failure(Exception e) {
                iv.failed(e);
            }
        },type);
    }

    public void detach(){
        if (iv!=null){
            iv=null;
        }
    }
}
