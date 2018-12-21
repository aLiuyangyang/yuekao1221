package com.example.liuyangyang1221.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.liuyangyang1221.R;

public class MyView extends LinearLayout {
    private EditText editText;
    private Context context;

    public MyView(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public MyView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        init();
    }

    private void init() {
        View view=View.inflate(context, R.layout.title,null);
        editText=view.findViewById(R.id.mytitlt);
        editText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                itemCilck.myitemcilck();
            }
        });
    }
    private ItemCilck itemCilck;

    public void setItemCilck(ItemCilck itemCilck) {
        this.itemCilck = itemCilck;
    }

    public interface ItemCilck{
        void myitemcilck();
    }
}
