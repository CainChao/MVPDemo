package com.sung.mvpdemo.mode;

import android.os.Handler;
import android.text.TextUtils;

import com.sung.mvpdemo.OnLoginFinishedListener;

/**
 * Author YC
 * 2016/6/15 0015.
 */
public class LoginModelMpl implements LoginMModel {
    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if(TextUtils.isEmpty(username)){
                    listener.onUserNameError();
                    error = true;
                }
                if(TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if(!error){
                    listener.onSuccess();
                }

            }
        },2000);
    }
}
