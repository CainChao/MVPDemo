package com.sung.mvpdemo.presenter;

/**
 * Author YC
 * 2016/6/15 0015.
 *
 */
public interface LoginPresenter {
    void validCredentials(String username,String password);
    void onDestroy();
}
