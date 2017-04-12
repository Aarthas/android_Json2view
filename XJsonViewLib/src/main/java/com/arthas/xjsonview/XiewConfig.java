package com.arthas.xjsonview;

import com.arthas.xjsonview.process.FrameLayoutProcess;
import com.arthas.xjsonview.process.HorizonLayoutProcess;
import com.arthas.xjsonview.process.ImageViewProcess;
import com.arthas.xjsonview.process.RelativeLayoutProcess;
import com.arthas.xjsonview.process.ScrollViewProcess;
import com.arthas.xjsonview.process.SimpleViewProcess;
import com.arthas.xjsonview.process.TextViewProcess;
import com.arthas.xjsonview.process.VerticalLayoutProcess;
import com.arthas.xjsonview.process.diy.ScrollComponent;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/3/30.
 */

public class XiewConfig {


    private static XViewImageAdapter imageAdapter;
    private static HashMap<String, XViewComponent> componentMap = new HashMap();


    public static void setImageAdapter(XViewImageAdapter imageAdapter) {
        XiewConfig.imageAdapter = imageAdapter;
    }

    public static XViewImageAdapter getImageAdapter() {
        return imageAdapter;
    }


    public static void addComponent(String name, XViewComponent line) {
        componentMap.put(name, line);
    }

    static {


        addComponent("verticalLayout", new VerticalLayoutProcess());
        addComponent("horizonLayout", new HorizonLayoutProcess());

        addComponent("ScrollView", new ScrollViewProcess());
        addComponent("scrollView", new ScrollComponent());

        addComponent("RelativeLayout", new RelativeLayoutProcess());
        addComponent("FrameLayout", new FrameLayoutProcess());


        addComponent("TextView", new TextViewProcess());
        addComponent("ImageView", new ImageViewProcess());
        addComponent("View", new SimpleViewProcess());
    }

    public static XViewComponent findComponent(String view) {


//        if ("scrollView".equals(view)) {
//            IComponent iComponent = componentMap.get(view);
//            if (iComponent == null) {
//                iComponent = new ScrollComponent();
//                componentMap.put(view, iComponent);
//            }
//            return iComponent;
//        }
        return componentMap.get(view);
    }
}
