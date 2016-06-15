package com.sung.mvpdemo;

/**
 * Author YC
 * 2016/6/15 0015.
 * 登陆接口回调
 */
public interface OnLoginFinishedListener {
    void onUserNameError();
    void onPasswordError();
    void onSuccess();
}
