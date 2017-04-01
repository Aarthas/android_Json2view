package com.arthas.yiew.process;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.arthas.yiew.Utils;
import com.arthas.yiew.decode.YiewBean;

/**
 * Created by zhangyn on 17/4/1.
 */

public class LayoutProcess {

    public static void applyaLayout(View view, ViewGroup.LayoutParams params, YiewBean yiew) {
        if (params instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = ((ViewGroup.MarginLayoutParams) params);
            Log.d("syb","yiew.margin = "+yiew.margin);
            if (yiew.margin != null) {
                int margin = Utils.meatureWithUnit(yiew.margin);
                p.setMargins(margin, margin, margin, margin);
                Log.d("syb","p.setMargins1 = "+margin);
            } else {
                p.setMargins(Utils.meatureWithUnit(yiew.marginLeft), Utils.meatureWithUnit(yiew.marginTop), Utils.meatureWithUnit(yiew.marginRight), Utils.meatureWithUnit(yiew.marginBottom));
                Log.d("syb","p.setMargins2 = "+Utils.meatureWithUnit(yiew.marginTop));
            }
        }

        if (params instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) params;
            if (yiew.layout_gravity != null)
                params1.gravity = (int) Utils.getValueInt(Gravity.class, yiew.layout_gravity.toUpperCase());
            if (yiew.weight != 0)
                params1.weight = yiew.weight;

        } else if (params instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) params;
//            params1.addRule(RelativeLayout.LEFT_OF, yiew.layout_toLeftOf);
            if (yiew.layout_alignParentLeft)
                params1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

            if (yiew.layout_alignParentTop)
                params1.addRule(RelativeLayout.ALIGN_PARENT_TOP);

            if (yiew.layout_alignParentRight)
                params1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

            if (yiew.layout_alignParentBottom)
                params1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);


            if (yiew.layout_toLeftOf != 0)
                params1.addRule(RelativeLayout.LEFT_OF, yiew.layout_toLeftOf);

            if (yiew.layout_toRightOf != 0)
                params1.addRule(RelativeLayout.RIGHT_OF, yiew.layout_toRightOf);

            if (yiew.layout_above != 0)
                params1.addRule(RelativeLayout.ABOVE, yiew.layout_above);

            if (yiew.layout_below != 0)
                params1.addRule(RelativeLayout.BELOW, yiew.layout_below);


            if (yiew.layout_alignLeft != 0)
                params1.addRule(RelativeLayout.ALIGN_LEFT, yiew.layout_alignLeft);

            if (yiew.layout_alignRight != 0)
                params1.addRule(RelativeLayout.ALIGN_RIGHT, yiew.layout_alignRight);

            if (yiew.layout_alignTop != 0)
                params1.addRule(RelativeLayout.ALIGN_TOP, yiew.layout_alignTop);

            if (yiew.layout_alignBottom != 0)
                params1.addRule(RelativeLayout.ALIGN_BOTTOM, yiew.layout_alignBottom);

            if (yiew.layout_alignBaseline != 0)
                params1.addRule(RelativeLayout.ALIGN_BASELINE, yiew.layout_alignBaseline);


            if (yiew.layout_centerInParent)
                params1.addRule(RelativeLayout.CENTER_IN_PARENT);

            if (yiew.layout_centerHorizontal)
                params1.addRule(RelativeLayout.CENTER_HORIZONTAL);

            if (yiew.layout_centerVertical)
                params1.addRule(RelativeLayout.CENTER_VERTICAL);


//            if (yiew.layout_centerVertical)
//                params1.addRule(RelativeLayout.CENTER_VERTICAL);


        } else if (params instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams params1 = (FrameLayout.LayoutParams) params;
            if (yiew.layout_gravity != null)
                params1.gravity = (int) Utils.getValueInt(Gravity.class, yiew.layout_gravity.toUpperCase());


        }


    }
}
