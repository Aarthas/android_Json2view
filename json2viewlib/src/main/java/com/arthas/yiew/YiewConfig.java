package com.arthas.yiew;

import com.arthas.yiew.process.FrameLayoutProcess;
import com.arthas.yiew.process.HorizonLayoutProcess;
import com.arthas.yiew.process.ImageViewProcess;
import com.arthas.yiew.process.RelativeLayoutProcess;
import com.arthas.yiew.process.ScrollViewProcess;
import com.arthas.yiew.process.SimpleViewProcess;
import com.arthas.yiew.process.TextViewProcess;
import com.arthas.yiew.process.VerticalLayoutProcess;
import com.arthas.yiew.process.diy.ScrollComponent;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/3/30.
 */

public class YiewConfig {


    private static ImageAdapter imageAdapter;
    private static HashMap<String, IComponent> processMap = new HashMap();


    public static void setImageAdapter(ImageAdapter imageAdapter) {
        YiewConfig.imageAdapter = imageAdapter;
    }

    public static ImageAdapter getImageAdapter() {
        return imageAdapter;
    }


    public static void addComponent(String name, IComponent line) {
        processMap.put(name, line);
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

    public static IComponent findComponent(String view) {


//        if ("scrollView".equals(view)) {
//            IComponent iComponent = processMap.get(view);
//            if (iComponent == null) {
//                iComponent = new ScrollComponent();
//                processMap.put(view, iComponent);
//            }
//            return iComponent;
//        }
        return processMap.get(view);
    }
}
