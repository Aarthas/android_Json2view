package com.arthas.yiew;

import android.content.Context;
import android.view.View;

import com.arthas.yiew.bean.ComponentBean;
import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.bean.YiewResp;

import java.util.List;

/**
 * Created by zhangyn on 17/4/7.
 */

public class Main {

    public static View startProcess(Context context, YiewResp yiewResp) {

        YiewStore yiewStore = new YiewStore();
        if ("AndroidLayout".equals(yiewResp.head.process)) {
            List<ComponentBean> component = yiewResp.head.component;
            if (component != null) {
                for (ComponentBean componentBean : component) {
                    final Yiew template = componentBean.template;
                    YiewComponent yiewComponent = new YiewComponent(template);

                    if (yiewResp.scope == null) {
                        yiewStore.addComponent(componentBean.name, yiewComponent);
                    } else if ("global".equals(yiewResp.scope)) {
                        YiewConfig.addComponent(componentBean.name, yiewComponent);
                    }


                }
            }


            yiewResp.template.setYiewStore(yiewStore);


            return YiewEngine.createView(context, null, yiewResp.template);


        }

        return null;

    }
}
