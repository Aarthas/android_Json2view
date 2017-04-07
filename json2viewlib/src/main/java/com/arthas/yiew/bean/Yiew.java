package com.arthas.yiew.bean;

import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.YiewStore;

import java.util.ArrayList;

/**
 * Created by zhangyn on 17/3/31.
 */

public class Yiew extends YiewBean {

    public static final String verticalLayout = "verticalLayout";
    public static final String horizonLayout = "horizonLayout";
    public static final String TextView = "TextView";
    public static final String ImageView = "ImageView";
    public static final String View = "View";
    public static final String ScrollView = "ScrollView";
    public static final String scrollView = "scrollView";
    public static final String RelativeLayout = "RelativeLayout";
    public static final String FrameLayout = "FrameLayout";
    public static final String LinearLayout= "LinearLayout";;



    public static final String MATCH = "match";
    public static final String WRAP = "wrap";






    public String getData(String key,String defaultValue) {
        if (data==null)
        {
            return defaultValue;
        }else
        {
            String s = data.get(key);
            if (s== null){
                return defaultValue;
            }
            return s;
        }
    }
    public int getDataInt(String key,int defaultValue) {
        if (data==null)
        {
            return 0;
        }else
        {
            String s = data.get(key);
            if (s== null){
                return defaultValue;
            }
            else
            {
                try {
                    int i = Integer.parseInt(s);
                    return  i;
                }catch (Exception e){
                    return  defaultValue;
                }

            }

        }
    }


    public transient Yiew parentNode;


    public transient YiewStore yiewStore;


    public void addChild(Yiew yiew) {
        if (child == null)
        {
            child = new ArrayList<>();

        }
        child.add(yiew);
    }



    public YiewStore getYiewStore() {
        return yiewStore;
    }


    public  android.view.View getView() {
        return yiewStore.getView(name);
    }

    public void invalid() {
        YiewEngine.invalid(this);

    }


    public static Yiew create(String type, String width, String height) {
        Yiew yiew = new Yiew();
        yiew.view = type;
        yiew.width = width;
        yiew.height = height;
        return yiew;
    }
}
