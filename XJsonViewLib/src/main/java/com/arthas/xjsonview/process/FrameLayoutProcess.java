package com.arthas.xjsonview.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.arthas.xjsonview.IComponent;
import com.arthas.xjsonview.Utils;
import com.arthas.xjsonview.bean.XViewBody;
import com.arthas.xjsonview.process.base.LayoutProcess;
import com.arthas.xjsonview.process.base.ViewGroupProcess;
import com.arthas.xjsonview.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class FrameLayoutProcess  implements IComponent {
    public  View createComponentView(Context context, ViewGroup parent, XViewBody yiew) {
        FrameLayout view = new FrameLayout(context);

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
