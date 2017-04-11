package yiewdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arthas.yiew.Main;
import com.arthas.yiew.bean.YiewResp;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class JsonFromNetActivity extends AppCompatActivity {


    private JsonFromNetActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;




        load();

    }

    private void load() {
        OkGo.get("http://onzew89e9.bkt.clouddn.com/complaintDetail.json")     // 请求方式和请求url

                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        YiewResp yiew_1 = Util.gson.fromJson(s, YiewResp.class);

                        View contentView = Main.startProcess(context,  yiew_1 );
                        setContentView(contentView);



                    }
                });
    }




    public void refresh() {

        load();

    }

    public void gotoDataSource() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://onzew89e9.bkt.clouddn.com/complaintDetail.json")));
    }


}