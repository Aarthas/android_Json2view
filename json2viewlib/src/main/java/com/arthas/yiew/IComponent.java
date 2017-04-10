package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.bean.Yiew;

public interface IComponent {
    View createComponentView(Context context, ViewGroup parent, Yiew yiew);

    public void render(Yiew yiew);

}