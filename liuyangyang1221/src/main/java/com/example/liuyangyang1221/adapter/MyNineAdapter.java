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
import com.example.liuyangyang1221.bean.ShowBean;

import java.util.ArrayList;
import java.util.List;

public class MyNineAdapter extends RecyclerView.Adapter<MyNineAdapter.ViewHolder> {
    private List<ShowBean.DataBean> list=new ArrayList<>();
    private Context context;

    public MyNineAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<ShowBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyNineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.show_type1,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyNineAdapter.ViewHolder viewHolder, final int i) {
        //设置值
         viewHolder.textView.setText(list.get(i).getName());
         Glide.with(context).load(list.get(i).getIcon()).into(viewHolder.imageView);
        //长按吐司
        viewHolder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context,list.get(i).getIcon()+"",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       private ImageView imageView;
       private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.type1_image);
            textView=itemView.findViewById(R.id.type1_text);
        }
    }

    private Cilck cilck;

    public void setCilck(Cilck cilck) {
        this.cilck = cilck;
    }

    public interface Cilck{
        void itemCilck(int position);
    }
}
