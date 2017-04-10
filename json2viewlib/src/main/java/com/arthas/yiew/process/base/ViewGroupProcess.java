package com.arthas.yiew.process.base;

import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.bean.Yiew;

/**
 * Created by zhangyn on 17/4/1.
 */

public class ViewGroupProcess {
    public static void applyViewGroup(final View viewGroup, final Yiew yiew) {

        if (viewGroup instanceof ViewGroup && yiew.child != null && yiew.child.size() > 0) {
            ViewGroup group = (ViewGroup) viewGroup;
            YiewEngine.addChild(group.getContext(), group, yiew);
        }


    }


}
