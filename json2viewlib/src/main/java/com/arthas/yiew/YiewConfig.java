package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.arthas.yiew.decode.YiewBean;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/3/30.
 */

public class YiewConfig {


    private static ImageAdapter imageAdapter;
    private static HashMap<String, IProcess> processMap = new HashMap();


    public static void setImageAdapter(ImageAdapter imageAdapter) {
        YiewConfig.imageAdapter = imageAdapter;
    }

    public static ImageAdapter getImageAdapter() {
        return imageAdapter;
    }


    public static void Component(String name, IProcess line) {
        processMap.put(name, line);
    }


    public static IProcess findProcess(String view) {

        if ("scrollView".equals(view)) {
            IProcess iProcess = processMap.get(view);
            if (iProcess == null) {
                iProcess = new IProcess() {
                    @Override
                    public View createView(Context context, ViewGroup parent, YiewBean yiew, YiewStore yiewStore) {
//                        yiew.view = Yiew.verticalLayout;
//
//
//                        View content = YiewEngine.createView(context, parent, yiew,yiewStore);
                        ScrollView view = new ScrollView(context);
//
                        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
                        view.setLayoutParams(params);

                        ViewProcess.applyView(view, yiew, yiewStore);
                        LayoutProcess.applyaLayout(view, params, yiew, yiewStore);


                        view.setVerticalFadingEdgeEnabled(false);
                        view.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
                        view.setFadingEdgeLength(0);


                        YiewBean verticalLayoutyiew = new YiewBean();
                        verticalLayoutyiew.width = "match";
                        verticalLayoutyiew.height = "match";
                        verticalLayoutyiew.view = "verticalLayout";
                        ViewGroup verticalLayout = (ViewGroup) YiewEngine.createView(context, view, verticalLayoutyiew);
                        view.addView(verticalLayout);

                        if (yiewStore != null) {
                            yiewStore.put(yiew, view);
                        }

                        if (verticalLayout instanceof ViewGroup) {
                            ViewGroup group = (ViewGroup) verticalLayout;
                            YiewEngine.addChild(context, yiew, verticalLayout, yiewStore);
                        }
                        return view;



                    }
                };
                processMap.put(view, iProcess);
            }
            return iProcess;
        }
        return processMap.get(view);
    }
}
