package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdateIncomeActivity extends AppCompatActivity  implements View.OnClickListener{
    private EditText et_orderid;
    private Button btn_search;

    private EditText et_upmoney;
    private EditText et_update;
    private EditText et_uptype;
    private EditText et_upnote;

    private Button btn_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_income);
        setTitle("更新收支");
        initView();
    }

    private void initView() {
        et_orderid= (EditText) findViewById(R.id.et_orderid);
        btn_search= (Button) findViewById(R.id.btn_search);

        et_upmoney= (EditText) findViewById(R.id.et_upmoney);
        et_update= (EditText) findViewById(R.id.et_update);
        et_uptype= (EditText) findViewById(R.id.et_uptype);
        et_upnote= (EditText) findViewById(R.id.et_upnote);
        btn_edit= (Button) findViewById(R.id.btn_edit);

        btn_search.setOnClickListener((View.OnClickListener) this);
        btn_edit.setOnClickListener((View.OnClickListener) this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_search:
                searchOrder();
                break;
            case R.id.btn_edit:
                updateOrder();
                break;
        }

    }
    private void searchOrder() {
        String orderid=et_update.getText().toString().trim();
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        Money o=dao.getOrders(orderid);
        et_upmoney.setText(o.money);
        et_orderid.setText(o.id);
        et_uptype.setText(o.type);
        et_upnote.setText(o.note);
        dao.close();
    }
    private void updateOrder() {
        Money o=new Money();
        o.id=et_orderid.getText().toString().trim();
        o.money=et_upmoney.getText().toString().trim();
        o.date=et_update.getText().toString().trim();
        o.type=et_uptype.getText().toString().trim();
        o.note=et_upnote.getText().toString().trim();
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
