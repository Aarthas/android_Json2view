package com.arthas.yiew.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.arthas.yiew.IComponent;
import com.arthas.yiew.Utils;
import com.arthas.yiew.bean.XViewBody;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewGroupProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class RelativeLayoutProcess implements IComponent {
    public  View createComponentView(Context context, ViewGroup parent, XViewBody yiew ) {

        RelativeLayout view = new RelativeLayout(context);

        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);

        ViewProcess.applyView(view, yiew);
        LayoutProcess.applyaLayout(view, params, yiew);


        ViewGroupProcess.applyViewGroup(view,yiew);


        return view;
    }

    @Override
    public void render(XViewBody yiew) {

    }
}
