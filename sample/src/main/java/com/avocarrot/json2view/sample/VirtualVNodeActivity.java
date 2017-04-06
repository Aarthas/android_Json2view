package com.avocarrot.json2view.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.bean.Yiew;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class VirtualVNodeActivity extends AppCompatActivity {


    private VirtualVNodeActivity context;
    private Yiew yiew_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;


        load();
    }

    private void load() {
        OkGo.get("http://193.0.1.157:8080/virtual.json")     // 请求方式和请求url

                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        yiew_1 = Util.gson.fromJson(s, Yiew.class);

                        View contentView = YiewEngine.createView(context, null, yiew_1, null);

                        setContentView(contentView);


                    }
                });
    }


    public void refresh() {

        load();

    }

    public void change() {

        Yiew contactPane = yiew_1.getYiewStore().getYiewByName("contactPane");
        contactPane.getView().setBackgroundColor(Color.parseColor("#ff4CAF50"));

        //更新虚拟节点
        Yiew contact = yiew_1.getYiewStore().getYiewByName("contact");
        contact.text = "arthas";
        contact.textColor="#fff";
        contact.invalid();


        //通过yiew得到View
        Yiew phone = yiew_1.getYiewStore().getYiewByName("phone");
        TextView phoneview = (TextView) phone.getView();
        phoneview.setText("12933249");
        phoneview.setTextColor(Color.parseColor("#ffffff"));

    }


}
