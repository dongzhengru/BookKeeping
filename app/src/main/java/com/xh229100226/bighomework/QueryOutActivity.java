package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;


import java.util.List;
import java.util.Map;

public class QueryOutActivity extends AppCompatActivity {
    RecyclerView recyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query_out);
        setTitle("查询收支");
        initView();
    }

    private void initView() {
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        List<Map<String,Object>> mOrderData=dao.getAllPay();
        if (mOrderData != null && mOrderData.size() > 0) {
            String[] from = {"id","money","date","type","note"};
            int[] to={R.id.tv_lst_orderid,R.id.tv_lst_username,R.id.tv_lst_name,R.id.tv_lst_price,R.id.tv_lst_amount};

            MyAdapter listItemAdapter = new MyAdapter(mOrderData, R.layout.item_list, from, to);
            recyclerView = findViewById(R.id.list_income);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(listItemAdapter);
        }
        dao.close();
    }
}
