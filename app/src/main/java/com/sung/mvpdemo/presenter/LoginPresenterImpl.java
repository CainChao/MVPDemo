package com.sung.mvpdemo.presenter;

import com.sung.mvpdemo.OnLoginFinishedListener;
import com.sung.mvpdemo.mode.LoginMModel;
import com.sung.mvpdemo.mode.LoginModelMpl;
import com.sung.mvpdemo.view.LoginView;

/**
 * Author YC
 * 2016/6/15 0015.
 * Presenter扮演着view和model的中间层的角色。
 * 获取model层的数据之后构建view层；也可以收到view层UI上的反馈命令后分发处理逻辑，
 * 交给model层做业务操作。它也可以决定View层的各种操作。
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {
    private LoginView loginView;
    private LoginMModel loginMModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginMModel = new LoginModelMpl();
    }

    @Override
    public void validCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginMModel.login(username, password, this);
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUserNameError() {
        if (loginView != null) {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navigateToHome();
        }
    }
}
