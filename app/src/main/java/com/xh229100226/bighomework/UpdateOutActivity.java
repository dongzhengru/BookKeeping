package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateOutActivity extends AppCompatActivity   implements View.OnClickListener{
    private EditText et_orderid2;
    private Button btn_search2;
    private EditText et_upmoney2;
    private EditText et_update2;
    private EditText et_uptype2;
    private EditText et_upnote2;
    private Button btn_edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_out);
        setTitle("更新收支");
        initView();
    }

    private void initView() {
        et_orderid2= findViewById(R.id.et_orderid2);
        btn_search2= findViewById(R.id.btn_search2);

        et_upmoney2= findViewById(R.id.et_upmoney2);
        et_update2= findViewById(R.id.et_update2);
        et_uptype2= findViewById(R.id.et_uptype2);
        et_upnote2= findViewById(R.id.et_upnote2);
        btn_edit2= findViewById(R.id.btn_edit2);

        btn_search2.setOnClickListener(this);
        btn_edit2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_search2:
                searchOrder();
                break;
            case R.id.btn_edit2:
                updateOrder();
                break;
        }

    }
    private void searchOrder() {
        String orderid=et_update2.getText().toString().trim();
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        Money o=dao.getPay(orderid);
        et_upmoney2.setText(o.money2);
        et_orderid2.setText(o.id2);
        et_uptype2.setText(o.type2);
        et_upnote2.setText(o.note2);
        dao.close();
    }
    private void updateOrder() {
        Money o=new Money();
        o.id2 =et_orderid2.getText().toString().trim();
        o.money2 =et_upmoney2.getText().toString().trim();
        o.date2 =et_update2.getText().toString().trim();
        o.type2 =et_uptype2.getText().toString().trim();
        o.note2 =et_upnote2.getText().toString().trim();
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
