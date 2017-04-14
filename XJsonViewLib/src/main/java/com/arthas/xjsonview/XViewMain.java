package com.arthas.xjsonview;

import android.content.Context;
import android.view.View;

import com.arthas.xjsonview.bean.XView;
import com.arthas.xjsonview.bean.XViewBody;

import java.util.List;

/**
 * Created by zhangyn on 17/4/7.
 */

public class XViewMain {

    public static View startProcess(Context context, XView yiewResp) {

        XViewStore yiewStore = new XViewStore();
        if ("AndroidLayout".equals(yiewResp.head.process)) {
            List<XViewBody> components = yiewResp.head.components;
            if (components != null) {
                for (XViewBody xViewComponentBean : components) {

                    SimpleXViewComponent yiewComponent = new SimpleXViewComponent(xViewComponentBean);

                    ComponentManager.addSimpleXViewComponent(yiewResp,yiewComponent,yiewStore);



                }
            }


            yiewResp.template.setYiewStore(yiewStore);


            return XViewEngine.createView(context, null, yiewResp.template);


        }

        return null;

    }
}
