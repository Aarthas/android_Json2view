package com.arthas.yiew.process;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewStore;
import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class TextViewProcess {
    public static View createView(Context context, ViewGroup parent, Yiew yiew, YiewStore yiewStore) {
        TextView view = new TextView(context);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);

        ViewProcess.applyView(view, yiew, yiewStore);
        LayoutProcess.applyaLayout(view, params, yiew, yiewStore);

        applyTextView(view, yiew);


        return view;
    }

    public static View refresh(Yiew yiew) {
        TextView view = (TextView) yiew.getYiewStore().getView(yiew.name);
        ViewGroup.LayoutParams params = view.getLayoutParams();

        ViewProcess.applyView(view, yiew, yiew.getYiewStore());
        LayoutProcess.applyaLayout(view, params, yiew, yiew.getYiewStore());

        applyTextView(view, yiew);


        return view;
    }

    public static void applyTextView(TextView view, Yiew yiew) {

        if (yiew.parentNode != null) {
            if (yiew.textSize == 0)
                yiew.textSize = yiew.parentNode.textSize;
            if (yiew.textColor == null)
                yiew.textColor = yiew.parentNode.textColor;
            if (yiew.maxLine == 0)
                yiew.maxLine = yiew.parentNode.maxLine;
            if (yiew.hintColor == null)
                yiew.hintColor = yiew.parentNode.hintColor;
            if (yiew.lineSpace == null)
                yiew.lineSpace = yiew.parentNode.lineSpace;

//            if (yiew.text == null)
//                yiew.text = yiew.parentNode.text;
//
//            if (yiew.hint == null)
//                yiew.hint = yiew.parentNode.hint;

        }


        if (yiew.text != null)
            if (yiew.text.startsWith("&")) {
                String keyname = yiew.text.substring(1);
                Object data = yiew.getData(keyname, yiew.text);
                yiew.text = data.toString();
            }

        view.setText(yiew.text);
        if (yiew.textColor != null)
            view.setTextColor(Utils.parseColor(yiew.textColor));
        if (yiew.textSize != 0)
            view.setTextSize(TypedValue.COMPLEX_UNIT_SP, yiew.textSize);
        if (yiew.hint != null)
            view.setHint(yiew.hint);
        if (yiew.maxLine != 0)
            view.setMaxLines(yiew.maxLine);
        if (yiew.hintColor != null)
            view.setHintTextColor(Utils.parseColor(yiew.hintColor));
        if (yiew.lineSpace != null)
            view.setLineSpacing(Utils.meature(yiew.lineSpace), 1);

        if (yiew.gravity != null)
            view.setGravity((Integer) Utils.getValueInt(Gravity.class, yiew.gravity.toUpperCase()));


    }
}
