package com.arthas.xjsonview;

import com.arthas.xjsonview.bean.XView;

/**
 * Created by zhangyn on 17/4/14.
 */

public class ComponentManager {
    public static XViewComponent findComponent(String view, XViewStore yiewStore) {
        if (yiewStore!= null)
        {
            XViewComponent component = yiewStore.findComponent(view);
            if (component != null)
            {
                return component;

            }
        }

        XViewComponent component1 = XiewConfig.findComponent(view);
        if (component1 != null)
        {
            return component1;

        }
        return null;

    }



    public static void addSimpleXViewComponent(XView yiewResp, SimpleXViewComponent yiewComponent, XViewStore yiewStore) {
        if (yiewResp.scope == null) {
            yiewStore.addComponent(yiewComponent.getTemplate().name, yiewComponent);
        } else if ("global".equals(yiewResp.scope)) {
            XiewConfig.addComponent(yiewComponent.getTemplate().name, yiewComponent);
        }
    }
}
