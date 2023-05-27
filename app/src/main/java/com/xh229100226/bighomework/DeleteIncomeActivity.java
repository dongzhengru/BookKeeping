package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteIncomeActivity extends AppCompatActivity   implements View.OnClickListener{

    private Button btn_delSearch;
    private EditText et_delid;
    private EditText et_delmoney;
    private EditText et_deldate;
    private EditText et_deltype;
    private EditText et_delnote;
    private Button btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_income);
        initView();
    }

    private void initView() {
        et_delid= (EditText) findViewById(R.id.et_delid);
        et_delmoney= (EditText) findViewById(R.id.et_delmoney);
        et_deldate= (EditText) findViewById(R.id.et_deldate);
        et_deltype= (EditText) findViewById(R.id.et_deltype);
        et_delnote= (EditText) findViewById(R.id.et_delnote);
        btn_delSearch= (Button) findViewById(R.id.btn_search);
        btn_delete= (Button) findViewById(R.id.btn_delete);

        btn_delSearch.setOnClickListener((View.OnClickListener) this);
        btn_delete.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.btn_search:
                searchOrder();
                break;
            case R.id.btn_delete:
                deleteOrder();
                break;
        }

    }

    private void searchOrder() {
        String orderid=et_deldate.getText().toString().trim();
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        Money o=dao.getOrders(orderid);
        et_delmoney.setText(o.money);
        et_delid.setText(o.id);
        et_deltype.setText(o.type);
        et_delnote.setText(o.note);
        dao.close();
    }

    private void deleteOrder() {
        Money o=new Money();
        o.date=et_deldate.getText().toString().trim();
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
