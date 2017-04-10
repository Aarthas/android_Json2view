package com.arthas.yiew.process.diy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.IComponent;
import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.bean.Yiew;

/**
 * Created by zhangyn on 17/4/5.
 */

public class ScrollComponent implements IComponent {

    @Override
    public View createComponentView(Context context, ViewGroup parent, Yiew yiew) {
        Yiew yiscroll = Yiew.create(Yiew.ScrollView, Yiew.MATCH, Yiew.MATCH);
        Yiew verlayout = Yiew.create(Yiew.verticalLayout, Yiew.MATCH, Yiew.MATCH);
        yiscroll.addChild(verlayout);
        verlayout.child = yiew.child;
        yiew.child = null;

        yiew.setComponentTemplate(yiscroll);
        ViewGroup view = (ViewGroup) YiewEngine.createView(context, parent, yiew);


        return view;
    }

    @Override
    public void render(Yiew yiew) {

    }
}
