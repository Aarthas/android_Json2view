package com.arthas.yiew;

import android.content.Context;
import android.util.Log;
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

                    IProcess line = new IProcess() {
                        @Override
                        public View createView(Context context, ViewGroup parent, Yiew yiew, YiewStore yiewStore) {
                            yiew.view = template.view;
                            Utils.copy(yiew, template);
                            yiew.rootComponet = yiew;

                            Log.d("syb","componet_0 "+yiew);
                            Log.d("syb","componet_0 "+yiew.data);
                            Log.d("syb","componet_0 "+template.data);
                            return YiewEngine.createView(context, parent, yiew, yiewStore);

                        }
                    };
                    YiewConfig.Component(componentBean.name, line);

                }
            }


            YiewStore yiewStore = new YiewStore();
            yiewResp.template.yiewStore = yiewStore;


            return YiewEngine.createView(context, null, yiewResp.template, yiewStore);


        }

        return null;

    }
}
