package com.arthas.xjsonview.process;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.arthas.xjsonview.IComponent;
import com.arthas.xjsonview.Utils;
import com.arthas.xjsonview.bean.XViewBody;
import com.arthas.xjsonview.bean.XViewBase;
import com.arthas.xjsonview.process.base.LayoutProcess;
import com.arthas.xjsonview.process.base.ViewGroupProcess;
import com.arthas.xjsonview.process.base.ViewProcess;

import static com.arthas.xjsonview.Utils.getValueInt;

/**
 * Created by zhangyn on 17/4/5.
 */

public class HorizonLayoutProcess  implements IComponent {
    public  View createComponentView(Context context, ViewGroup parent, XViewBody yiew) {

        LinearLayout view = new LinearLayout(context);
        view.setOrientation(LinearLayout.HORIZONTAL);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);

        ViewProcess.applyView(view, yiew);
        LayoutProcess.applyaLayout(view, params, yiew);

        applyLinearLayout(view, yiew);

        ViewGroupProcess.applyViewGroup(view,yiew);

        return view;
    }

    @Override
    public void render(XViewBody yiew) {

    }

    public static void applyLinearLayout(LinearLayout view, XViewBase yiew) {
        if (yiew.gravity != null)
            view.setGravity((Integer) getValueInt(Gravity.class, yiew.gravity.toUpperCase()));


    }
}
