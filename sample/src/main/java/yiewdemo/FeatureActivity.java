package yiewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.arthas.xjsonview.IComponent;
import com.arthas.xjsonview.Main;
import com.arthas.xjsonview.YiewComponent;
import com.arthas.xjsonview.YiewConfig;
import com.arthas.xjsonview.YiewEngine;
import com.arthas.xjsonview.bean.XViewBody;
import com.arthas.xjsonview.bean.XView;
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
            public void render(XViewBody yiew) {

            }

            @Override
            public XViewBody createTemplate(Context context, ViewGroup parent, XViewBody yiew) {
                XViewBody template = XViewBody.create(XViewBody.RelativeLayout, XViewBody.MATCH, "48dp");


                template.background = "#ffFFEB3B";
                XViewBody tv = XViewBody.create(XViewBody.TextView, XViewBody.MATCH, XViewBody.MATCH);
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
            public View createComponentView(Context context, ViewGroup parent, XViewBody yiew) {
                XViewBody template = XViewBody.create(XViewBody.RelativeLayout, XViewBody.MATCH, "48dp");

                template.background = "#f6f6f6";
                //原属性覆盖


                XViewBody tv = XViewBody.create(XViewBody.TextView, XViewBody.MATCH, XViewBody.MATCH);
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
            public void render(XViewBody yiew) {

            }
        });


        load();
    }

    private void load() {
        OkGo.get("http://193.0.1.157:8080/feature.json")     // 请求方式和请求url

                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        XView yiew_1 = Util.gson.fromJson(s, XView.class);

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
