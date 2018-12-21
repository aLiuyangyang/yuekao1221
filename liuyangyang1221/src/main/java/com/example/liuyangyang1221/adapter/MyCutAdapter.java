package com.example.liuyangyang1221.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.liuyangyang1221.R;
import com.example.liuyangyang1221.bean.CutBean;

import java.util.ArrayList;
import java.util.List;

public class MyCutAdapter extends RecyclerView.Adapter<MyCutAdapter.ViewHolder> {
    private List<CutBean.DataBean> list=new ArrayList<>();
    private Context context;

    public MyCutAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<CutBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyCutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyCutAdapter.ViewHolder viewHolder, int i) {
        //设置子布局适配器
        MyZiadapter ziadapter=new MyZiadapter(context);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        viewHolder.recy.setLayoutManager(linearLayoutManager);
        //设置
        viewHolder.recy.setAdapter(ziadapter);
        ziadapter.setLists(list.get(i).getList());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
          RecyclerView recy;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recy=itemView.findViewById(R.id.recy);
        }
    }
}
