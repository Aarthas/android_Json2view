package com.arthas.yiew;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.arthas.yiew.decode.Yiew;
import com.arthas.yiew.decode.YiewBean;
import com.arthas.yiew.process.LayoutProcess;
import com.arthas.yiew.process.ViewProcess;


/**
 * Created by zhangyn on 17/3/28.
 */

public class YiewEngine {


    public static View createYiew(Context context, ViewGroup parent, YiewBean yiew) {


        switch (yiew.view) {

            case Yiew.verticalLayout: {


                LinearLayout view = new LinearLayout(context);
                view.setOrientation(LinearLayout.VERTICAL);

                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                LayoutProcess.applyaLayout(view, params, yiew);
                ViewProcess.applyView(view, yiew);
                DynamicHelper.applyLinearLayout(view, yiew);


                addChild(context, yiew, view);
                return view;

            }

            case Yiew.horizonLayout: {
                LinearLayout view = new LinearLayout(context);
                view.setOrientation(LinearLayout.HORIZONTAL);
                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                LayoutProcess.applyaLayout(view, params, yiew);
                ViewProcess.applyView(view, yiew);
                DynamicHelper.applyLinearLayout(view, yiew);


                addChild(context, yiew, view);
                return view;

            }


            case Yiew.TextView: {
                TextView view = new TextView(context);
                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                LayoutProcess.applyaLayout(view, params, yiew);
                ViewProcess.applyView(view, yiew);

                DynamicHelper.applyTextView(view, yiew);


                return view;
            }

            case Yiew.ImageView: {
                ImageView view = new ImageView(context);
                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                LayoutProcess.applyaLayout(view, params, yiew);
                ViewProcess.applyView(view, yiew);
                DynamicHelper.applyImageView(view, yiew);


                return view;

            }
            case Yiew.View: {
                View view = new View(context);
                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                LayoutProcess.applyaLayout(view, params, yiew);
                ViewProcess.applyView(view, yiew);


                return view;

            }
            case Yiew.ScrollView: {
                ScrollView view = new ScrollView(context);

                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);

                view.setVerticalFadingEdgeEnabled(false);
                view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
                view.setFadingEdgeLength(0);

                LayoutProcess.applyaLayout(view, params, yiew);
                ViewProcess.applyView(view, yiew);

                view.setVerticalFadingEdgeEnabled(false);
                view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
                view.setFadingEdgeLength(0);


                addChild(context, yiew, view);
                return view;

            }
            case Yiew.scrollView: {
                ScrollView view = new ScrollView(context);

                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                LayoutProcess.applyaLayout(view, params, yiew);
                ViewProcess.applyView(view, yiew);

                view.setVerticalFadingEdgeEnabled(false);
                view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
                view.setFadingEdgeLength(0);


                YiewBean verticalLayoutyiew = new YiewBean();
                verticalLayoutyiew.width = "match";
                verticalLayoutyiew.height = "match";
                verticalLayoutyiew.view = "verticalLayout";
                ViewGroup verticalLayout = (ViewGroup) createYiew(context, view, verticalLayoutyiew);
                view.addView(verticalLayout);

                if (yiew.child != null && yiew.child.size() > 0) {
                    for (YiewBean yiew1 : yiew.child) {
                        View childView = createYiew(context, verticalLayout, yiew1);
                        if (childView != null)
                            verticalLayout.addView(childView);
                    }

                }
                return view;

            }
            case Yiew.RelativeLayout: {
                RelativeLayout view = new RelativeLayout(context);

                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                LayoutProcess.applyaLayout(view, params, yiew);
                ViewProcess.applyView(view, yiew);
                DynamicHelper.applyRelativeLayout(view, yiew);

                addChild(context, yiew, view);
                return view;
            }

            case Yiew.FrameLayout: {
                FrameLayout view = new FrameLayout(context);

                ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                view.setLayoutParams(params);


                LayoutProcess.applyaLayout(view, params, yiew);
                ViewProcess.applyView(view, yiew);


                addChild(context, yiew, view);
                return view;
            }


            default:
                break;
        }

        YiewBean yiew1 = YiewConfig.getMap().get(yiew.view);
        if (yiew1 != null) {

            Log.d("syb",yiew1.toString());
            Utils.copy(yiew1, yiew);
            Log.d("syb",yiew1.toString());

            View childView = createYiew(context, parent, yiew1);
            if (childView != null) {
                return childView;
            }
        }

        return null;
    }




    private static void addChild(Context context, YiewBean yiew, ViewGroup view) {
        if (yiew.child != null && yiew.child.size() > 0) {
            for (YiewBean yiew1 : yiew.child) {
                View childView = createYiew(context, view, yiew1);
                if (childView != null) {
                    view.addView(childView);
                }

            }
        }
    }
}
