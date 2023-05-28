package com.xh229100226.bighomework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Map<String, Object>> mData;
    private int mItemLayoutId;
    private String[] mFrom;
    private int[] mTo;

    public MyAdapter(List<Map<String, Object>> data, int itemLayoutId, String[] from, int[] to) {
        mData = data;
        mItemLayoutId = itemLayoutId;
        mFrom = from;
        mTo = to;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(mItemLayoutId, parent, false);
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = 200;
        view.setLayoutParams(params);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Map<String, Object> item = mData.get(position);
        for (int i = 0; i < mFrom.length; i++) {
            String key = mFrom[i];
            int viewId = mTo[i];
            String value = (String) item.get(key);
            TextView textView = holder.itemView.findViewById(viewId);
            textView.setText(value);
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}

