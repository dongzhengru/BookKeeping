package com.xh229100226.bighomework;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import java.util.List;
import java.util.Map;

public class QueryOutActivity extends AppCompatActivity {
    ListView listView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_out);

        setTitle("查询收支");
        initView();
    }

    private void initView() {
        MoneyDAO dao=new MoneyDAO(getApplicationContext());
        dao.open();
        List<Map<String,Object>> mOrderData=dao.getAllPay();
        if (mOrderData != null && mOrderData.size() > 0) {
            listView=(ListView)findViewById(R.id.list_income);
            String[] from={"id","money","date","type","note"};
            int[] to={R.id.tv_lst_orderid,R.id.tv_lst_username,R.id.tv_lst_name,R.id.tv_lst_price,R.id.tv_lst_amount};
            SimpleAdapter listItemAdapter=new SimpleAdapter(QueryOutActivity.this,mOrderData,R.layout.item_list,from,to);
            listView.setAdapter(listItemAdapter);
        }
        dao.close();
    }
}
