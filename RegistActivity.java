package com.bw.jingdong;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.jingdong.bean.Regist;
import com.bw.jingdong.regist.presenter.RegistPresenter;
import com.bw.jingdong.regist.view.RegistView;

public class RegistActivity extends AppCompatActivity implements RegistView<Regist>, View.OnClickListener {

    private static final String TAG = "RegistActivity";
    private EditText eeUsername,eePassword,confirmPassword;
    private Button txtRegist;
    private RegistPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();
        initData();
        presenter=new RegistPresenter();
        presenter.attach(this);
        Log.i(TAG, "onCreate666: "+eeUsername);
    }

    private void initData() {
        txtRegist.setOnClickListener(this);
    }

    private void initView() {
        eeUsername=findViewById(R.id.ee_username);
        eePassword=findViewById(R.id.ee_password);
        confirmPassword=findViewById(R.id.confirm_password);
        txtRegist=findViewById(R.id.txt_regist);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txt_regist:
                presenter.check();
                break;
        }
    }

    @Override
    public void success(Regist regist) {
        Toast.makeText(this,regist.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failed(Exception e) {
        Toast.makeText(this,"网络异常",Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUsername() {
        return eeUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return eePassword.getText().toString();
    }

    @Override
    public String getConfirmPassword() {
        return confirmPassword.getText().toString();
    }

    @Override
    public void check(boolean isChecked, String msg) {
        if (!isChecked) {
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        }else {
            presenter.Regist("https://www.zhaoapi.cn/user/reg");
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void dissmiss() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detach();
        }
    }


}
