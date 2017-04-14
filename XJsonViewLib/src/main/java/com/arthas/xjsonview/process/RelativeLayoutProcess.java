package com.arthas.xjsonview.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.arthas.xjsonview.XViewComponent;
import com.arthas.xjsonview.Utils;
import com.arthas.xjsonview.bean.XViewBody;
import com.arthas.xjsonview.process.base.LayoutProcess;
import com.arthas.xjsonview.process.base.ViewGroupProcess;
import com.arthas.xjsonview.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class RelativeLayoutProcess implements XViewComponent {
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
