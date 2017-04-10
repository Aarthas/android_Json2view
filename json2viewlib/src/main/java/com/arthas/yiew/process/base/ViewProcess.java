package com.arthas.yiew.process.base;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.arthas.yiew.Utils;
import com.arthas.yiew.bean.Yiew;

import java.lang.reflect.Method;

/**
 * Created by zhangyn on 17/4/1.
 */

public class ViewProcess {
    public static void applyView(final View view, final Yiew yiew) {


        if (yiew.getYiewStore() != null) {
            yiew.getYiewStore().cacheNamedYiew(yiew, view);
        }


        if (yiew.id != 0) {
            view.setId(yiew.id);

        }
        render(view, yiew);


//        applyProperties(view, yiew);

    }

    public static void render(View view, final Yiew yiew) {
        if (yiew.tag != null) {
            view.setTag(yiew.tag);
        }
        if (yiew.padding != null) {

            int padding = Utils.meatureWithUnit(yiew.padding);
            view.setPadding(padding, padding, padding, padding);
        } else {
            view.setPadding(Utils.meatureWithUnit(yiew.paddingLeft), Utils.meatureWithUnit(yiew.paddingTop), Utils.meatureWithUnit(yiew.paddingRight), Utils.meatureWithUnit(yiew.paddingBottom));
        }
        if (yiew.background != null) {
            String background = yiew.getBackground();
//            Log.d("syb","background="+background);
            if (background != null) {
                view.setBackgroundColor(Utils.parseColor(background));
            }

        }


        if (yiew.onClick != null) {

            view.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            Context context = v.getContext();
                                            try {
                                                Method myClick = context.getClass().getMethod(yiew.onClick);
                                                myClick.invoke(context);
                                            } catch (Exception e) {

                                            }
                                            try {
                                                Method myClick2 = context.getClass().getMethod(yiew.onClick, Yiew.class);
                                                myClick2.invoke(context, yiew);
                                            } catch (Exception e) {

                                            }


                                        }
                                    }
            );

        }
        if (yiew.visibility != null) {

            String visibility = null;
            if (yiew.visibility.startsWith("&")) {
                visibility = Utils.getValueStringIfDataExist(yiew, yiew.visibility, "visible");
            } else {
                visibility = yiew.visibility;
            }
            Log.d("syb", "yiew.visibility2 = " + yiew.visibility);
            switch (visibility) {
                case "gone": {
                    view.setVisibility(View.GONE);
                }
                break;
                case "visible": {
                    view.setVisibility(View.VISIBLE);
                }
                break;
                case "invisible": {
                    view.setVisibility(View.INVISIBLE);
                }
                break;
            }
        }
    }


//    public static void applyProperties(View view, YiewBean yiew) {
//        List<PropertyBean> propertys = yiew.propertys;
//        Log.d("syb", "set property" + propertys);
//        if (propertys != null && propertys.size() > 0) {
//            Class<? extends View> aClass = view.getClass();
//            Log.d("syb", " aClass  =" + aClass);
//            for (PropertyBean propertyBean : propertys) {
//                String name = propertyBean.name;
//
//
//                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
//                Log.d("syb", "set method  = " + methodName);
//                try {
//
//                    Class classType = propertyBean.getClassType();
//                    Method method = aClass.getMethod(methodName, classType);
//                    method.invoke(view, propertyBean.getValueClassType(classType));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.d("syb", "e" + e);
//                }
//            }
//        }
//
//
//    }
}
