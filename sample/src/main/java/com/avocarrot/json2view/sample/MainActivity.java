package com.avocarrot.json2view.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.decode.Yiew;
import com.google.android.flexbox.FlexboxLayout;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    final Gson gson = new Gson();
    private MainActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;


//        YiewBean pane = gson.fromJson(json, YiewBean.class);
//
//        View createView = YiewEngine.createView(this, null, pane);
//
//        createView.setLayoutParams(new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));
//
//        setContentView(createView);

        setContentView(R.layout.flexlayout);
        FlexboxLayout flexboxLayout = null;

//        load();
    }

    private void load() {
        OkGo.get("http://193.0.1.157:8080/complaintDetail.json")     // 请求方式和请求url

                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        // s 即为所需要的结果
//                        Log.d("syb", s);
                        Yiew yiew_1 = gson.fromJson(s, Yiew.class);

                        Log.d("syb","get yiewbean");



//                        View createmyiew = YiewEngine.createView(context, null, yiew_1);

                        View aa = YiewEngine.createView(context, null, yiew_1, null);


                        setContentView(aa);

                        Yiew platform1 = yiew_1.getYiewStore().getYiewByName("platform");
                        platform1.text = "werwetwert";
                        platform1.textColor="#111111";
                        platform1.invalid();
//                        platform.setText("sdcsd");



                    }
                });
    }

    @Override
    public void onClick(View v) {
//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.avocarrot.com/")));
    }


    public void refresh() {

        load();

    }

    public void myClick2() {
        Log.d("syb", "myClick2");
    }
}
