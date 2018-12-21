package com.example.liuyangyang1221.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.liuyangyang1221.OverScanActivity;
import com.example.liuyangyang1221.R;
import com.example.liuyangyang1221.adapter.MyCutAdapter;
import com.example.liuyangyang1221.adapter.MyNineAdapter;
import com.example.liuyangyang1221.bean.CutBean;
import com.example.liuyangyang1221.bean.ShowBean;
import com.example.liuyangyang1221.presenter.Presenterlmpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.liuyangyang1221.R.id.gridrecy_cut;

public class MyShow extends Fragment implements View.OnClickListener,IView{
    private ImageView show_scan,mycut;
    private MyView titleview;
    private int UId_UI=90;
    private String ShowUrl="http://www.zhaoapi.cn/product/getCatagory";
    private String CutUrl="http://www.zhaoapi.cn/product/getCarts";
    private Presenterlmpl presenterlmpl;
    private RecyclerView recy_nine,recy_cut,gridrecy_cut;
    private MyNineAdapter nineadapter;
    private MyCutAdapter cutadapter;
    private int mCunt=5;
    private int i=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.show, container,false);
        //获取资源id
        show_scan=view.findViewById(R.id.show_scan);
        recy_nine=view.findViewById(R.id.recy_nine);
         mycut=view.findViewById(R.id.mycut);
        mycut.setOnClickListener(this);
        titleview=view.findViewById(R.id.titleview);
        gridrecy_cut=view.findViewById(R.id.gridrecy_cut);
        recy_cut=view.findViewById(R.id.recy_cut);
        show_scan.setOnClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenterlmpl=new Presenterlmpl(this);
        //实例化
        nineadapter=new MyNineAdapter(getContext());
        recy_nine.setAdapter(nineadapter);
        //网格布局
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),mCunt);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recy_nine.setLayoutManager(gridLayoutManager);
        Map<String,String> mar=new HashMap<>();
        cutadapter=new MyCutAdapter(getContext());
        presenterlmpl.setRequestData(ShowUrl,mar,ShowBean.class);
        //线性
        linearinif();
        //网格
        grid();

    }

    private void grid() {
        //网格
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        gridrecy_cut.setLayoutManager(gridLayoutManager);
        //添加适配器
        gridrecy_cut.setAdapter(cutadapter);
        Map<String,String> mart=new HashMap<>();
        mart.put("uid",UId_UI+"");
        presenterlmpl.setRequestData(CutUrl,mart,CutBean.class);
    }

    private void linearinif() {
        //线性
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recy_cut.setLayoutManager(linearLayoutManager);
        //添加适配器
        recy_cut.setAdapter(cutadapter);
        Map<String,String> mart=new HashMap<>();
        mart.put("uid",UId_UI+"");
        presenterlmpl.setRequestData(CutUrl,mart,CutBean.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.show_scan:
                Intent intent1=new Intent(getContext(),OverScanActivity.class);
                startActivity(intent1);
                break;
            case R.id.mycut:
                if (i%2==0){
                    recy_cut.setVisibility(View.VISIBLE);
                    gridrecy_cut.setVisibility(View.GONE);
                }else {
                    recy_cut.setVisibility(View.GONE);
                    gridrecy_cut.setVisibility(View.VISIBLE);
                }
                i++;
                break;
                default:break;
        }
    }

    @Override
    public void setData(Object data) {
          if (data instanceof ShowBean){
              ShowBean showBean= (ShowBean) data;
              nineadapter.setList(showBean.getData());
          }
          if (data instanceof CutBean){
              CutBean cutBean= (CutBean) data;
              cutadapter.setList(cutBean.getData());
          }
    }
}
