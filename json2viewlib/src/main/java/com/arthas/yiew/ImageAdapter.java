package com.arthas.yiew;

import android.widget.ImageView;

import com.arthas.yiew.decode.YiewBean;

/**
 * Created by zhangyn on 17/3/30.
 */

public interface ImageAdapter {
    void display(ImageView view, String src, YiewBean yiew);
}
