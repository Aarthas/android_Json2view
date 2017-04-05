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
public class VerticalLayoutProcess {
    public static View process(Context context,Yiewv2 yiewv2) {

        LinearLayout view = new LinearLayout(context);
        view.setOrientation(LinearLayout.VERTICAL);

        ViewGroup.LayoutParams params = Utils.createLayoutParams(yiewv2.parentView, yiewv2);
        view.setLayoutParams(params);

        ViewProcess.applyView(view, yiewv2);
        LayoutProcess.applyaLayout(view, params, yiewv2);
        applyLinearLayout(view, yiewv2);


        return view;

    }

    public static void applyLinearLayout(LinearLayout view, YiewBean yiew) {
        if (yiew.gravity != null)
            view.setGravity((Integer) getValueInt(Gravity.class, yiew.gravity.toUpperCase()));


    }
}
