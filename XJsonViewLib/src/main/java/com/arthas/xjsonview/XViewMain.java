package com.arthas.xjsonview;

import android.content.Context;
import android.view.View;

import com.arthas.xjsonview.bean.XViewComponent;
import com.arthas.xjsonview.bean.XViewBody;
import com.arthas.xjsonview.bean.XView;

import java.util.List;

/**
 * Created by zhangyn on 17/4/7.
 */

public class XViewMain {

    public static View startProcess(Context context, XView yiewResp) {

        XViewStore yiewStore = new XViewStore();
        if ("AndroidLayout".equals(yiewResp.head.process)) {
            List<XViewComponent> components = yiewResp.head.components;
            if (components != null) {
                for (XViewComponent XViewComponent : components) {
                    final XViewBody template = XViewComponent.template;
                    SimpleXViewComponent yiewComponent = new SimpleXViewComponent(template);

                    if (yiewResp.scope == null) {
                        yiewStore.addComponent(XViewComponent.name, yiewComponent);
                    } else if ("global".equals(yiewResp.scope)) {
                        XiewConfig.addComponent(XViewComponent.name, yiewComponent);
                    }


                }
            }


            yiewResp.template.setYiewStore(yiewStore);


            return XViewEngine.createView(context, null, yiewResp.template);


        }

        return null;

    }
}
