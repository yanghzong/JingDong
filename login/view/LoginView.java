package com.bw.jingdong.login.view;

import android.content.Context;

/**
 * Created by 择木 on 2018/10/18.
 */

public interface LoginView<T> {
    void success(T t);
    String getUsername();
    String getPassword();
    void check(boolean isChecked,String msg);
    Context getContext();
    void gotoMain(T t);

    void failure(Exception e);
}
