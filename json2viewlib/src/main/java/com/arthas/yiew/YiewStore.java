package com.arthas.yiew;

import android.view.View;

import com.arthas.yiew.bean.Yiew;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/4/5.
 */
public class YiewStore {


    //有name的会缓存Yiew
    public HashMap<String, Yiew> yiews = new HashMap();


    public Yiew getYiewByName(String name) {
        return yiews.get(name);
    }

    public void cacheNamedYiew(Yiew yiew, View view) {

        if (yiew.name != null) {

            yiew.currentView = view;
            yiew.id = Utils.generateViewId();
            view.setId(yiew.id);
            yiews.put(yiew.name, yiew);

        }
//        if (yiew.id != 0) {
//            putId(yiew.name, yiew.id);
//        }


    }
}
