package com.arthas.yiew.process;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.arthas.yiew.Utils;
import com.arthas.yiew.decode.YiewBean;
import com.arthas.yiew.decode.Yiewv2;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

import static com.arthas.yiew.Utils.getValueInt;

/**
 * Created by zhangyn on 17/4/5.
 */

public class HorizonLayoutProcess  {
    public static View process(Context context, Yiewv2 yiew) {

        LinearLayout view = new LinearLayout(context);
        view.setOrientation(LinearLayout.HORIZONTAL);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(yiew.parentView, yiew);
        view.setLayoutParams(params);


        LayoutProcess.applyaLayout(view, params, yiew);
        ViewProcess.applyView(view, yiew);
        applyLinearLayout(view, yiew);



        return view;
    }

    public static void applyLinearLayout(LinearLayout view, YiewBean yiew) {
        if (yiew.gravity != null)
            view.setGravity((Integer) getValueInt(Gravity.class, yiew.gravity.toUpperCase()));


    }
}
