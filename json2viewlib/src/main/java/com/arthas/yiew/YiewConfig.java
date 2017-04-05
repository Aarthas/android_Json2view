package com.arthas.yiew;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/3/30.
 */

public class YiewConfig {


    private static ImageAdapter imageAdapter;

    public static void setImageAdapter(ImageAdapter imageAdapter) {
        YiewConfig.imageAdapter = imageAdapter;
    }

    public static ImageAdapter getImageProcess() {
        return imageAdapter;
    }

    static HashMap<String, IProcess> map = new HashMap();

    public static void Component(String name, IProcess line) {
        map.put(name, line);
    }



    public static HashMap<String, IProcess> getMap() {
        return map;
    }
}
