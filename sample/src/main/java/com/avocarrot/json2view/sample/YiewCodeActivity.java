package com.avocarrot.json2view.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.bean.Yiew;

public class YiewCodeActivity extends AppCompatActivity {


    private YiewCodeActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;

        Yiew root =Yiew.create(Yiew.RelativeLayout,Yiew.MATCH,Yiew.MATCH) ;
        root.background="#f7f7f7";
        Yiew head =Yiew.create(Yiew.RelativeLayout,Yiew.MATCH,"48dp") ;
        root.addChild(head);
        Yiew title =Yiew.create(Yiew.TextView,Yiew.MATCH,Yiew.MATCH) ;
        head.addChild(title);
        title.layout_centerInParent=true;
        title.text="刷新";
        title.gravity="center";
        title.click="refresh";
        title.textColor="#333333";
        title.background="#ffffff";

        View rootView = YiewEngine.createView(context, null, root,null);

        setContentView(rootView);

        load();

    }

    private void load() {

    }




    public void refresh() {

        load();

    }




}
