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

    public XViewBody getTemplate() {
        return template;
    }

    @Override
    public View createComponentView(Context context, ViewGroup parent, XViewBody yiew) {
        XViewBody template = createTemplate(context, parent, yiew);
        XViewBody clone = template.deepClone();

//       if (yiew == null)
//       {
//           yiew = clone;
//       }else
//       {
//           yiew.setComponentTemplate(clone);
//       }
        yiew.setComponentTemplate(clone);

        View content = XViewEngine.createView(context, parent, yiew);
        return content;
    }

    @Override
    public void render(XViewBody yiew) {

        recu(yiew);
    }

    private void recu(XViewBody yiew) {

        XViewComponent component = ComponentManager.findComponent(yiew.view,yiew.getYiewStore());

        component.render(yiew);
        if (yiew.child!= null && yiew.child.size()>0){
            for (XViewBody xViewBody : yiew.child) {
                recu(xViewBody);
            }
        }

    }

    public XViewBody createTemplate(Context context, ViewGroup parent, XViewBody yiew){
        return template;
    }
}