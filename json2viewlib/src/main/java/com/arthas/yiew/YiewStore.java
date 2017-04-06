package com.arthas.yiew;

import android.view.View;

import com.arthas.yiew.decode.Yiew;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/4/5.
 */
public class YiewStore {


    HashMap<String, View> hashMap = new HashMap();

    //有name的会缓存
    public HashMap<String, Yiew> yiews = new HashMap();


    public void putView(String name, View view) {

        hashMap.put(name, view);

    }


    public View getView(String name) {
        return hashMap.get(name);
    }


    public Yiew getYiewByName(String name) {
        return yiews.get(name);
    }

    public void put(Yiew yiew, View view) {

        if (yiew.name != null) {
            putView(yiew.name, view);

            if (yiew.id == 0) {
                yiew.id = Utils.generateViewId();
            }
            view.setId( yiew.id);
            yiews.put(yiew.name,yiew);

        }
//        if (yiew.id != 0) {
//            putId(yiew.name, yiew.id);
//        }


    }
}
