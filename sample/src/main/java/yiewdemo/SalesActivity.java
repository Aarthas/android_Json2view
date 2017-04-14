package yiewdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.apkfuns.logutils.LogUtils;
import com.arthas.xjsonview.XViewMain;
import com.arthas.xjsonview.bean.XView;
import com.arthas.xjsonview.bean.XViewBody;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Response;

public class SalesActivity extends AppCompatActivity {


    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;


       load();
    }

    private void load() {
        OkGo.get("http://193.0.1.157:9999/sales.json")     // 请求方式和请求url

                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        XView yiew_1 = Util.gson.fromJson(s, XView.class);

                        View aa = XViewMain.startProcess(context,  yiew_1 );

                        setContentView(aa);



                    }
                });
    }




    public void refresh() {

        load();

    }

    public void jumpToActivity(XViewBody yiew) {
        LogUtils.d("jumpToActivity");
        Map data = yiew.data;
        LogUtils.d(data);
        Object name = data.get("route");
        LogUtils.d(name);
        try {
            Class<?> aClass = Class.forName(name.toString());
            startActivity(new Intent(context,aClass));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
