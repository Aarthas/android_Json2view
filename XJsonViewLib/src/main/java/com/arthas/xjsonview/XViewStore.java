package com.arthas.xjsonview;

import android.view.View;

import com.arthas.xjsonview.bean.XViewBody;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/4/5.
 */
public class XViewStore {


    //有name的会缓存XView
    public HashMap<String, XViewBody> yiews = new HashMap();

    private HashMap<String, XViewComponent> componentMap = null;

    public void addComponent(String name, XViewComponent line) {
        if (componentMap == null) {
            componentMap = new HashMap<>();
        }
        componentMap.put(name, line);
    }

    public XViewComponent findComponent(String view) {

        if (componentMap == null) {
            return null;
        }
        return componentMap.get(view);
    }


    public XViewBody getYiewByName(String name) {
        return yiews.get(name);
    }

    public void cacheNamedYiew(XViewBody yiew, View view) {
        yiew.setCurrentView(view);
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
