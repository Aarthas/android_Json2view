package com.arthas.xjsonview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.xjsonview.bean.XViewBody;


/**
 * Created by zhangyn on 17/3/28.
 */

public class XViewEngine {


    public static void addChild(Context context, ViewGroup view, XViewBody parentYiew) {

        if (parentYiew.child != null && parentYiew.child.size() > 0) {
            for (XViewBody child : parentYiew.child) {

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


    public static View createView(Context context, ViewGroup parent, XViewBody yiew) {

        if (yiew.getYiewStore() != null) {
            XViewComponent component = yiew.getYiewStore().findComponent(yiew.view);
            if (component != null) {
                View view = component.createComponentView(context, parent, yiew);
                return view;
            }
        }

        XViewComponent component = XiewConfig.findComponent(yiew.view);
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
