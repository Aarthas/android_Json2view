package com.arthas.yiew.process.diy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.arthas.yiew.IProcess;
import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.YiewStore;
import com.arthas.yiew.decode.Yiew;
import com.arthas.yiew.decode.YiewBean;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class ScrollProcess  implements IProcess {
    @Override
    public View createView(Context context, ViewGroup parent, Yiew yiew, YiewStore yiewStore) {
        ScrollView view = new ScrollView(context);
//
        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);

        ViewProcess.applyView(view, yiew, yiewStore);
        LayoutProcess.applyaLayout(view, params, yiew, yiewStore);


        view.setVerticalFadingEdgeEnabled(false);
        view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
        view.setFadingEdgeLength(0);


        Yiew verticalLayoutyiew = new Yiew();
        verticalLayoutyiew.width = "match";
        verticalLayoutyiew.height = "match";
        verticalLayoutyiew.view = "verticalLayout";
        ViewGroup verticalLayout = (ViewGroup) YiewEngine.createView(context, view, verticalLayoutyiew,yiewStore);
        view.addView(verticalLayout);



        if (verticalLayout instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) verticalLayout;
            YiewEngine.addChild(context, yiew, verticalLayout, yiewStore);
        }
        return view;
    }
}
