package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.bean.XViewBody;

public  class YiewComponent implements   IComponent{


    private XViewBody template;
    public YiewComponent() {

    }
    public YiewComponent(XViewBody template) {
        this.template=template;
    }

    @Override
    public View createComponentView(Context context, ViewGroup parent, XViewBody yiew) {
        XViewBody template = createTemplate(context, parent, yiew);
        XViewBody clone = template.deepClone();
        yiew.setComponentTemplate(clone);

        View content = YiewEngine.createView(context, parent, yiew);
        return content;
    }

    @Override
    public void render(XViewBody yiew) {

    }

    public XViewBody createTemplate(Context context, ViewGroup parent, XViewBody yiew){
        return template;
    }
}