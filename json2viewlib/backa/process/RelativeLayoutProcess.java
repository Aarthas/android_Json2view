package com.arthas.yiew.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.arthas.yiew.Utils;
import com.arthas.yiew.decode.Yiewv2;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class RelativeLayoutProcess {
    public static View process(Context context, Yiewv2 yiew) {

        RelativeLayout view = new RelativeLayout(context);

        ViewGroup.LayoutParams params = Utils.createLayoutParams(yiew.parentView, yiew);
        view.setLayoutParams(params);


        LayoutProcess.applyaLayout(view, params, yiew);
        ViewProcess.applyView(view, yiew);

        return view;
    }
}
