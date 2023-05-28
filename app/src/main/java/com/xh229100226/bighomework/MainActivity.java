package com.xh229100226.bighomework;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button btn_income= findViewById(R.id.btn_income);
        btn_income.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InsertIncomeActivity.class);
            startActivity(intent);
        });

        Button btn_pay= findViewById(R.id.btn_pay);
        btn_pay.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InsertOutActivity.class);
            startActivity(intent);
        });

        Button btn_myincome= findViewById(R.id.btn_myincome);
        btn_myincome.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, QueryIncomeActivity.class);
            startActivity(intent);
        });
        Button btn_mypay= findViewById(R.id.btn_mypay);
        btn_mypay.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, QueryOutActivity.class);
            startActivity(intent);
        });


        Button btn_update= findViewById(R.id.btn_update);
        btn_update.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, UpdateIncomeActivity.class);
            startActivity(intent);
        });
        Button btn_update2= findViewById(R.id.btn_update2);
        btn_update2.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, UpdateOutActivity.class);
            startActivity(intent);
        });

        Button btn_del= findViewById(R.id.btn_del);
        btn_del.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, DeleteIncomeActivity.class);
            startActivity(intent);
        });

        Button btn_del2= findViewById(R.id.btn_del2);
        btn_del2.setOnClickListener(v -> {
            Intent intent=new Intent(MainActivity.this, DeleteOutActivity.class);
            startActivity(intent);
        });

        Button btn_esc= findViewById(R.id.btn_esc);
        btn_esc.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        });

    }
}
