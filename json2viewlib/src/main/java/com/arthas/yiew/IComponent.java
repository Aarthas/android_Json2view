package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.bean.XViewBody;

public interface IComponent {
    View createComponentView(Context context, ViewGroup parent, XViewBody yiew);

    public void render(XViewBody yiew);

}