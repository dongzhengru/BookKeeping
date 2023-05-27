package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertIncomeActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_incomeid;
    private EditText et_money;
    private EditText et_date;
    private EditText et_type;
    private EditText et_note;
    private Button btn_sureincome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_income);
        initView();
    }

    private void initView() {
        et_incomeid= (EditText) findViewById(R.id.et_incomeid);
        et_money= (EditText) findViewById(R.id.et_money);
        et_date= (EditText) findViewById(R.id.et_date);
        et_type= (EditText) findViewById(R.id.et_type);
        et_note= (EditText) findViewById(R.id.et_note);
        btn_sureincome= (Button) findViewById(R.id.btn_sureincome);
        btn_sureincome.setOnClickListener(this);
    }
    public void onClick(View v){
        String id=et_incomeid.getText().toString().trim();
        String money = et_money.getText().toString().trim();
        String date = et_date.getText().toString().trim();
        String type = et_type.getText().toString().trim();
        String note = et_note.getText().toString();
        Money o =new Money();
        o.id=id;
        o.money=money;
        o.date = date;
        o.type = type;
        o.note = note;
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
