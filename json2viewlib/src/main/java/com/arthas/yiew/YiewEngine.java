package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.bean.YiewBean;
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


    public static void addChild(Context context, Yiew parentYiew, ViewGroup view) {

        if (parentYiew.child != null && parentYiew.child.size() > 0) {
            for (YiewBean child : parentYiew.child) {
                Yiew child1 = (Yiew) child;
                if (parentYiew.getYiewStore() != null){
                    child1.setYiewStore(parentYiew.getYiewStore());
                }
                if (parentYiew.getRootComponet() != null) {
                    child1.setRootComponet(parentYiew.getRootComponet());
                }
                child1.parentNode = parentYiew;
                View childView = createView(context, view, child1);
                if (childView != null) {
                    view.addView(childView);
                }

            }
        }


    }


    public static View createView(Context context, ViewGroup parent, Yiew yiew) {


        switch (yiew.view) {

            case Yiew.verticalLayout: {


                View view = VerticalLayoutProcess.createView(context, parent, yiew);

                if (view instanceof ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group);
                }


                return view;

            }

            case Yiew.horizonLayout: {
                View view = HorizonLayoutProcess.createView(context, parent, yiew);


                if (view instanceof ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group);
                }
//                if (yiewStore != null) {
//                    yiewStore.cacheNamedYiew(yiew, view);
//                }
                return view;

            }


            case Yiew.TextView: {
                View view = TextViewProcess.createView(context, parent, yiew);


//                if (yiewStore != null) {
//                    yiewStore.cacheNamedYiew(yiew, view);
//                }
                return view;
            }

            case Yiew.ImageView: {
                View view = ImageViewProcess.createView(context, parent, yiew);


//                if (yiewStore != null) {
//                    yiewStore.cacheNamedYiew(yiew, view);
//                }
                return view;

            }
            case Yiew.View: {
                View view = SimpleViewProcess.createYiew(context, parent, yiew);

//                if (yiewStore != null) {
//                    yiewStore.cacheNamedYiew(yiew, view);
//                }
                return view;

            }
            case Yiew.ScrollView: {
                View view = ScrollViewProcess.createView(context, parent, yiew);
//                if (yiewStore != null) {
//                    yiewStore.cacheNamedYiew(yiew, view);
//                }
                if (view instanceof ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group);
                }
                return view;

            }
            case Yiew.RelativeLayout: {
                View view = RelativeLayoutProcess.createView(context, parent, yiew);
//                if (yiewStore != null) {
//                    yiewStore.cacheNamedYiew(yiew, view);
//                }

                if (view instanceof ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group);
                }
                return view;
            }

            case Yiew.FrameLayout: {
                View view = FrameLayoutProcess.createView(context, parent, yiew);

//                if (yiewStore != null) {
//                    yiewStore.cacheNamedYiew(yiew, view);
//                }
                if (view instanceof ViewGroup) {
                    ViewGroup group = (ViewGroup) view;
                    addChild(context, yiew, group);
                }
                return view;
            }


            default:
                break;
        }

        IComponent component = YiewConfig.findComponent(yiew.view);
        if (component != null) {

            View childView = component.createView(context, parent, yiew);

            if (childView != null) {
                return childView;
            }
        }

        return null;

    }


//    public static void invalid(Yiew yiewBean) {
//
//        TextViewProcess.refresh(yiewBean);
//    }


}
