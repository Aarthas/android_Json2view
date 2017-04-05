package com.arthas.yiew;

import android.view.View;

import com.arthas.yiew.decode.Yiewv2;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/4/5.
 */
public class YiewDelegate {
    HashMap<String,Yiewv2> hashMap = new HashMap();

    public void put(String name, Yiewv2 yiew) {
        hashMap.put(name,yiew);
    }


    public View getView(String main) {
        return null;
    }

    public Yiewv2 getYiew(String main) {
        return null;
    }
}
