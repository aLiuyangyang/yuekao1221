package com.example.liuyangyang1221;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.liuyangyang1221.bean.CarBean;
import com.example.liuyangyang1221.presenter.Presenterlmpl;
import com.example.liuyangyang1221.view.IView;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView {
      private String CarUrl="http://www.zhaoapi.cn/ad/getAd";
      private Presenterlmpl presenterlmpl;
      private List<String> list;
      private FlyBanner banner;
      private Button srart_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenterlmpl=new Presenterlmpl(this);
        banner=findViewById(R.id.main_fly);
        srart_button=findViewById(R.id.button);
        srart_button.setOnClickListener(this);
        Map<String,String> map=new HashMap<>();
        presenterlmpl.setRequestData(CarUrl,map,CarBean.class);

    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.button:
               Intent intent1=new Intent(MainActivity.this,ShopActivity.class);
               startActivity(intent1);
               break;
       }
    }

    @Override
    public void setData(Object data) {
        CarBean carBean= (CarBean) data;
        List<CarBean.DataBean> data1 = carBean.getData();
        list=new ArrayList<>();
        for (int i = 0; i <data1.size() ; i++) {
            list.add(data1.get(i).getIcon());
        }
        banner.setImagesUrl(list);
    }
}
