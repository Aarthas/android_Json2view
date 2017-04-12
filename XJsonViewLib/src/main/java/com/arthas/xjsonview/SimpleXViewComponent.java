package com.arthas.xjsonview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.xjsonview.bean.XViewBody;

public  class SimpleXViewComponent implements XViewComponent {


    private XViewBody template;
    public SimpleXViewComponent() {

    }
    public SimpleXViewComponent(XViewBody template) {
        this.template=template;
    }

    @Override
    public View createComponentView(Context context, ViewGroup parent, XViewBody yiew) {
        XViewBody template = createTemplate(context, parent, yiew);
        XViewBody clone = template.deepClone();
        yiew.setComponentTemplate(clone);

        View content = XViewEngine.createView(context, parent, yiew);
        return content;
    }

    @Override
    public void render(XViewBody yiew) {

    }

    public XViewBody createTemplate(Context context, ViewGroup parent, XViewBody yiew){
        return template;
    }
}