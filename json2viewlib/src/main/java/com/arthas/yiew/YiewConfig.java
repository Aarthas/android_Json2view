package com.arthas.yiew;

import com.arthas.yiew.process.diy.ScrollProcess2;

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

        if ("scrollView".equals(view)) {
            IProcess iProcess = processMap.get(view);
            if (iProcess == null) {
                iProcess = new ScrollProcess2();
                processMap.put(view, iProcess);
            }
            return iProcess;
        }
        return processMap.get(view);
    }
}
