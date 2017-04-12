package com.arthas.xjsonview.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.xjsonview.XViewComponent;
import com.arthas.xjsonview.Utils;
import com.arthas.xjsonview.bean.XViewBody;
import com.arthas.xjsonview.process.base.LayoutProcess;
import com.arthas.xjsonview.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */
public class SimpleViewProcess implements XViewComponent {
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
