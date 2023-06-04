package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertOutActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText out_id;
    private EditText money;
    private EditText date;
    private EditText type;
    private EditText note;
    private Button out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_out);
        initView();
    }

    private void initView() {
        out_id = findViewById(R.id.insert_out_id);
        money = findViewById(R.id.insert_out_money);
        date = findViewById(R.id.insert_out_date);
        type = findViewById(R.id.insert_out_type);
        note = findViewById(R.id.insert_out_note);
        out = findViewById(R.id.insert_out_insert);
        out.setOnClickListener(this);
    }
    public void onClick(View v){
        String id= out_id.getText().toString().trim();
        String money = this.money.getText().toString().trim();
        String date = this.date.getText().toString().trim();
        String type = this.type.getText().toString().trim();
        String note = this.note.getText().toString();
        Money o =new Money();
        o.out_id = id;
        o.out_money = money;
        o.out_date = date;
        o.out_type = type;
        o.out_note = note;
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
