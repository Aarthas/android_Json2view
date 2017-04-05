package com.arthas.yiew.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewStore;
import com.arthas.yiew.decode.YiewBean;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */
public class DvProcess {
    public static View createYiew(Context context, ViewGroup parent, YiewBean yiew, YiewStore yiewStore) {

        View view = new View(context);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);

        ViewProcess.applyView(view, yiew,yiewStore);
        LayoutProcess.applyaLayout(view, params, yiew,yiewStore);



        return view;
    }
}
