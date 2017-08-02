package com.example.demo.iframework.login;

import android.content.Context;

import com.example.mvplibrary.Callback;
import com.example.mvplibrary.zpresenter.impl.PresenterActivityImpl;

/**
 * @author ${mayong}
 *         创建时间 2017/8/2.
 */

public class LoginPresenter extends PresenterActivityImpl<LoginModel, LoginView> {
    public LoginPresenter(Context context, LoginView view) {
        super(context, view);
    }

    @Override
    public LoginModel createModel() {
        return new LoginModel();
    }

    public void login(String userName, String pwd) {
        getModel().login(userName, pwd);
        getModel().setOnCallBackListener(new Callback() {
            @Override
            public void call(Object o, Object... s) {
                LoginResponse response = (LoginResponse) o;
                if (response.getCode() == 1) {
                    getView().successLogin(response.getMsg());
                }
            }

            @Override
            public void error(String msg) {

            }
        });
    }
}
