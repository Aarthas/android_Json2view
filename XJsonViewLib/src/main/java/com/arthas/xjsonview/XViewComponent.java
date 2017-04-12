package com.arthas.xjsonview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.xjsonview.bean.XViewBody;

public interface XViewComponent {
    View createComponentView(Context context, ViewGroup parent, XViewBody yiew);

    public void render(XViewBody yiew);

}