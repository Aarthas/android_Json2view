package com.arthas.yiew.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.arthas.yiew.Utils;
import com.arthas.yiew.decode.Yiewv2;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class ScrollViewProcess {
    public static View process(Context context, Yiewv2 yiew) {
        ScrollView view = new ScrollView(context);

        ViewGroup.LayoutParams params = Utils.createLayoutParams(yiew.parentView, yiew);
        view.setLayoutParams(params);

        view.setVerticalFadingEdgeEnabled(false);
        view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
        view.setFadingEdgeLength(0);

        LayoutProcess.applyaLayout(view, params, yiew);
        ViewProcess.applyView(view, yiew);

        view.setVerticalFadingEdgeEnabled(false);
        view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
        view.setFadingEdgeLength(0);



        return view;

    }
}
