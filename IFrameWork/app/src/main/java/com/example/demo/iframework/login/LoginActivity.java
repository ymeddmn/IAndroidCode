package com.example.demo.iframework.login;

import android.os.Bundle;
import android.widget.Toast;

import com.example.demo.iframework.R;
import com.example.mvplibrary.activity.base.MvpActivity;

public class LoginActivity extends MvpActivity<LoginPresenter> implements LoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this, this);
    }

    private void login(String userName, String pwd) {
        getPresenter().login(userName, pwd);

    }

    @Override
    public void successLogin(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
