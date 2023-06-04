package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateIncomeActivity extends AppCompatActivity  implements View.OnClickListener{
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
        setContentView(R.layout.update_income);
        setTitle("更新收支");
        initView();
    }

    private void initView() {
        update_id = findViewById(R.id.et_orderid);
        search = findViewById(R.id.del_income_search);

        money = findViewById(R.id.et_upmoney);
        date = findViewById(R.id.et_update);
        type = findViewById(R.id.et_uptype);
        note = findViewById(R.id.et_upnote);
        edit = findViewById(R.id.btn_edit);

        search.setOnClickListener(this);
        edit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.del_income_search:
                searchOrder();
                break;
            case R.id.btn_edit:
                updateOrder();
                break;
        }

    }
    private void searchOrder() {
        String orderid= date.getText().toString().trim();
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        Money o=dao.getOrders(orderid);
        money.setText(o.income_money);
        update_id.setText(o.income_id);
        type.setText(o.income_type);
        note.setText(o.income_note);
        dao.close();
    }
    private void updateOrder() {
        Money o=new Money();
        o.income_id = update_id.getText().toString().trim();
        o.income_money = money.getText().toString().trim();
        o.income_date = date.getText().toString().trim();
        o.income_type = type.getText().toString().trim();
        o.income_note = note.getText().toString().trim();
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        long result= dao.updateOrders(o);
        if(result>0) {
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "修改失败", Toast.LENGTH_SHORT).show();
        }
        dao.close();
    }
}
