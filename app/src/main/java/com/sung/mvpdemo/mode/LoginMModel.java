package com.sung.mvpdemo.mode;

import com.sung.mvpdemo.OnLoginFinishedListener;

/**
 * Author YC
 * 2016/6/15 0015.
 */
public interface LoginMModel {
    void login(String username, String password, OnLoginFinishedListener listener);
}
