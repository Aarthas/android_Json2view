package com.arthas.yiew.process;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arthas.yiew.IComponent;
import com.arthas.yiew.Utils;
import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class TextViewProcess implements IComponent {
    public  View createComponentView(Context context, ViewGroup parent, Yiew yiew) {
        TextView view = new TextView(context);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);




        ViewProcess.applyView(view, yiew);
        LayoutProcess.applyaLayout(view, params, yiew);

        applyTextView(view, yiew);


        return view;
    }

    @Override
    public void render(Yiew yiew) {
        applyTextView((TextView) yiew.getView(), yiew);
    }

//    public static View refresh(Yiew yiew) {
////        View view = yiew.getView();
////        ViewGroup.LayoutParams params = view.getLayoutParams();
////
////        ViewProcess.applyView(view, yiew);
////        LayoutProcess.applyaLayout(view, params, yiew);
////
////        applyTextView(view, yiew);
//
//
//        return view;
//    }

    public static void applyTextView(TextView view, Yiew yiew) {

        if (yiew.parentNode != null) {
//            if (yiew.textSize == null) {
//                yiew.textSize = yiew.parentNode.textSize;
//            }
//            if (yiew.textColor == null) {
//                yiew.textColor = yiew.parentNode.textColor;
//            }
//            if (yiew.maxLine == 0) {
//                yiew.maxLine = yiew.parentNode.maxLine;
//            }
//            if (yiew.hintColor == null) {
//                yiew.hintColor = yiew.parentNode.hintColor;
//            }
//            if (yiew.lineSpace == null) {
//                yiew.lineSpace = yiew.parentNode.lineSpace;
//            }

//            if (yiew.text == null)
//                yiew.text = yiew.parentNode.text;
//
//            if (yiew.hint == null)
//                yiew.hint = yiew.parentNode.hint;

        }


        if (yiew.text != null) {

            if (yiew.text.startsWith("&")) {

                String a = Utils.getValueStringIfDataExist(yiew, yiew.text, yiew.text);
                view.setText(a);
            } else {
                view.setText(yiew.text);
            }
        }


        if (yiew.textColor != null) {
            if (yiew.textColor.startsWith("&")) {
                String textColor = Utils.getValueStringIfDataExist(yiew, yiew.textColor, null);
                if (textColor != null) {
                    view.setTextColor(Utils.parseColor(textColor));
                }
            } else {
                view.setTextColor(Utils.parseColor(yiew.textColor));
            }


        }
        if (yiew.textSize != null) {

            if (yiew.textSize.startsWith("&")) {
                String a = Utils.getValueStringIfDataExist(yiew, yiew.textSize, null);
                if (a != null) {
                    int textSize = Integer.parseInt(a.trim());
                    view.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
                }
            } else {
                int textSize = Integer.parseInt(yiew.textSize.trim());

                view.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
            }


        }
        if (yiew.hint != null) {
            view.setHint(yiew.hint);
        }
        if (yiew.maxLine != 0) {
            view.setMaxLines(yiew.maxLine);
        }
        if (yiew.hintColor != null) {
            view.setHintTextColor(Utils.parseColor(yiew.hintColor));
        }
        if (yiew.lineSpace != null) {
            view.setLineSpacing(Utils.meature(yiew.lineSpace), 1);
        }

        if (yiew.gravity != null) {
            view.setGravity((Integer) Utils.getValueInt(Gravity.class, yiew.gravity.toUpperCase()));
        }


    }
}
