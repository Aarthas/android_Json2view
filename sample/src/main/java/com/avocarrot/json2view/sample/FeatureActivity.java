package com.avocarrot.json2view.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.arthas.yiew.IProcess;
import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewConfig;
import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.YiewStore;
import com.arthas.yiew.bean.Yiew;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class FeatureActivity extends AppCompatActivity {


    private FeatureActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;


        YiewConfig.Component("group", new IProcess() {
            @Override
            public View createView(Context context, ViewGroup parent, Yiew yiew, YiewStore yiewStore) {
                Yiew head = Yiew.create(Yiew.RelativeLayout, Yiew.MATCH, "48dp");
                //原属性覆盖
                head.background = "#ffFFEB3B";
                head.click = "refresh";
                Utils.copy(head, yiew);

                Yiew tv = Yiew.create(Yiew.TextView, Yiew.MATCH, Yiew.MATCH);
                head.addChild(tv);

                //自定义原属性覆盖
                tv.text = yiew.text != null ? yiew.text : "component";
                tv.textColor = yiew.textColor != null ? yiew.textColor : "#333333";
                tv.marginLeft = "20dp";
                tv.gravity = "CENTER_VERTICAL";


                View yiew1 = YiewEngine.createView(context, parent, head, null);
                return yiew1;

            }
        });


        load();
    }

    private void load() {
        OkGo.get("http://193.0.1.157:8080/feature.json")     // 请求方式和请求url

                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        Yiew yiew_1 = Util.gson.fromJson(s, Yiew.class);

                        View contentView = YiewEngine.createView(context, null, yiew_1, null);

                        setContentView(contentView);


                    }
                });
    }


    public void refresh() {

        load();

    }

    public void showToast() {

        LogUtils.d("showToast");
        Toast.makeText(context, "showToast", 1).show();

    }


}
