package com.sung.mvpdemo.view;

/**
 * Author YC
 * 2016/6/15 0015.
 * 登陆View的接口，实现类也就是登陆的activity
 */
public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUsernameError();
    void setPasswordError();
    void navigateToHome();
}
