package com.example.liuyangyang1221.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.liuyangyang1221.R;
import com.example.liuyangyang1221.bean.CutBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyZiadapter extends RecyclerView.Adapter<MyZiadapter.ViewHolder> {
    private List<CutBean.DataBean.ListBean> list=new ArrayList<>();
    private Context context;
    private List<String> list1;

    public MyZiadapter(Context context) {
        this.context = context;
    }

    public void setLists(List<CutBean.DataBean.ListBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyZiadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.show_type2,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyZiadapter.ViewHolder viewHolder, final int i) {
        //设置值
        viewHolder.cut_text.setText(list.get(i).getTitle());
        viewHolder.cut_price.setText(list.get(i).getPrice()+"");
        //分割图片
        String images = list.get(i).getImages();
        String[] split = images.split("\\|");
        list1 = Arrays.asList(split);
        Glide.with(context).load(split[0]).into(viewHolder.cut_image);
        //长按吐司
        viewHolder.cut_image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, MyZiadapter.this.list1.get(i)+"",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView cut_image;
        private TextView cut_text,cut_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cut_image=itemView.findViewById(R.id.cut_image);
            cut_text=itemView.findViewById(R.id.cut_text);
            cut_price=itemView.findViewById(R.id.cut_price);
        }
    }
}
