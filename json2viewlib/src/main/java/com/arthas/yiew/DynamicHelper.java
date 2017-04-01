package com.arthas.yiew;

import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arthas.yiew.decode.YiewBean;

import static com.arthas.yiew.Utils.getValueInt;

/**
 * Created by avocarrot on 11/12/2014.
 * Helper function that apply properties in views
 */
public class DynamicHelper {


    public static void applyTextView(TextView view, YiewBean yiew) {
        if (yiew.text != null)
            view.setText(yiew.text);
        if (yiew.textColor != null)
            view.setTextColor(Color.parseColor(yiew.textColor));
        if (yiew.textSize != 0)
            view.setTextSize(TypedValue.COMPLEX_UNIT_SP, yiew.textSize);
        if (yiew.hint != null)
            view.setHint(yiew.hint);
        if (yiew.maxLine != 0)
            view.setMaxLines(yiew.maxLine);
        if (yiew.hintColor != null)
            view.setHintTextColor(Color.parseColor(yiew.hintColor));
        if (yiew.lineSpace != null)
            view.setLineSpacing(Utils.meature(yiew.lineSpace),1);

        if (yiew.gravity != null)
            view.setGravity((Integer) getValueInt(Gravity.class, yiew.gravity.toUpperCase()));


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





    public static void applyLinearLayout(LinearLayout view, YiewBean yiew) {
        if (yiew.gravity != null)
            view.setGravity((Integer) getValueInt(Gravity.class, yiew.gravity.toUpperCase()));


    }

    public static void applyRelativeLayout(RelativeLayout view, YiewBean yiew) {
        if (yiew.gravity != null)
            view.setGravity((Integer) getValueInt(Gravity.class, yiew.gravity.toUpperCase()));

    }


}
