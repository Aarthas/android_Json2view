package com.arthas.yiew.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.arthas.yiew.IComponent;
import com.arthas.yiew.Utils;
import com.arthas.yiew.bean.XViewBody;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewGroupProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class ScrollViewProcess implements IComponent {
    public  View createComponentView(Context context, ViewGroup parent, XViewBody yiew) {
        ScrollView view = new ScrollView(context);

        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);

        view.setVerticalFadingEdgeEnabled(false);
        view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
        view.setFadingEdgeLength(0);
        ViewProcess.applyView(view, yiew);
        LayoutProcess.applyaLayout(view, params, yiew);


        view.setVerticalFadingEdgeEnabled(false);
        view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
        view.setFadingEdgeLength(0);

        ViewGroupProcess.applyViewGroup(view,yiew);

        return view;

    }

    @Override
    public void render(XViewBody yiew) {

    }
}
