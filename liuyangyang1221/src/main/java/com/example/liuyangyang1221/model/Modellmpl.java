package com.example.liuyangyang1221.model;

import com.example.liuyangyang1221.callback.MyCallback;
import com.example.liuyangyang1221.util.ICallback;
import com.example.liuyangyang1221.util.OkHttpUtils;

import java.util.Map;

public class Modellmpl implements Model{
    @Override
    public void setRequestData(String path, final Map<String, String> mar, Class clazz, final MyCallback myCallback) {
        OkHttpUtils.getmInstance().PostEnqueue(path, mar, clazz, new ICallback() {
            @Override
            public void setSuccess(Object obj) {
                myCallback.setData(obj);
            }

            @Override
            public void setfill(Exception ex) {
               myCallback.setData(ex);
            }
        });
    }
}
