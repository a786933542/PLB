package com.example.administrator.plb.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.plb.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUsername;
    private EditText mPassword;
    private Button mLogin;
    private TextView mReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mLogin = (Button) findViewById(R.id.login);
        mReg = (TextView) findViewById(R.id.reg);
        mReg.setOnClickListener(this);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                submit();
                break;
            case R.id.reg:
                Intent intent=new Intent(LoginActivity.this,RegActivity.class);
                startActivityForResult(intent,1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==1 && resultCode==1){
            mUsername.setText(data.getStringExtra("username"));
        }
    }

    private boolean submit() {
        // validate
        String usernameString = mUsername.getText().toString().trim();
        if (TextUtils.isEmpty(usernameString)) {
            Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
            return false;
        }

        String passwordString = mPassword.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
