package yiewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.arthas.yiew.IComponent;
import com.arthas.yiew.Main;
import com.arthas.yiew.YiewComponent;
import com.arthas.yiew.YiewConfig;
import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.bean.Yiew;
import com.arthas.yiew.bean.YiewResp;
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


        YiewConfig.addComponent("localComponent", new YiewComponent() {
            @Override
            public void render(Yiew yiew) {

            }

            @Override
            public Yiew createTemplate(Context context, ViewGroup parent, Yiew yiew) {
                Yiew template = Yiew.create(Yiew.RelativeLayout, Yiew.MATCH, "48dp");


                template.background = "#ffFFEB3B";
                Yiew tv = Yiew.create(Yiew.TextView, Yiew.MATCH, Yiew.MATCH);
                template.addChild(tv);

                //子控件赋值


                tv.text = yiew.getData("text", "这是一个组件");
                tv.textColor = yiew.getData("textColor", "#444444");

                tv.marginLeft = "20dp";
                tv.gravity = yiew.getData("gravity", "CENTER_VERTICAL");

                return template;


            }
        });
        YiewConfig.addComponent("localComponent2", new IComponent() {
            @Override
            public View createComponentView(Context context, ViewGroup parent, Yiew yiew) {
                Yiew template = Yiew.create(Yiew.RelativeLayout, Yiew.MATCH, "48dp");

                template.background = "#f6f6f6";
                //原属性覆盖


                Yiew tv = Yiew.create(Yiew.TextView, Yiew.MATCH, Yiew.MATCH);
                template.addChild(tv);

                //子控件赋值


                tv.text = yiew.getData("text", "这是一个组件");
                tv.textColor = yiew.getData("textColor", "#444444");

                tv.marginLeft = "20dp";
                tv.gravity = yiew.getData("gravity", "CENTER");


                yiew.setComponentTemplate(template);
                View yiew1 = YiewEngine.createView(context, parent, yiew);
                return yiew1;

            }

            @Override
            public void render(Yiew yiew) {

            }
        });


        load();
    }

    private void load() {
        OkGo.get("http://193.0.1.157:8080/feature.json")     // 请求方式和请求url

                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        YiewResp yiew_1 = Util.gson.fromJson(s, YiewResp.class);

                        View contentView = Main.startProcess(context, yiew_1);
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

    public void showToast2() {

        LogUtils.d("showToast");
        Toast.makeText(context, "showToast2", 1).show();

    }
}
