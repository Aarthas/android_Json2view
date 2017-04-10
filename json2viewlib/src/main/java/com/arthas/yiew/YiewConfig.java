package com.arthas.yiew;

import com.arthas.yiew.process.diy.ScrollComponent2;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/3/30.
 */

public class YiewConfig {


    private static ImageAdapter imageAdapter;
    private static HashMap<String, IComponent> processMap = new HashMap();


    public static void setImageAdapter(ImageAdapter imageAdapter) {
        YiewConfig.imageAdapter = imageAdapter;
    }

    public static ImageAdapter getImageAdapter() {
        return imageAdapter;
    }


    public static void addComponent(String name, IComponent line) {
        processMap.put(name, line);
    }


    public static IComponent findComponent(String view) {

        if ("scrollView".equals(view)) {
            IComponent iComponent = processMap.get(view);
            if (iComponent == null) {
                iComponent = new ScrollComponent2();
                processMap.put(view, iComponent);
            }
            return iComponent;
        }
        return processMap.get(view);
    }
}
