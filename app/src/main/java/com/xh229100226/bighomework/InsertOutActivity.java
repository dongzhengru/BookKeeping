package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertOutActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_payid;
    private EditText et_money2;
    private EditText et_date2;
    private EditText et_type2;
    private EditText et_note2;
    private Button btn_surepay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_out);
        initView();
    }

    private void initView() {
        et_payid= findViewById(R.id.et_payid);
        et_money2= findViewById(R.id.et_money2);
        et_date2= findViewById(R.id.et_date2);
        et_type2= findViewById(R.id.et_type2);
        et_note2= findViewById(R.id.et_note2);
        btn_surepay= findViewById(R.id.btn_surepay);
        btn_surepay.setOnClickListener(this);
    }
    public void onClick(View v){
        String id=et_payid.getText().toString().trim();
        String money = et_money2.getText().toString().trim();
        String date = et_date2.getText().toString().trim();
        String type = et_type2.getText().toString().trim();
        String note = et_note2.getText().toString();
        Money o =new Money();
        o.id2 = id;
        o.money2 = money;
        o.date2 = date;
        o.type2 = type;
        o.note2 = note;
        MoneyDAO dao = new MoneyDAO(getApplicationContext());
        dao.open();
        long result = dao.addPay(o);
        if (result > 0) {
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
        }
        dao.close();
        finish();
    }

}
