package com.arthas.yiew;

import com.arthas.yiew.config.ImageAdapter;
import com.arthas.yiew.decode.Yiew;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/3/30.
 */

public class YiewConfig {


    private static ImageAdapter imageAdapter;

    public static void setImageProcess(ImageAdapter imageAdapter) {
        YiewConfig.imageAdapter = imageAdapter;
    }

    public static ImageAdapter getImageProcess() {
        return imageAdapter;
    }

    static HashMap<String, Yiew> map = new HashMap();

    public static void Component(String name, Yiew component) {
        map.put(name, component);
    }



    public static HashMap<String, Yiew> getMap() {
        return map;
    }
}
