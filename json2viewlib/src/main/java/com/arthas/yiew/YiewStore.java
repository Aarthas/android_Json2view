package com.arthas.yiew;

import android.view.View;

import com.arthas.yiew.decode.YiewBean;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/4/5.
 */
public class YiewStore {


    HashMap<String, View> hashMap = new HashMap();
    HashMap<String, Integer> ids = new HashMap();
    public HashMap<String, YiewBean> yiews = new HashMap();

    public void putView(String name, View view) {

        hashMap.put(name, view);

    }

    public void putId(String name, Integer id) {

        ids.put(name, id);

    }

    public View getView(String name) {
        return hashMap.get(name);
    }

    public Integer getIdByName(String name) {
        return ids.get(name);
    }

    public YiewBean getYiewByName(String name) {
        return yiews.get(name);
    }

    public void put(YiewBean yiew, View view) {

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
