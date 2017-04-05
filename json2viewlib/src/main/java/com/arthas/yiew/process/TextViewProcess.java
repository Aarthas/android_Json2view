package com.arthas.yiew.process;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arthas.yiew.Utils;
import com.arthas.yiew.decode.YiewBean;
import com.arthas.yiew.process.base.LayoutProcess;
import com.arthas.yiew.process.base.ViewProcess;

/**
 * Created by zhangyn on 17/4/5.
 */

public class TextViewProcess {
    public static View createView(Context context, ViewGroup parent, YiewBean yiew) {
        TextView view = new TextView(context);
        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, yiew);
        view.setLayoutParams(params);


        LayoutProcess.applyaLayout(view, params, yiew);
        ViewProcess.applyView(view, yiew);
        applyTextView(view, yiew);


        return view;
    }

    public static void applyTextView(TextView view, YiewBean yiew) {
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
        if (yiew.lineSpace != null)
            view.setLineSpacing(Utils.meature(yiew.lineSpace),1);

        if (yiew.gravity != null)
            view.setGravity((Integer) Utils.getValueInt(Gravity.class, yiew.gravity.toUpperCase()));


    }
}
