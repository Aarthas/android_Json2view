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

    private HashMap<String, IComponent> componentMap = null;

    public void addComponent(String name, IComponent line) {
        if (componentMap == null){
            componentMap = new HashMap<>();
        }
        componentMap.put(name, line);
    }
    public  IComponent findComponent(String view) {

        if (componentMap==null)
        {
            return null;
        }
        return componentMap.get(view);
    }



    public Yiew getYiewByName(String name) {
        return yiews.get(name);
    }

    public void cacheNamedYiew(Yiew yiew, View view) {
        yiew.currentView = view;
        if (yiew.name != null) {


            yiew.id = Utils.generateViewId();
            view.setId(yiew.id);
            yiews.put(yiew.name, yiew);

        }

//        if (yiew.id != 0) {
//            putId(yiew.name, yiew.id);
//        }


    }
}
