package com.avocarrot.json2view.sample;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.apkfuns.logutils.LogUtils;
import com.arthas.yiew.IComponent;
import com.arthas.yiew.ImageAdapter;
import com.arthas.yiew.YiewConfig;
import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.bean.YiewBean;
import com.bumptech.glide.Glide;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;

import java.util.logging.Level;

/**
 * Created by zhangyn on 17/4/1.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.init(this);
        OkGo.getInstance()

                // 打开该调试开关,打印级别INFO,并不是异常,是为了显眼,不需要就不要加入该行
                // 最后的true表示是否打印okgo的内部异常，一般打开方便调试错误
                .debug("OkGo", Level.INFO, true)

                //如果使用默认的 60秒,以下三行也不需要传
                .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)  //全局的连接超时时间
                .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)     //全局的读取超时时间
                .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS)    //全局的写入超时时间

                .setCacheMode(CacheMode.NO_CACHE);

        LogUtils.getLogConfig()
                .configAllowLog(true)
                .configTagPrefix("MyAppName")
                .configShowBorders(true)
                .configFormatTag("%d{HH:mm:ss:SSS} %t %c{-5}");

        ImageAdapter imageAdapter = new ImageAdapter() {

            @Override
            public void display(ImageView view, String src, YiewBean yiew) {
                Glide.with(view.getContext()).
                        load(yiew.src).
                        crossFade(400)
                        .into(view);
            }
        };

        YiewConfig.setImageAdapter(imageAdapter);


        YiewConfig.addComponent("refreshBar", new IComponent() {

            @Override
            public View createComponentView(Context context, ViewGroup parent, Yiew yiew ) {


                Yiew template =Yiew.create(Yiew.RelativeLayout,Yiew.MATCH,"48dp") ;

                Yiew TextView =Yiew.create(Yiew.TextView,Yiew.MATCH,Yiew.MATCH) ;
                template.addChild(TextView);
                TextView.layout_centerInParent=true;
                TextView.text="刷新";
                TextView.gravity="center";
                TextView.onClick ="refresh";
                TextView.textColor="#333333";
                TextView.background="#ffffff";



                View yiew1 = YiewEngine.createView(context, parent, template);
                return yiew1;
            }

            @Override
            public void render(Yiew yiew) {

            }
        });



        YiewConfig.addComponent("line", new IComponent() {

            @Override
            public View createComponentView(Context context, ViewGroup parent, Yiew yiew ) {

                Yiew dv =Yiew.create(Yiew.View,Yiew.MATCH,"1px") ;
                dv.background = "#dddddd";
                View yiew1 = YiewEngine.createView(context, parent, dv);
                return yiew1;
            }

            @Override
            public void render(Yiew yiew) {

            }
        });



    }
}
