package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.bean.Yiew;


/**
 * Created by zhangyn on 17/3/28.
 */

public class YiewEngine {


    public static void addChild(Context context, ViewGroup view, Yiew parentYiew) {

        if (parentYiew.child != null && parentYiew.child.size() > 0) {
            for (Yiew child : parentYiew.child) {

                if (parentYiew.getYiewStore() != null) {
                    child.setYiewStore(parentYiew.getYiewStore());
                }
                if (parentYiew.getRootComponet() != null) {
                    child.setRootComponet(parentYiew.getRootComponet());
                }
                child.parentNode = parentYiew;

                View childView = createView(context, view, child);
                if (childView != null) {
                    view.addView(childView);
                }

            }
        }


    }


    public static View createView(Context context, ViewGroup parent, Yiew yiew) {

        IComponent component = YiewConfig.findComponent(yiew.view);
        if (component != null) {
            View view = component.createComponentView(context, parent, yiew);
            return view;
        }
        return null;
    }


//    public static void invalid(Yiew yiewBean) {
//
//        TextViewProcess.refresh(yiewBean);
//    }


}
