package com.arthas.yiew.process.diy;

import android.content.Context;
import android.view.ViewGroup;

import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewComponent;
import com.arthas.yiew.bean.Yiew;

/**
 * Created by zhangyn on 17/4/5.
 */

public class ScrollComponent2 extends YiewComponent {


    @Override
    public Yiew createTemplate(Context context, ViewGroup parent, Yiew yiew) {
        Yiew template = Yiew.create(Yiew.ScrollView, Yiew.MATCH, Yiew.MATCH);

        Yiew verticalLayout = Yiew.create(Yiew.verticalLayout, Yiew.MATCH, Yiew.MATCH);


        Utils.merge(yiew, template);
        verticalLayout.child = yiew.child;

        yiew.child = null;
        yiew.addChild(verticalLayout);
        return yiew;
    }
}
