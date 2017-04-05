package com.arthas.yiew.decode;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewConfig;
import com.arthas.yiew.YiewDelegate;
import com.arthas.yiew.process.DvProcess;
import com.arthas.yiew.process.FrameLayoutProcess;
import com.arthas.yiew.process.HorizonLayoutProcess;
import com.arthas.yiew.process.ImageViewProcess;
import com.arthas.yiew.process.RelativeLayoutProcess;
import com.arthas.yiew.process.ScrollViewProcess;
import com.arthas.yiew.process.TextViewProcess;
import com.arthas.yiew.process.VerticalLayoutProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class Yiewv2 extends Yiew {




    public transient View generatedView;
    public transient ViewGroup parentView;
    public transient YiewDelegate yiewDelegate;

    public void setYiewDelegate(YiewDelegate yiewDelegate) {
        this.yiewDelegate = yiewDelegate;
    }

    private void proceeChildYiew(Context context) {

        if (generatedView instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) generatedView;
            if (this.child != null && this.child.size() > 0) {


                for (YiewBean yiew1 : child) {
                    Yiewv2 child = (Yiewv2) yiew1;
                    child.parentView = group;
                    child.yiewDelegate = yiewDelegate;

                    View childView = child.process(context);

                    if (childView != null) {
                        group.addView(childView);
                    }

                }
            }
        }
    }

    public View process(Context context) {

        if (this.name != null) {
            this.id = Utils.generateViewId();
            if (yiewDelegate != null) {
                yiewDelegate.put(this.name, this);
            }
        }


        switch (view) {

            case Yiew.verticalLayout: {

                android.view.View generatedView = VerticalLayoutProcess.process(context, this);
                this.generatedView = generatedView;
                proceeChildYiew(context);

                return generatedView;

            }

            case Yiew.horizonLayout: {
                android.view.View generatedView = HorizonLayoutProcess.process(context, this);
                this.generatedView = generatedView;
                proceeChildYiew(context);

                return generatedView;

            }


            case Yiew.TextView: {

                android.view.View generatedView = TextViewProcess.process(context, this);
                this.generatedView = generatedView;
                proceeChildYiew(context);

                return generatedView;


            }

            case Yiew.ImageView: {
                android.view.View generatedView = ImageViewProcess.process(context, this);

                this.generatedView = generatedView;
                proceeChildYiew(context);

                return generatedView;


            }
            case Yiew.View: {
                android.view.View process = DvProcess.process(context, this);
                this.generatedView = generatedView;
                proceeChildYiew(context);

                return process;


            }
            case Yiew.ScrollView: {
                android.view.View generatedView = ScrollViewProcess.process(context, this);
                this.generatedView = generatedView;
                proceeChildYiew(context);

                return generatedView;


            }
//            case Yiew.scrollView: {
//                ScrollView view = new ScrollView(context);
//
//                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
//                view.setLayoutParams(params);
//
//
//                LayoutProcess.applyaLayout(view, params, yiew);
//                ViewProcess.applyView(view, yiew);
//
//                view.setVerticalFadingEdgeEnabled(false);
//                view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
//                view.setFadingEdgeLength(0);
//
//
//                YiewBean verticalLayoutyiew = new YiewBean();
//                verticalLayoutyiew.width = "match";
//                verticalLayoutyiew.height = "match";
//                verticalLayoutyiew.view = "verticalLayout";
//                ViewGroup verticalLayout = (ViewGroup) createView(context, view, verticalLayoutyiew);
//                view.addView(verticalLayout);
//
//                if (yiew.child != null && yiew.child.size() > 0) {
//                    for (YiewBean yiew1 : yiew.child) {
//                        View childView = createView(context, verticalLayout, yiew1);
//                        if (childView != null)
//                            verticalLayout.addView(childView);
//                    }
//
//                }
//                return view;
//
//            }
            case Yiew.RelativeLayout: {
                android.view.View generatedView = RelativeLayoutProcess.process(context, this);
                this.generatedView = generatedView;
                proceeChildYiew(context);

                return generatedView;

            }

            case Yiew.FrameLayout: {
                android.view.View generatedView = FrameLayoutProcess.process(context, this);
                this.generatedView = generatedView;
                proceeChildYiew(context);

                return generatedView;

            }


            default:
                break;
        }

        Yiew yiew1 = YiewConfig.getMap().get(view);
        if (yiew1 != null) {

            Log.d("syb", yiew1.toString());
            Utils.copy(this, yiew1);
            Log.d("syb", yiew1.toString());

            android.view.View generatedView = this.process(context);
            this.generatedView = generatedView;
            this.proceeChildYiew(context);
            if (generatedView != null) {
                return generatedView;
            }
        }

        return null;


    }

    public android.view.View createView(Context context, ViewGroup parentView) {
        this.parentView = parentView;
        View process = process(context);
        return process;

    }
}
