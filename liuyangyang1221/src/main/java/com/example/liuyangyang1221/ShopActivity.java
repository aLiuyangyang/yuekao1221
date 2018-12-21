package com.example.liuyangyang1221;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.liuyangyang1221.adapter.MyShouAdapter;

public class ShopActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        viewPager=findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.tab);
        //设置适配器
        viewPager.setAdapter(new MyShouAdapter(getSupportFragmentManager()));
        //添加视图
        tabLayout.setupWithViewPager(viewPager);
    }
}
