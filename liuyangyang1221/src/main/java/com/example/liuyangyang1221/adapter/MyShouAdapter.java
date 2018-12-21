package com.example.liuyangyang1221.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.example.liuyangyang1221.R;
import com.example.liuyangyang1221.view.MyShow;
import com.example.liuyangyang1221.view.Mywo;

public class MyShouAdapter extends FragmentPagerAdapter {
    private String[] name=new String[]{"我的","首页"};

    public MyShouAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new MyShow();
            case 1:
                return new Mywo();
            default:
              return new Fragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return name[position];
    }

    @Override
    public int getCount() {
        return name.length;
    }
}
