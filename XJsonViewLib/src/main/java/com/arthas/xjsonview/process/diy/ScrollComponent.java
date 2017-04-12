package com.arthas.xjsonview.process.diy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.xjsonview.XViewComponent;
import com.arthas.xjsonview.XViewEngine;
import com.arthas.xjsonview.bean.XViewBody;

/**
 * Created by zhangyn on 17/4/5.
 */

public class ScrollComponent implements XViewComponent {

    @Override
    public View createComponentView(Context context, ViewGroup parent, XViewBody yiew) {
        XViewBody yiscroll = XViewBody.create(XViewBody.ScrollView, XViewBody.MATCH, XViewBody.MATCH);
        XViewBody verlayout = XViewBody.create(XViewBody.verticalLayout, XViewBody.MATCH, XViewBody.MATCH);
        yiscroll.addChild(verlayout);
        verlayout.child = yiew.child;
        yiew.child = null;

        yiew.setComponentTemplate(yiscroll);
        ViewGroup view = (ViewGroup) XViewEngine.createView(context, parent, yiew);


        return view;
    }

    @Override
    public void render(XViewBody yiew) {

    }
}
