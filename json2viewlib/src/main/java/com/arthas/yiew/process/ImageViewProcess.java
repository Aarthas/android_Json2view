package com.arthas.yiew.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewConfig;
import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class ImageViewProcess {
    public static View createView(Context context, ViewGroup parent, Yiew yiew) {


        ImageView view = new ImageView(context);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);

        ViewProcess.applyView(view, yiew);
        LayoutProcess.applyaLayout(view, params, yiew);

        applyImageView(view, yiew);






        return view;
    }



    public static void applyImageView(ImageView view, Yiew yiew) {
//        Log.d("syb", "yiew.src" + yiew.src);
        if (yiew.src != null) {
            if (yiew.src.startsWith("&")) {
                String src = Utils.getValueStringIfDataExist(yiew, yiew.src, null);
                if (src != null) {
                    yiew.src =src;
                    YiewConfig.getImageAdapter().display(view,src, yiew);
                }
            }else{
                YiewConfig.getImageAdapter().display(view, yiew.src, yiew);
            }




        }


        if (yiew.scaleType != null)
            view.setScaleType(ImageView.ScaleType.valueOf(yiew.scaleType));
        else
            view.setScaleType(ImageView.ScaleType.FIT_XY);
    }

}
