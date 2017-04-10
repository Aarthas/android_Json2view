package com.arthas.yiew.process.base;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.arthas.yiew.Utils;
import com.arthas.yiew.bean.Yiew;

/**
 * Created by zhangyn on 17/4/1.
 */

public class LayoutProcess {

    public static void applyaLayout(View view, ViewGroup.LayoutParams params, Yiew yiew) {
        if (params instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = ((ViewGroup.MarginLayoutParams) params);
//            Log.d("syb", "yiew.margin = " + yiew.margin);
            if (yiew.margin != null) {
                int margin = Utils.meatureWithUnit(yiew.margin);
                p.setMargins(margin, margin, margin, margin);
//                Log.d("syb", "p.setMargins1 = " + margin);
            } else {
                p.setMargins(Utils.meatureWithUnit(yiew.marginLeft), Utils.meatureWithUnit(yiew.marginTop), Utils.meatureWithUnit(yiew.marginRight), Utils.meatureWithUnit(yiew.marginBottom));
//                Log.d("syb", "p.setMargins2 = " + Utils.meatureWithUnit(yiew.marginTop));
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


            if (yiew.layout_centerInParent)
                params1.addRule(RelativeLayout.CENTER_IN_PARENT);

            if (yiew.layout_centerHorizontal)
                params1.addRule(RelativeLayout.CENTER_HORIZONTAL);

            if (yiew.layout_centerVertical)
                params1.addRule(RelativeLayout.CENTER_VERTICAL);




            if (yiew.below != null) {

                int advanceId = getAdvanceId(yiew.below,yiew);
                if (advanceId != 0)
                {
                    params1.addRule(RelativeLayout.BELOW, advanceId);
                }

            }
            if (yiew.toLeftOf != null) {

                int advanceId = getAdvanceId(yiew.toLeftOf,yiew);
                if (advanceId != 0)
                    params1.addRule(RelativeLayout.LEFT_OF, advanceId);
            }

            if (yiew.toRightOf != null) {

                int advanceId = getAdvanceId(yiew.toRightOf,yiew);
                if (advanceId != 0)
                    params1.addRule(RelativeLayout.RIGHT_OF, advanceId);
            }

            if (yiew.above != null) {

                int advanceId = getAdvanceId(yiew.above,yiew);
                if (advanceId != 0)
                    params1.addRule(RelativeLayout.ABOVE, advanceId);
            }

            if (yiew.alignLeft != null) {

                int advanceId = getAdvanceId(yiew.alignLeft,yiew);
                if (advanceId != 0)
                    params1.addRule(RelativeLayout.ALIGN_LEFT, advanceId);
            }
            if (yiew.alignRight != null) {

                int advanceId = getAdvanceId(yiew.alignRight,yiew);
                if (advanceId != 0)
                    params1.addRule(RelativeLayout.ALIGN_RIGHT, advanceId);
            }
            if (yiew.alignTop != null) {

                int advanceId = getAdvanceId(yiew.alignTop,yiew);
                if (advanceId != 0)
                    params1.addRule(RelativeLayout.ALIGN_TOP, advanceId);
            }
            if (yiew.alignBottom != null) {

                int advanceId = getAdvanceId(yiew.alignBottom,yiew);
                if (advanceId != 0)
                    params1.addRule(RelativeLayout.ALIGN_BOTTOM, advanceId);
            }
            if (yiew.alignBaseline != null) {

                int advanceId = getAdvanceId(yiew.alignBaseline,yiew);
                if (advanceId != 0)
                    params1.addRule(RelativeLayout.ALIGN_BASELINE, advanceId);
            }




        } else if (params instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams params1 = (FrameLayout.LayoutParams) params;
            if (yiew.layout_gravity != null)
                params1.gravity = (int) Utils.getValueInt(Gravity.class, yiew.layout_gravity.toUpperCase());


        }


    }

    private static int getAdvanceId(String verb,Yiew yiew) {
        if (verb.startsWith("#")) {
            int id = Integer.parseInt(verb.substring(1));

            return id;
        } else if (verb.startsWith("@")) {
            String name = verb.substring(1);
            Yiew aa = yiew.getYiewStore().getYiewByName(name);
            if (aa != null) {
                return aa.id;
            }
        }
        return 0;
    }
}
