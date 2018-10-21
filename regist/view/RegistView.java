package com.bw.jingdong.regist.view;

import android.content.Context;

/**
 * Created by 择木 on 2018/10/18.
 */

public interface RegistView<T>{
    void success(T t);
    void failed(Exception e);
    String getUsername();
    String getPassword();
    String getConfirmPassword();
    void check(boolean isChecked,String msg);
    Context getContext();
    void dissmiss();
}
