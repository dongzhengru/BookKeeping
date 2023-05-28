package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteOutActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_delSearch2;
    private EditText et_delid2;
    private EditText et_delmoney2;
    private EditText et_deldate2;
    private EditText et_deltype2;
    private EditText et_delnote2;
    private Button btn_delete2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_out);
        initView();
        }

    private void initView() {
        et_delid2= findViewById(R.id.et_delid2);
        et_delmoney2= findViewById(R.id.et_delmoney2);
        et_deldate2= findViewById(R.id.et_deldate2);
        et_deltype2= findViewById(R.id.et_deltype2);
        et_delnote2= findViewById(R.id.et_delnote2);
        btn_delSearch2= findViewById(R.id.btn_search2);
        btn_delete2= findViewById(R.id.btn_delete2);

        btn_delSearch2.setOnClickListener(this);
        btn_delete2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.btn_search2:
                searchOrder();
                break;
            case R.id.btn_delete2:
                deleteOrder();
                break;
        }

    }

    private void searchOrder() {
        String orderid=et_deldate2.getText().toString().trim();
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        Money o=dao.getPay(orderid);
        et_delmoney2.setText(o.money2);
        et_delid2.setText(o.id2);
        et_deltype2.setText(o.type2);
        et_delnote2.setText(o.note2);
        dao.close();
    }

    private void deleteOrder() {
        Money o=new Money();
        o.date2=et_deldate2.getText().toString().trim();
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
