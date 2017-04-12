package com.arthas.yiew;

import android.widget.ImageView;

import com.arthas.yiew.bean.XViewBase;

/**
 * Created by zhangyn on 17/3/30.
 */

public interface ImageAdapter {
    void display(ImageView view, String src, XViewBase yiew);
}
