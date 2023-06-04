package com.xh229100226.bighomework;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setButtonAction(R.id.main_income, InsertIncomeActivity.class);
        setButtonAction(R.id.main_out, InsertOutActivity.class);
        setButtonAction(R.id.main_search_income, QueryIncomeActivity.class);
        setButtonAction(R.id.main_search_out, QueryOutActivity.class);
        setButtonAction(R.id.main_del_income, DeleteIncomeActivity.class);
        setButtonAction(R.id.main_del_out, DeleteOutActivity.class);
        setButtonAction(R.id.main_edit_income, UpdateIncomeActivity.class);
        setButtonAction(R.id.main_edit_out, UpdateOutActivity.class);
        setButtonAction(R.id.main_exit, LoginActivity.class);
    }

    private void setButtonAction(int buttonId, Class activityClass) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, activityClass);
            startActivity(intent);
        });
    }
}
