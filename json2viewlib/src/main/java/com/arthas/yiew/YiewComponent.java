package com.arthas.yiew;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.yiew.bean.Yiew;

public  class YiewComponent implements   IComponent{


    private  Yiew template;
    public YiewComponent() {

    }
    public YiewComponent(Yiew template) {
        this.template=template;
    }

    @Override
    public View createComponentView(Context context, ViewGroup parent, Yiew yiew) {
        Yiew template = createTemplate(context, parent, yiew);
        Yiew clone = template.deepClone();
        yiew.setComponentTemplate(clone);

        View content = YiewEngine.createView(context, parent, yiew);
        return content;
    }

    @Override
    public void render(Yiew yiew) {

    }

    public  Yiew createTemplate(Context context, ViewGroup parent, Yiew yiew){
        return template;
    }
}