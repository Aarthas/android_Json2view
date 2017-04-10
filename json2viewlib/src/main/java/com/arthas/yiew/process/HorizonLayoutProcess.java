package com.arthas.yiew.process;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.arthas.yiew.IComponent;
import com.arthas.yiew.Utils;
import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.bean.YiewBean;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewGroupProcess;
import com.arthas.yiew.process.base.ViewProcess;

import static com.arthas.yiew.Utils.getValueInt;

/**
 * Created by zhangyn on 17/4/5.
 */

public class HorizonLayoutProcess  implements IComponent {
    public  View createComponentView(Context context, ViewGroup parent, Yiew yiew) {

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
    public void render(Yiew yiew) {

    }

    public static void applyLinearLayout(LinearLayout view, YiewBean yiew) {
        if (yiew.gravity != null)
            view.setGravity((Integer) getValueInt(Gravity.class, yiew.gravity.toUpperCase()));


    }
}
