package com.arthas.yiew;

import com.arthas.yiew.decode.YiewBean;
import com.arthas.yiew.decode.Yiew;
import com.arthas.yiew.process.ImageProcess;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/3/30.
 */

public class YiewConfig {


    private static ImageProcess imageAdapter;

    public static void setImageProcess(ImageProcess imageAdapter) {
        YiewConfig.imageAdapter = imageAdapter;
    }

    public static ImageProcess getImageProcess() {
        return imageAdapter;
    }

    static HashMap<String, YiewBean> map = new HashMap();

    public static void Component(String name, YiewBean line) {
        map.put(name, line);
    }

    public static void Component(String name, Yiew yiew) {

        map.put(name, yiew);
    }

    public static HashMap<String, YiewBean> getMap() {
        return map;
    }
}
