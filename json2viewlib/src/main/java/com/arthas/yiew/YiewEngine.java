package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.decode.Yiew;
import com.arthas.yiew.decode.YiewBean;
import com.arthas.yiew.process.FrameLayoutProcess;
import com.arthas.yiew.process.HorizonLayoutProcess;
import com.arthas.yiew.process.ImageViewProcess;
import com.arthas.yiew.process.RelativeLayoutProcess;
import com.arthas.yiew.process.ScrollViewProcess;
import com.arthas.yiew.process.SimpleViewProcess;
import com.arthas.yiew.process.TextViewProcess;
import com.arthas.yiew.process.VerticalLayoutProcess;


/**
 * Created by zhangyn on 17/3/28.
 */

public class YiewEngine {


    public static void addChild(Context context, Yiew yiew, ViewGroup view, YiewStore yiewStore) {

        if (yiew.child != null && yiew.child.size() > 0) {
            for (YiewBean child : yiew.child) {
                Yiew   child1 =    (Yiew) child;
                child1.yiewStore = yiew.yiewStore;
                View childView = createView(context, view, child1, yiewStore);
                if (childView != null) {
                    view.addView(childView);
                }

            }
        }


    }


    public static View createView(Context context, ViewGroup parent, Yiew yiew, YiewStore yiewStore) {

        if (yiew.yiewStore == null) {
            if (yiewStore == null) {
                yiewStore = new YiewStore();
                yiew.yiewStore = yiewStore;
            } else {
                yiew.yiewStore = yiewStore;
            }

        }


        switch (yiew.view) {

            case Yiew.verticalLayout: {


                View view = VerticalLayoutProcess.createView(context, parent, yiew, yiewStore);

                if (view instanceof ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group, yiewStore);
                }


                return view;

            }

            case Yiew.horizonLayout: {
                View view = HorizonLayoutProcess.createView(context, parent, yiew, yiewStore);


                if (view instanceof ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group, yiewStore);
                }
//                if (yiewStore != null) {
//                    yiewStore.put(yiew, view);
//                }
                return view;

            }


            case Yiew.TextView: {
                View view = TextViewProcess.createView(context, parent, yiew, yiewStore);


//                if (yiewStore != null) {
//                    yiewStore.put(yiew, view);
//                }
                return view;
            }

            case Yiew.ImageView: {
                View view = ImageViewProcess.createView(context, parent, yiew, yiewStore);


//                if (yiewStore != null) {
//                    yiewStore.put(yiew, view);
//                }
                return view;

            }
            case Yiew.View: {
                View view = SimpleViewProcess.createYiew(context, parent, yiew, yiewStore);

//                if (yiewStore != null) {
//                    yiewStore.put(yiew, view);
//                }
                return view;

            }
            case Yiew.ScrollView: {
                View view = ScrollViewProcess.createView(context, parent, yiew, yiewStore);
//                if (yiewStore != null) {
//                    yiewStore.put(yiew, view);
//                }
                if (view instanceof ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group, yiewStore);
                }
                return view;

            }
            case Yiew.RelativeLayout: {
                View view = RelativeLayoutProcess.createView(context, parent, yiew, yiewStore);
//                if (yiewStore != null) {
//                    yiewStore.put(yiew, view);
//                }

                if (view instanceof ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group, yiewStore);
                }
                return view;
            }

            case Yiew.FrameLayout: {
                View view = FrameLayoutProcess.createView(context, parent, yiew, yiewStore);

//                if (yiewStore != null) {
//                    yiewStore.put(yiew, view);
//                }
                if (view instanceof ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group, yiewStore);
                }
                return view;
            }


            default:
                break;
        }

        IProcess process = YiewConfig.findProcess(yiew.view);
        if (process != null) {

            View childView = process.createView(context, parent, yiew, yiewStore);
//            if (yiewStore != null) {
//                yiewStore.put(yiew, childView);
//            }

            if (childView != null) {
                return childView;
            }
        }

        return null;

    }


    public static void invalid(Yiew yiewBean) {

        TextViewProcess.refresh(yiewBean);
    }
}
