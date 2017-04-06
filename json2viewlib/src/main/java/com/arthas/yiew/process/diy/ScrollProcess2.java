package com.arthas.yiew.process.diy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.IProcess;
import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.YiewStore;
import com.arthas.yiew.bean.Yiew;

/**
 * Created by zhangyn on 17/4/5.
 */

public class ScrollProcess2 implements IProcess {
    @Override
    public View createView(Context context, ViewGroup parent, Yiew yiew, YiewStore yiewStore) {
        Yiew ScrollView = Yiew.create(Yiew.ScrollView, Yiew.MATCH, Yiew.MATCH);
        Utils.copy(ScrollView,yiew);
        Yiew verticalLayout = Yiew.create(Yiew.verticalLayout, Yiew.MATCH, Yiew.MATCH);
        ScrollView.addChild(verticalLayout);
        verticalLayout.child = yiew.child;
        ViewGroup view = (ViewGroup) YiewEngine.createView(context, parent, ScrollView,yiewStore);


        return view;
    }
}
