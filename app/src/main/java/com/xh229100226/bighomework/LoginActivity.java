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


public class LoginActivity extends AppCompatActivity implements OnClickListener {

    private EditText username;
    private EditText pwd;
    private Button login;
    private SharedPreferences mPref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberers;
    private Button reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        setupViews();

        reg.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, RegisterActivity.class)));

        mPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        restoreDataFromPreferences();

        login.setOnClickListener(this);
    }

    private void setupViews() {
        username = findViewById(R.id.login_username);
        pwd = findViewById(R.id.login_pwd);
        login = findViewById(R.id.login_login);
        rememberers = findViewById(R.id.remember);
        reg = findViewById(R.id.login_reg);
    }
    private void restoreDataFromPreferences() {
        boolean isRemember = mPref.getBoolean("remember_password", false);
        if (isRemember) {
            String account = mPref.getString("Name", "");
            String password = mPref.getString("Password", "");
            username.setText(account);
            pwd.setText(password);
            rememberers.setChecked(true);
        }
    }
    private void saveDataToPreferences(String account, String password, boolean remember) {
        editor = mPref.edit();
        if (remember) {
            editor.putBoolean("remember_password", true);
            editor.putString("Name", account);
            editor.putString("Password", password);
        } else {
            editor.clear();
        }
        editor.commit();
    }

    @Override
    public void onClick(View v) {
        String account = username.getText().toString();
        String password = pwd.getText().toString();
        SharedPreferences pre = getSharedPreferences("MyShare", MODE_PRIVATE);
        if (account.equals(pre.getString("userName", "")) && password.equals(pre.getString("userPass", ""))) {
            boolean rememberPass = rememberers.isChecked();
            saveDataToPreferences(account, password, rememberPass);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "用户名或密码不正确", Toast.LENGTH_LONG).show();
        }
    }
}
