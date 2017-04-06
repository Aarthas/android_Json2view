package com.arthas.yiew.process;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewStore;
import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.bean.YiewBean;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

import static com.arthas.yiew.Utils.getValueInt;

/**
 * Created by zhangyn on 17/4/5.
 */

public class HorizonLayoutProcess  {
    public static View createView(Context context, ViewGroup parent, Yiew yiew, YiewStore yiewStore) {

        LinearLayout view = new LinearLayout(context);
        view.setOrientation(LinearLayout.HORIZONTAL);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);

        ViewProcess.applyView(view, yiew,yiewStore);
        LayoutProcess.applyaLayout(view, params, yiew,yiewStore);

        applyLinearLayout(view, yiew);



        return view;
    }

    public static void applyLinearLayout(LinearLayout view, YiewBean yiew) {
        if (yiew.gravity != null)
            view.setGravity((Integer) getValueInt(Gravity.class, yiew.gravity.toUpperCase()));


    }
}
