package com.bw.jingdong;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.jingdong.bean.Login;
import com.bw.jingdong.login.presenter.LoginPresenter;
import com.bw.jingdong.login.view.LoginView;

public class LoginActivity extends AppCompatActivity  implements LoginView<Login>, View.OnClickListener {

    private EditText edUsername;
    private EditText edPassWord;
    private Button btnLogin;
    private TextView btnRegist;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
        presenter = new LoginPresenter();
        presenter.attach(this);
    }

    private void initData() {
        btnLogin.setOnClickListener(this);
        btnRegist.setOnClickListener(this);
    }

    private void initView() {
        edUsername=findViewById(R.id.ed_username);
        edPassWord=findViewById(R.id.ed_password);
        btnLogin=findViewById(R.id.btn_login);
        btnRegist=findViewById(R.id.btn_regist);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                presenter.check();
                break;
            case R.id.btn_regist:
                presenter.goRegist();
                break;
        }
    }

    @Override
    public void success(Login login) {
        if (login!=null){
            Toast.makeText(this, login.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void failure(Exception e) {
        Toast.makeText(this, "网络异常" + e.getMessage(), Toast.LENGTH_SHORT).show();
    }



    @Override
    public String getUsername() {
        return edUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return edPassWord.getText().toString();
    }

    @Override
    public void check(boolean isChecked, String msg) {
        if (!isChecked){
            Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
        }else {
            presenter.login("https://www.zhaoapi.cn/user/login");
        }
    }
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void gotoMain(Login login) {
        if (login.getCode()==0){
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
