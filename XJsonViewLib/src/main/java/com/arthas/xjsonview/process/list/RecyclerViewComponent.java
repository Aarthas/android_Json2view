package com.arthas.xjsonview.process.list;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.arthas.xjsonview.SimpleXViewComponent;
import com.arthas.xjsonview.Utils;
import com.arthas.xjsonview.XViewComponent;
import com.arthas.xjsonview.bean.XViewBody;
import com.arthas.xjsonview.process.base.LayoutProcess;
import com.arthas.xjsonview.process.base.ViewProcess;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by zhangyn on 17/4/5.
 */
public class RecyclerViewComponent implements XViewComponent {
    public View createComponentView(Context context, ViewGroup parent, XViewBody recyclerX) {

        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(context);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);


        ViewGroup.LayoutParams params = Utils.createLayoutParams(parent, recyclerX);
        recyclerView.setLayoutParams(params);



        ViewProcess.applyView(recyclerView, recyclerX);
        LayoutProcess.applyaLayout(recyclerView, params, recyclerX);
        Map<String, Object> data = recyclerX.data;
        ArrayList<Map> list = (ArrayList<Map>) data.get("list");


//        String itemLayout = recycler.itemLayout;
        SimpleXViewComponent component = (SimpleXViewComponent) recyclerX.getYiewStore().findComponent(recyclerX.itemLayout);
        XViewBody template = component.getTemplate();

        ArrayList<XViewBody> childs = new ArrayList<>();

        for (Map map : list) {
//            XViewBody child = new XViewBody();
            XViewBody child = template.deepClone();
            child.setComponentTemplate(child);
            child.setYiewStore(recyclerX.getYiewStore());
            child.data = map;

            childs.add(child);
        }



        RecyclerAdapter adapter = new RecyclerAdapter<XViewBody>(context,recyclerX, childs) {
            @Override
            protected void convert(AdapterHelper helper, XViewBody hotword, int position) {
//                helper.setText(R.id.item, hotword.keyword);


            }
        };

        recyclerView.setAdapter(adapter);


        return recyclerView;

    }


    public void render(XViewBody yiew) {

    }
}
