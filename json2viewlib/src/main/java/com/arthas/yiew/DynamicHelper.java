package com.arthas.yiew;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Method;
import java.util.List;

import static com.arthas.yiew.Utils.getValueInt;

/**
 * Created by avocarrot on 11/12/2014.
 * Helper function that apply properties in views
 */
public class DynamicHelper {




    public static void applyTextView(TextView view, Yiew yiew) {
        if (yiew.text != null)
            view.setText(yiew.text);
        if (yiew.textColor != null)
            view.setTextColor(Color.parseColor(yiew.textColor));
        if (yiew.textSize != 0)
            view.setTextSize(TypedValue.COMPLEX_UNIT_SP, yiew.textSize);
        if (yiew.hint != null)
            view.setHint(yiew.hint);
        if (yiew.maxLine != 0)
            view.setMaxLines(yiew.maxLine);
        if (yiew.hintColor != null)
            view.setHintTextColor(Color.parseColor(yiew.hintColor));

        if (yiew.gravity != null)
            view.setGravity((Integer) getValueInt(Gravity.class, yiew.gravity.toUpperCase()));


    }

    public static void applyImageView(ImageView view, Yiew yiew) {
//        Log.d("syb", "yiew.src" + yiew.src);
        if (yiew.src != null) {
            YiewConfig.getImageAdapter().display(view,yiew.src, yiew);


        }


        if (yiew.scaleType != null)
            view.setScaleType(ImageView.ScaleType.valueOf(yiew.scaleType));
        else
            view.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public static void applyView(final View view, final Yiew yiew) {
        if (yiew.id != 0) {
            view.setId(yiew.id);
        }
        if (yiew.tag != null) {
            view.setTag(yiew.tag);
        }
        if (yiew.padding != 0) {

            int padding = Utils.dip2px(yiew.padding);
            view.setPadding(padding, padding, padding, padding);
        } else {
            view.setPadding(Utils.dip2px(yiew.paddingLeft), Utils.dip2px(yiew.paddingTop), Utils.dip2px(yiew.paddingRight), Utils.dip2px(yiew.paddingBottom));
        }
        if (yiew.background != null) {

            if (yiew.background.startsWith("#")) {
                view.setBackgroundColor(Color.parseColor(yiew.background));
            }
        }


        if (yiew.click != null) {

            view.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            try {
                                                Context context = v.getContext();
                                                Method myClick = context.getClass().getMethod(yiew.click);
                                                if (myClick != null) {
                                                    myClick.invoke(context);
                                                }
                                            } catch (Exception ee) {
                                                Log.d("syb", "viewById1002" + ee);
                                            }
                                        }
                                    }
            );

        }
        if (yiew.visibility != null) {
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

    public static void applyaLayout(View view, ViewGroup.LayoutParams params, Yiew yiew) {
        if (params instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = ((ViewGroup.MarginLayoutParams) params);
            if (yiew.margin != 0) {
                int margin = Utils.dip2px(yiew.margin);
                p.setMargins(margin, margin, margin, margin);
            } else {
                p.setMargins(Utils.dip2px(yiew.marginLeft), Utils.dip2px(yiew.marginTop), Utils.dip2px(yiew.marginRight), Utils.dip2px(yiew.marginBottom));
            }
        }

        if (params instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) params;
            if (yiew.layout_gravity != null)
                params1.gravity = (int) Utils.getValueInt(Gravity.class, yiew.layout_gravity.toUpperCase());
            if (yiew.weight != 0)
                params1.weight = yiew.weight;

        } else if (params instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) params;
//            params1.addRule(RelativeLayout.LEFT_OF, yiew.layout_toLeftOf);
            if (yiew.layout_alignParentLeft)
                params1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

            if (yiew.layout_alignParentTop)
                params1.addRule(RelativeLayout.ALIGN_PARENT_TOP);

            if (yiew.layout_alignParentRight)
                params1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

            if (yiew.layout_alignParentBottom)
                params1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);


            if (yiew.layout_toLeftOf != 0)
                params1.addRule(RelativeLayout.LEFT_OF, yiew.layout_toLeftOf);

            if (yiew.layout_toRightOf != 0)
                params1.addRule(RelativeLayout.RIGHT_OF, yiew.layout_toRightOf);

            if (yiew.layout_above != 0)
                params1.addRule(RelativeLayout.ABOVE, yiew.layout_above);

            if (yiew.layout_below != 0)
                params1.addRule(RelativeLayout.BELOW, yiew.layout_below);


            if (yiew.layout_alignLeft != 0)
                params1.addRule(RelativeLayout.ALIGN_LEFT, yiew.layout_alignLeft);

            if (yiew.layout_alignRight != 0)
                params1.addRule(RelativeLayout.ALIGN_RIGHT, yiew.layout_alignRight);

            if (yiew.layout_alignTop != 0)
                params1.addRule(RelativeLayout.ALIGN_TOP, yiew.layout_alignTop);

            if (yiew.layout_alignBottom != 0)
                params1.addRule(RelativeLayout.ALIGN_BOTTOM, yiew.layout_alignBottom);

            if (yiew.layout_alignBaseline != 0)
                params1.addRule(RelativeLayout.ALIGN_BASELINE, yiew.layout_alignBaseline);


            if (yiew.layout_centerInParent)
                params1.addRule(RelativeLayout.CENTER_IN_PARENT);

            if (yiew.layout_centerHorizontal)
                params1.addRule(RelativeLayout.CENTER_HORIZONTAL);

            if (yiew.layout_centerVertical)
                params1.addRule(RelativeLayout.CENTER_VERTICAL);


//            if (yiew.layout_centerVertical)
//                params1.addRule(RelativeLayout.CENTER_VERTICAL);


        }


    }

    public static void applyLinearLayout(LinearLayout view, Yiew yiew) {
        if (yiew.gravity != null)
            view.setGravity((Integer) getValueInt(Gravity.class, yiew.gravity.toUpperCase()));


    }

    public static void applyRelativeLayout(RelativeLayout view, Yiew yiew) {
        if (yiew.gravity != null)
            view.setGravity((Integer) getValueInt(Gravity.class, yiew.gravity.toUpperCase()));

    }

    public static void applyProperties(View view, Yiew yiew) {
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
