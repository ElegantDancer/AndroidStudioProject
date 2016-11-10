package com.iqiyi.zhenzhen.mvpdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import presenter.UserLoginPresenter;

public class MainActivity extends AppCompatActivity implements ILoginView, View.OnClickListener{

    private EditText userName;
    private EditText passport;
    private Button loginBtn;
    private Button clearBtn;
    private ProgressDialog dialog;
    private UserLoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        userName = (EditText) findViewById(R.id.user_name);
        passport = (EditText) findViewById(R.id.user_passport);
        loginBtn = (Button) findViewById(R.id.login_btn);
        clearBtn = (Button) findViewById(R.id.clear_btn);
        loginBtn.setOnClickListener(this);
        clearBtn.setOnClickListener(this);
        dialog = new ProgressDialog(this);
        dialog.setTitle("登录ing");
        presenter = new UserLoginPresenter(this);
    }

    @Override
    public String getUserName() {
        return userName.getText().toString();
    }

    @Override
    public String getPassport() {
        return passport.getText().toString();
    }

    @Override
    public void toMainActivity() {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }

    @Override
    public void showFailError() {

        Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        dialog.show();
    }

    @Override
    public void hideLoading() {
        dialog.hide();
    }

    @Override
    public void clearUserName() {
        userName.setText("");
    }

    @Override
    public void clearPassport() {
        passport.setText("");
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.login_btn:
                presenter.login();

                break;
            case R.id.clear_btn:
                presenter.clear();
                break;
            default:
                break;
        }
    }
}
