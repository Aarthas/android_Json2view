package com.arthas.yiew.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewStore;
import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class FrameLayoutProcess {
    public static View createView(Context context, ViewGroup parent, Yiew yiew, YiewStore yiewStore) {
        FrameLayout view = new FrameLayout(context);

        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);

        ViewProcess.applyView(view, yiew,yiewStore);
        LayoutProcess.applyaLayout(view, params, yiew,yiewStore);




        return view;
    }
}
