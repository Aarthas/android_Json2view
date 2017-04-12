package com.arthas.yiew.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.IComponent;
import com.arthas.yiew.Utils;
import com.arthas.yiew.bean.XViewBody;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */
public class SimpleViewProcess implements IComponent {
    public  View createYiew(Context context, ViewGroup parent, XViewBody yiew) {

        View view = new View(context);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);

        ViewProcess.applyView(view, yiew);
        LayoutProcess.applyaLayout(view, params, yiew);



        return view;
    }

    @Override
    public View createComponentView(Context context, ViewGroup parent, XViewBody yiew) {
        return null;
    }

    @Override
    public void render(XViewBody yiew) {

    }
}
