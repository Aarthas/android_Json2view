package com.arthas.yiew.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewConfig;
import com.arthas.yiew.decode.YiewBean;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class ImageViewProcess {
    public static View createView(Context context, ViewGroup parent, YiewBean yiew) {


        ImageView view = new ImageView(context);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);


        LayoutProcess.applyaLayout(view, params, yiew);
        ViewProcess.applyView(view, yiew);
        applyImageView(view, yiew);






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
