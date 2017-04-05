package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.arthas.yiew.decode.Yiew;
import com.arthas.yiew.decode.YiewBean;
import com.arthas.yiew.process.DvProcess;
import com.arthas.yiew.process.FrameLayoutProcess;
import com.arthas.yiew.process.HorizonLayoutProcess;
import com.arthas.yiew.process.ImageViewProcess;
import com.arthas.yiew.process.RelativeLayoutProcess;
import com.arthas.yiew.process.ScrollViewProcess;
import com.arthas.yiew.process.TextViewProcess;
import com.arthas.yiew.process.VerticalLayoutProcess;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;


/**
 * Created by zhangyn on 17/3/28.
 */

public class YiewEngine {


    public static View createView(Context context, ViewGroup parent, YiewBean yiew) {


        switch (yiew.view) {

            case Yiew.verticalLayout: {


                View view = VerticalLayoutProcess.createView(context, parent, yiew);

                if (view instanceof  ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group);
                }
                return view;

            }

            case Yiew.horizonLayout: {
                View view = HorizonLayoutProcess.createView(context, parent, yiew);



                if (view instanceof  ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group);
                }
                return view;

            }


            case Yiew.TextView: {
                View view = TextViewProcess.createView(context, parent, yiew);


                return view;
            }

            case Yiew.ImageView: {
                View view = ImageViewProcess.createView(context, parent, yiew);



                return view;

            }
            case Yiew.View: {
                View view = DvProcess.createYiew(context, parent, yiew);


                return view;

            }
            case Yiew.ScrollView: {
                View view = ScrollViewProcess.createView(context, parent, yiew);


                if (view instanceof  ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group);
                }
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
                ViewGroup verticalLayout = (ViewGroup) createView(context, view, verticalLayoutyiew);
                view.addView(verticalLayout);

                if (yiew.child != null && yiew.child.size() > 0) {
                    for (YiewBean yiew1 : yiew.child) {
                        View childView = createView(context, verticalLayout, yiew1);
                        if (childView != null)
                            verticalLayout.addView(childView);
                    }

                }
                return view;

            }
            case Yiew.RelativeLayout: {
                View view = RelativeLayoutProcess.createView(context, parent, yiew);


                if (view instanceof  ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group);
                }
                return view;
            }

            case Yiew.FrameLayout: {
                View view = FrameLayoutProcess.createView(context, parent, yiew);


                if (view instanceof  ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group);
                }
                return view;
            }


            default:
                break;
        }

        IProcess process = YiewConfig.getMap().get(yiew.view);
        if (process != null) {

            View childView = process.createView(context, parent, yiew);
            if (childView != null) {
                return childView;
            }
        }

        return null;
    }




    private static void addChild(Context context, YiewBean yiew, ViewGroup view) {

            if (yiew.child != null && yiew.child.size() > 0) {
                for (YiewBean yiew1 : yiew.child) {
                    View childView = createView(context, view, yiew1);
                    if (childView != null) {
                        view.addView(childView);
                    }

                }
            }


    }
}
