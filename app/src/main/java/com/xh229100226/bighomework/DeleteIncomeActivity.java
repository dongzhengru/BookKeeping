package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteIncomeActivity extends AppCompatActivity   implements View.OnClickListener{

    private Button search;
    private EditText del_id;
    private EditText money;
    private EditText date;
    private EditText type;
    private EditText note;
    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_income);
        initView();
    }

    private void initView() {
        del_id = findViewById(R.id.del_income_id);
        money = findViewById(R.id.del_income_money);
        date = findViewById(R.id.del_income_date);
        type = findViewById(R.id.del_income_type);
        note = findViewById(R.id.del_income_note);
        search = findViewById(R.id.del_income_search);
        delete = findViewById(R.id.del_income_del);
        search.setOnClickListener(this);
        delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.del_income_search:
                searchOrder();
                break;
            case R.id.del_income_del:
                deleteOrder();
                break;
        }

    }

    private void searchOrder() {
        String orderid= date.getText().toString().trim();
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        Money o=dao.getOrders(orderid);
        money.setText(o.income_money);
        del_id.setText(o.income_id);
        type.setText(o.income_type);
        note.setText(o.income_note);
        dao.close();
    }

    private void deleteOrder() {
        Money o = new Money();
        o.income_date = date.getText().toString().trim();
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        int result= dao.deletOrders(o);
        if(result>0) {
            Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "删除失败", Toast.LENGTH_SHORT).show();
        }
        dao.close();
    }
}
