package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateOutActivity extends AppCompatActivity   implements View.OnClickListener{
    private EditText update_id;
    private Button search;
    private EditText money;
    private EditText date;
    private EditText type;
    private EditText note;
    private Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_out);
        setTitle("更新收支");
        initView();
    }

    private void initView() {
        update_id = findViewById(R.id.et_orderid2);
        search = findViewById(R.id.del_out_search);

        money = findViewById(R.id.et_upmoney2);
        date = findViewById(R.id.et_update2);
        type = findViewById(R.id.et_uptype2);
        note = findViewById(R.id.et_upnote2);
        edit = findViewById(R.id.btn_edit2);

        search.setOnClickListener(this);
        edit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.del_out_search:
                searchOrder();
                break;
            case R.id.btn_edit2:
                updateOrder();
                break;
        }

    }
    private void searchOrder() {
        String orderid= date.getText().toString().trim();
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        Money o=dao.getPay(orderid);
        money.setText(o.out_money);
        update_id.setText(o.out_id);
        type.setText(o.out_type);
        note.setText(o.out_note);
        dao.close();
    }
    private void updateOrder() {
        Money o=new Money();
        o.out_id = update_id.getText().toString().trim();
        o.out_money = money.getText().toString().trim();
        o.out_date = date.getText().toString().trim();
        o.out_type = type.getText().toString().trim();
        o.out_note = note.getText().toString().trim();
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        long result= dao.updatePay(o);
        if(result>0) {
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "修改失败", Toast.LENGTH_SHORT).show();
        }
        dao.close();
    }
}
