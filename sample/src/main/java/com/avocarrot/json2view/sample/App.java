package com.avocarrot.json2view.sample;

import android.app.Application;
import android.widget.ImageView;

import com.arthas.yiew.ImageProcess;
import com.arthas.yiew.YiewConfig;
import com.arthas.yiew.decode.YiewBean;
import com.arthas.yiew.decode.Yiew;
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

                //可以全局统一设置缓存模式,默认是不使用缓存,可以不传,具体其他模式看 github 介绍 https://github.com/jeasonlzy/
                .setCacheMode(CacheMode.NO_CACHE);

        ImageProcess imageAdapter = new ImageProcess() {

            @Override
            public void display(ImageView view, String src, YiewBean yiew) {
                Glide.with(view.getContext()).
                        load(yiew.src).
                        crossFade(400)
                        .into(view);
            }
        };
        YiewConfig.setImageProcess(imageAdapter);

        Yiew yiew = new Yiew();
        yiew.view = "View";
        yiew.width = Yiew.MATCH;
        yiew.height = "1px";

        yiew.background = "#dddddd";

        YiewConfig.Component("line", yiew);


    }
}
