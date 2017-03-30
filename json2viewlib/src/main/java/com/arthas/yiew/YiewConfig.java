package com.arthas.yiew;

/**
 * Created by zhangyn on 17/3/30.
 */

public class YiewConfig {

    private static ImageAdapter imageAdapter;

    public static void setImageAdapter(ImageAdapter imageAdapter) {
        YiewConfig.imageAdapter = imageAdapter;
    }

    public static ImageAdapter getImageAdapter() {
        return imageAdapter;
    }
}
