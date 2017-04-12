package com.arthas.xjsonview;

import android.view.View;

import com.arthas.xjsonview.bean.XViewBody;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/4/5.
 */
public class YiewStore {


    //有name的会缓存Yiew
    public HashMap<String, XViewBody> yiews = new HashMap();

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



    public XViewBody getYiewByName(String name) {
        return yiews.get(name);
    }

    public void cacheNamedYiew(XViewBody yiew, View view) {
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
