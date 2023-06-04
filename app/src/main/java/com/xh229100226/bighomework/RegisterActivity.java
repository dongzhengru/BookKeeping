package com.xh229100226.bighomework;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    private Button reg;
    private Button exit;
    private EditText username;
    private EditText pwd1;
    private EditText pwd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        exit = findViewById(R.id.reg_exit);
        reg = findViewById(R.id.reg_reg);
        username = findViewById(R.id.reg_username);
        pwd1 = findViewById(R.id.reg_pwd1);
        pwd2 = findViewById(R.id.reg_pwd2);
        reg.setOnClickListener(this::onRegisterButtonClick);
        exit.setOnClickListener(this::onExitButtonClick);
    }

    private void onRegisterButtonClick(View v) {
        String ed_Username = username.getText().toString();
        String ed_UserPass = pwd1.getText().toString();
        String ed_UserPass_2= pwd2.getText().toString();
        if (ed_Username.equals("")) {
            Snackbar.make(v, "账号不能为空", Snackbar.LENGTH_SHORT).show();
        }else if (ed_UserPass.equals("")||ed_UserPass_2.equals("")){
            Snackbar.make(v, "密码不能为空", Snackbar.LENGTH_SHORT).show();
        } else if(!(ed_UserPass.equals(ed_UserPass_2))){
            Snackbar.make(v, "两次输入的密码不相等，请重新输入!", Snackbar.LENGTH_SHORT).show();
        }else{
            SharedPreferences sharedPreferences=getSharedPreferences("MyShare",MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("userName",ed_Username);
            editor.putString("userPass",ed_UserPass);
            editor.apply();
            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            finish();
        }
    }

    private void onExitButtonClick(View v) {
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}


