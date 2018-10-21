package com.bw.jingdong.login.presenter;

import android.content.Intent;
import android.text.TextUtils;

import com.bw.jingdong.ICallBack.ICallBack;
import com.bw.jingdong.LoginActivity;
import com.bw.jingdong.RegistActivity;
import com.bw.jingdong.bean.Login;
import com.bw.jingdong.login.moble.LoginModel;
import com.bw.jingdong.login.view.LoginView;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by 择木 on 2018/10/18.
 */

public class LoginPresenter {
    private LoginView iv;
    private LoginModel loginModel;

    public void attach(LoginActivity iv){
        this.iv=iv;
        loginModel=new LoginModel();
    }

    public void detach(){
        if (iv!=null){
            iv=null;
        }
    }
    public void check(){
        if (TextUtils.isEmpty(iv.getUsername())){
            iv.check(false,"用户名不能为空");
        }else if (TextUtils.isEmpty(iv.getPassword())){
            iv.check(false,"密码不能为空");
        }else {
            iv.check(true,"");
        }
    }

    public void login(String url){
        String username = iv.getUsername();
        String password = iv.getPassword();
        url = url.concat("?mobile=").concat(username).concat("&password=").concat(password);
        Type type=new TypeToken<Login>(){}.getType();
        loginModel.login(url, new ICallBack() {
            @Override
            public void success(Object obj) {
                iv.success(obj);

                iv.gotoMain(obj);
            }




            @Override
            public void failure(Exception e) {
                iv.failure(e);
            }


        },type);
    }

    public void goRegist(){
        Intent intent=new Intent(iv.getContext(), RegistActivity.class);
        iv.getContext().startActivity(intent);
    }
}
