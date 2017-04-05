package com.arthas.yiew.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewConfig;
import com.arthas.yiew.decode.YiewBean;
import com.arthas.yiew.decode.Yiewv2;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class ImageViewProcess {
    public static View process(Context context, Yiewv2 yiewv2) {


        ImageView view = new ImageView(context);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(yiewv2.parentView, yiewv2);
        view.setLayoutParams(params);


        LayoutProcess.applyaLayout(view, params, yiewv2);
        ViewProcess.applyView(view, yiewv2);
        applyImageView(view, yiewv2);






        return view;
    }



    public static void applyImageView(ImageView view, YiewBean yiew) {
//        Log.d("syb", "yiew.src" + yiew.src);
        if (yiew.src != null) {
            YiewConfig.getImageProcess().display(view, yiew.src, yiew);


        }


        if (yiew.scaleType != null)
            view.setScaleType(ImageView.ScaleType.valueOf(yiew.scaleType));
        else
            view.setScaleType(ImageView.ScaleType.FIT_XY);
    }

}
