package com.xh229100226.bighomework;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    private EditText et_username;
    private EditText et_userpwd;
    private Button btn_login;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberpass;
    private Button btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.et_username);
        et_userpwd = findViewById(R.id.et_userpwd);
        btn_login = findViewById(R.id.btn_login);
        rememberpass = findViewById(R.id.remember);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            String account = pref.getString("Name", "");
            String password = pref.getString("Password", "");
            et_username.setText(account);
            et_userpwd.setText(password);
            rememberpass.setChecked(true);
        }
        btn_login.setOnClickListener(v -> {
            String account = et_username.getText().toString();
            String password = et_userpwd.getText().toString();
            SharedPreferences pre = getSharedPreferences("MyShare", MODE_PRIVATE);
            if (account.equals(pre.getString("userName", "")) && password.equals(pre.getString("userPass", ""))) {
                editor = pref.edit();
                if (rememberpass.isChecked()) {
                    editor.putBoolean("remember_password", true);
                    editor.putString("Name", account);
                    editor.putString("Password", password);
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                } else {
                    editor.clear();
                }
                editor.commit();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "用户名或密码不正确", Toast.LENGTH_LONG).show();
            }
        });
    }
}
