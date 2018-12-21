package com.example.liuyangyang1221.model;

import com.example.liuyangyang1221.callback.MyCallback;

import java.util.Map;

public interface Model {
    void setRequestData(String path, Map<String,String> mar, Class clazz, MyCallback myCallback);
}
