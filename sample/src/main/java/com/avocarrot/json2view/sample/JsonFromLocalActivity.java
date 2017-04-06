package com.avocarrot.json2view.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.bean.Yiew;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class JsonFromLocalActivity extends AppCompatActivity {


    private JsonFromLocalActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;



        load();
    }

    private void load() {
        OkGo.get("http://193.0.1.157:8080/complaintDetail.json")     // 请求方式和请求url

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
//    public void gotoDataSource() {
//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://onzew89e9.bkt.clouddn.com/complaintDetail.json")));
//    }


}
