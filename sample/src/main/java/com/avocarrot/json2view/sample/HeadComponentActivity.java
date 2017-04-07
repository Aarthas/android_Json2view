package com.avocarrot.json2view.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.bean.Yiew;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class HeadComponentActivity extends AppCompatActivity {


    private HeadComponentActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;




        load();
    }

    private void load() {
        OkGo.get("http://193.0.1.157:8080/headcomponent.json")     // 请求方式和请求url

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
