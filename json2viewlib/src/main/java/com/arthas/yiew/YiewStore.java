package com.arthas.yiew;

import android.view.View;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/4/5.
 */
public class YiewStore {
    public View view;

    HashMap<String,View> hashMap = new HashMap();
    public void put(String name, View view) {
        System.out.println("hashMap"+hashMap);
        hashMap.put(name,view);

    }

    public View getView(String name) {
        return hashMap.get(name);
    }
}
