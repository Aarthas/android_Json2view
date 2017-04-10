package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.bean.ComponentBean;
import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.bean.YiewResp;

import java.util.List;

/**
 * Created by zhangyn on 17/4/7.
 */

public class Main {

    public static View startProcess(Context context, YiewResp yiewResp) {



        if ("AndroidLayout".equals(yiewResp.head.process)) {
            List<ComponentBean> component = yiewResp.head.component;
            if (component != null) {
                for (ComponentBean componentBean : component) {
                    final Yiew template = componentBean.template;

                    IComponent line = new IComponent() {
                        @Override
                        public View createView(Context context, ViewGroup parent, Yiew yiew) {


                            Utils.merge(yiew, template);

                            yiew.setRootComponet(yiew);


                            return YiewEngine.createView(context, parent, yiew);

                        }
                    };
                    YiewConfig.addComponent(componentBean.name, line);

                }
            }


            yiewResp.template.setYiewStore(new YiewStore());


            return YiewEngine.createView(context, null, yiewResp.template);


        }

        return null;

    }
}
