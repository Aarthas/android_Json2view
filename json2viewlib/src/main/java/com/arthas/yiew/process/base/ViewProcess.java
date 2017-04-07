package com.arthas.yiew.process.base;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewStore;
import com.arthas.yiew.bean.PropertyBean;
import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.bean.YiewBean;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by zhangyn on 17/4/1.
 */

public class ViewProcess {
    public static void applyView(final View view, final Yiew yiew, YiewStore yiewStore) {


        if (yiewStore != null) {
            yiewStore.put(yiew, view);
        }


        if (yiew.id != 0) {
            view.setId(yiew.id);

        }
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

            yiew.background = Utils.getValueStringIfDataExist(yiew, yiew.background, yiew.background);
            view.setBackgroundColor(Utils.parseColor(yiew.background));

        }


        if (yiew.click != null) {

            view.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            Context context = v.getContext();
                                            try {
                                                Method myClick = context.getClass().getMethod(yiew.click);
                                                myClick.invoke(context);
                                            } catch (Exception e) {

                                            }
                                            try {
                                                Method myClick2 = context.getClass().getMethod(yiew.click, Yiew.class);
                                                myClick2.invoke(context, yiew);
                                            } catch (Exception e) {

                                            }


                                        }
                                    }
            );

        }
        if (yiew.visibility != null) {
            if (yiew.visibility.startsWith("&")) {
                yiew.visibility = Utils.getValueStringIfDataExist(yiew, yiew.visibility, "");
            }
            switch (yiew.visibility) {
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


        applyProperties(view, yiew);

    }

    public static void applyProperties(View view, YiewBean yiew) {
        List<PropertyBean> propertys = yiew.propertys;
        Log.d("syb", "set property" + propertys);
        if (propertys != null && propertys.size() > 0) {
            Class<? extends View> aClass = view.getClass();
            Log.d("syb", " aClass  =" + aClass);
            for (PropertyBean propertyBean : propertys) {
                String name = propertyBean.name;


                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                Log.d("syb", "set method  =" + methodName);
                try {

                    Class classType = propertyBean.getClassType();
                    Method method = aClass.getMethod(methodName, classType);
                    method.invoke(view, propertyBean.getValueClassType(classType));
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d("syb", "e" + e);
                }
            }
        }


    }
}
