package com.arthas.yiew.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.Utils;
import com.arthas.yiew.decode.Yiewv2;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */
public class DvProcess {
    public static View process(Context context, Yiewv2 yiewv2) {

        View view = new View(context);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(yiewv2.parentView, yiewv2);
        view.setLayoutParams(params);


        LayoutProcess.applyaLayout(view, params, yiewv2);
        ViewProcess.applyView(view, yiewv2);


        return view;
    }
}
