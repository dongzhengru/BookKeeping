package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteOutActivity extends AppCompatActivity implements View.OnClickListener{

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
        setContentView(R.layout.delete_out);
        initView();
        }

    private void initView() {
        del_id = findViewById(R.id.del_out_id);
        money = findViewById(R.id.del_out_money);
        date = findViewById(R.id.del_out_date);
        type = findViewById(R.id.del_out_type);
        note = findViewById(R.id.del_out_note);
        search = findViewById(R.id.del_out_search);
        delete = findViewById(R.id.del_out_del);

        search.setOnClickListener(this);
        delete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.del_out_search:
                searchOrder();
                break;
            case R.id.del_out_del:
                deleteOrder();
                break;
        }

    }

    private void searchOrder() {
        String orderid= date.getText().toString().trim();
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        Money o=dao.getPay(orderid);
        money.setText(o.out_money);
        del_id.setText(o.out_id);
        type.setText(o.out_type);
        note.setText(o.out_note);
        dao.close();
    }

    private void deleteOrder() {
        Money o=new Money();
        o.out_date = date.getText().toString().trim();
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        int result= dao.deletPay(o);
        if(result>0) {
            Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "删除失败", Toast.LENGTH_SHORT).show();
        }
        dao.close();
    }
}
