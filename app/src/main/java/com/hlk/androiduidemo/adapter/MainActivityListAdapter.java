package com.hlk.androiduidemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hlk.androiduidemo.R;
import com.hlk.androiduidemo.base.CommonContent;

/**
 * 主页列表项
 * Created by haokun on 2017/3/19.
 */

public class MainActivityListAdapter extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater inflater;

    public MainActivityListAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter_main_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int pos = position;
        ((MainActivityListAdapter.ViewHolder) holder).title.setText(CommonContent.COMMON_MAIN_LIST[position]);
        ((ViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CommonContent.COMMON_MAIN_LIST_CLASS[pos]);
            }
        });
    }


    private void startActivity(Class clas) {
        Intent intent = new Intent(context, clas);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return CommonContent.COMMON_MAIN_LIST.length;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;

        ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
