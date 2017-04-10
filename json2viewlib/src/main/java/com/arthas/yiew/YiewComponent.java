package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.bean.Yiew;

public abstract class YiewComponent implements   IComponent{


    @Override
    public View createComponentView(Context context, ViewGroup parent, Yiew yiew) {
        Yiew template = createTemplate(context, parent, yiew);

        yiew.setComponentTemplate(template);

        View content = YiewEngine.createView(context, parent, yiew);
        return content;
    }

    public abstract Yiew createTemplate(Context context, ViewGroup parent, Yiew yiew);
}