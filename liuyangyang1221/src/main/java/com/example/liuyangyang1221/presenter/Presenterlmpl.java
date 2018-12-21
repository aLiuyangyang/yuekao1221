package com.example.liuyangyang1221.presenter;

import com.example.liuyangyang1221.callback.MyCallback;
import com.example.liuyangyang1221.model.Modellmpl;
import com.example.liuyangyang1221.view.IView;

import java.util.Map;

public class Presenterlmpl implements Presenter{
    private IView iView;
    private Modellmpl modellmpl;

    public Presenterlmpl(IView iView) {
        this.iView = iView;
        modellmpl=new Modellmpl();
    }

    @Override
    public void setRequestData(String path, Map<String, String> mar, Class clazz) {
       modellmpl.setRequestData(path, mar, clazz, new MyCallback() {
           @Override
           public void setData(Object data) {
               iView.setData(data);
           }
       });
    }
    public void setUntie(){
        if (iView!=null){
            iView=null;
        }
        if (modellmpl!=null){
            modellmpl=null;
        }
    }
}
