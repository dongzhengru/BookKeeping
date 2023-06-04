package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertIncomeActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText income_id;
    private EditText money;
    private EditText date;
    private EditText type;
    private EditText note;
    private Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_income);
        initView();
    }

    private void initView() {
        income_id = findViewById(R.id.insert_income_id);
        money = findViewById(R.id.insert_income_money);
        date = findViewById(R.id.insert_income_date);
        type = findViewById(R.id.insert_income_type);
        note = findViewById(R.id.insert_income_note);
        insert = findViewById(R.id.insert_income_insert);
        insert.setOnClickListener(this);
    }
    public void onClick(View v){
        String id= income_id.getText().toString().trim();
        String money = this.money.getText().toString().trim();
        String date = this.date.getText().toString().trim();
        String type = this.type.getText().toString().trim();
        String note = this.note.getText().toString();
        Money o =new Money();
        o.income_id =id;
        o.income_money =money;
        o.income_date = date;
        o.income_type = type;
        o.income_note = note;
        MoneyDAO dao = new MoneyDAO(getApplicationContext());
        dao.open();
        long result = dao.addIncome(o);
        if (result > 0) {
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
        }
        dao.close();
        finish();
    }
}
