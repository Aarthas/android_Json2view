package com.avocarrot.json2view.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.apkfuns.logutils.LogUtils;
import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.bean.Yiew;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {


    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;

//        LogUtils.d("aaaa");
//        String s = Util.readFile(context, "main.json");
//        LogUtils.d("aaaa"+s);
//        Yiew yiew = gson.fromJson(s, Yiew.class);
//
//
//
//        Log.d("syb","get yiewbean");
//
//
//        View aa = YiewEngine.createView(context, null, yiew, null);


//        setContentView(aa);

        OkGo.get("http://193.0.1.157:8080/main.json")     // 请求方式和请求url

                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        Yiew yiew_1 = Util.gson.fromJson(s, Yiew.class);

                        View aa = YiewEngine.createView(context, null, yiew_1, null);

                        setContentView(aa);



                    }
                });
    }

    private void load() {
        OkGo.get("http://193.0.1.157:8080/main.json")     // 请求方式和请求url

                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        Yiew yiew_1 = Util.gson.fromJson(s, Yiew.class);

                        View aa = YiewEngine.createView(context, null, yiew_1, null);

                        setContentView(aa);



                    }
                });
    }




    public void refresh() {

        load();

    }

    public void jumpToActivity(Yiew yiew) {
        HashMap data = yiew.getData();
        LogUtils.d(data);
        Object name = data.get("name");
        LogUtils.d(name);
        try {
            Class<?> aClass = Class.forName(name.toString());
            startActivity(new Intent(context,aClass));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
