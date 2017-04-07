package com.arthas.yiew.process;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewConfig;
import com.arthas.yiew.YiewStore;
import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class ImageViewProcess {
    public static View createView(Context context, ViewGroup parent, Yiew yiew, YiewStore yiewStore) {


        ImageView view = new ImageView(context);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);

        ViewProcess.applyView(view, yiew,yiewStore);
        LayoutProcess.applyaLayout(view, params, yiew,yiewStore);

        applyImageView(view, yiew);






        return view;
    }



    public static void applyImageView(ImageView view, Yiew yiew) {
//        Log.d("syb", "yiew.src" + yiew.src);
        if (yiew.src != null) {
            if (yiew.src.startsWith("&")) {
                yiew.src = Utils.getValueStringIfDataExist(yiew, yiew.src, null);
                if (yiew.src != null) {
                    YiewConfig.getImageAdapter().display(view, yiew.src, yiew);
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
