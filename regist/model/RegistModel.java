package com.bw.jingdong.regist.model;

import com.bw.jingdong.ICallBack.ICallBack;
import com.bw.jingdong.utils.HttpUtils;

import java.lang.reflect.Type;

/**
 * Created by 择木 on 2018/10/18.
 */

public class RegistModel {
    public void regist(String url, ICallBack callBack, Type type) {
        HttpUtils.getInstance().get(url,callBack,type);
    }
}
