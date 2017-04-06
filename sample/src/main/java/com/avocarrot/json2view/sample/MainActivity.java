package com.avocarrot.json2view.sample;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.bean.Yiew;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

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

    public void goJsonFromLocalActivity() {
        startActivity(new Intent(context,JsonFromLocalActivity.class));
    }

    public void goJsonFromNetActivity() {
        startActivity(new Intent(context,JsonFromNetActivity.class));
    }


    public void goYiewCodeActivity() {
        startActivity(new Intent(context,YiewCodeActivity.class));
    }

    public void goFeatureActivity() {
        startActivity(new Intent(context,FeatureActivity.class));
    }

}
