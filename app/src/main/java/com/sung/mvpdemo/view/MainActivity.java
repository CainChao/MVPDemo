package com.sung.mvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sung.mvpdemo.R;
import com.sung.mvpdemo.presenter.LoginPresenter;
import com.sung.mvpdemo.presenter.LoginPresenterImpl;

import java.nio.Buffer;

public class MainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    private EditText edit_username, edit_password;
    private Button login;
    private ProgressBar progress;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_username = (EditText) findViewById(R.id.edit_username);
        edit_password = (EditText) findViewById(R.id.edit_password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
        progress = (ProgressBar) findViewById(R.id.progress);
        presenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        edit_username.setError("用户名错误");
    }

    @Override
    public void setPasswordError() {
        edit_password.setError("密码错误");
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this.getApplication(), "登陆成功", Toast.LENGTH_SHORT).show();
        progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {
        presenter.validCredentials(edit_username.getText().toString().trim(),
                edit_password.getText().toString().trim());
    }
}
