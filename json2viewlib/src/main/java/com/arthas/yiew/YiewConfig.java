package com.arthas.yiew;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/3/30.
 */

public class YiewConfig {


    private static ImageAdapter imageAdapter;
    private static HashMap<String, IProcess> processMap = new HashMap();


    public static void setImageAdapter(ImageAdapter imageAdapter) {
        YiewConfig.imageAdapter = imageAdapter;
    }

    public static ImageAdapter getImageAdapter() {
        return imageAdapter;
    }


    public static void Component(String name, IProcess line) {
        processMap.put(name, line);
    }


    public static IProcess findProcess(String view) {

        return processMap.get(view);
    }
}
