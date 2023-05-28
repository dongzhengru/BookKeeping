package com.xh229100226.bighomework;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {

    private Button btn_register1;
    private Button btn_exit1;
    private EditText edit_register;
    private EditText edit_setpassword;
    private EditText edit_resetpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn_exit1 = findViewById(R.id.btn_exit1);
        btn_register1 = findViewById(R.id.btn_register1);
        edit_register = findViewById(R.id.edit_register);
        edit_setpassword = findViewById(R.id.edit_setpassword);
        edit_resetpassword = findViewById(R.id.edit_resetpassword);
        btn_register1.setOnClickListener(v -> {
            String ed_Username = edit_register.getText().toString();
            String ed_UserPass = edit_setpassword.getText().toString();
            String ed_UserPass_2=edit_resetpassword.getText().toString();
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
                editor.commit();
                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });

        btn_exit1.setOnClickListener(v -> {
            Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
        });
    }

}

