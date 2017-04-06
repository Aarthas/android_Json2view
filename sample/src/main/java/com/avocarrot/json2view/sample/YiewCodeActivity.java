package com.avocarrot.json2view.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arthas.yiew.YiewEngine;
import com.arthas.yiew.bean.Yiew;

public class YiewCodeActivity extends AppCompatActivity {


    private YiewCodeActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;

        Yiew root =Yiew.create(Yiew.RelativeLayout,Yiew.MATCH,Yiew.MATCH) ;
        root.background="#f7f7f7";
        Yiew head =Yiew.create(Yiew.RelativeLayout,Yiew.MATCH,"48dp") ;
        root.addChild(head);
        Yiew title =Yiew.create(Yiew.TextView,Yiew.MATCH,Yiew.MATCH) ;
        head.addChild(title);
        title.layout_centerInParent=true;
        title.text="刷新";
        title.gravity="center";
        title.click="refresh";
        title.textColor="#333333";
        title.background="#ffffff";

        View rootView = YiewEngine.createView(context, null, root,null);

        setContentView(rootView);



    }

    private void load() {
        Yiew yiew_1 = new Yiew();
        yiew_1.view = "verticalLayout";
        yiew_1.width = "match";
        yiew_1.height = "match";
        yiew_1.background = "#f6f6f6";


        Yiew yiew_1_1 = new Yiew();
        yiew_1.addChild(yiew_1_1);
        yiew_1_1.view = "refreshBar";


        Yiew yiew_1_2 = new Yiew();
        yiew_1.addChild(yiew_1_2);
        yiew_1_2.view = "scrollView";
        yiew_1_2.width = "match";
        yiew_1_2.height = "match";


        Yiew yiew_1_2_1 = new Yiew();
        yiew_1_2.addChild(yiew_1_2_1);
        yiew_1_2_1.view = "verticalLayout";
        yiew_1_2_1.width = "match";
        yiew_1_2_1.height = "wrap";
        yiew_1_2_1.background = "#f6f6f6";
        yiew_1_2_1.gravity = "center";


        Yiew yiew_1_2_1_1 = new Yiew();
        yiew_1_2_1.addChild(yiew_1_2_1_1);
        yiew_1_2_1_1.view = "TextView";
        yiew_1_2_1_1.padding = "16";
        yiew_1_2_1_1.text = "页面的简单使用";
        yiew_1_2_1_1.textSize = 16;
        yiew_1_2_1_1.textColor = "#444444";


        Yiew yiew_1_2_1_2 = new Yiew();
        yiew_1_2_1.addChild(yiew_1_2_1_2);
        yiew_1_2_1_2.view = "TextView";
        yiew_1_2_1_2.click = "gotoDataSource";
        yiew_1_2_1_2.padding = "16";
        yiew_1_2_1_2.gravity = "center";
        yiew_1_2_1_2.text = "从assets/complaintDetail.json加载数据";
        yiew_1_2_1_2.textSize = 14;
        yiew_1_2_1_2.textColor = "#444444";


        Yiew yiew_1_2_2 = new Yiew();
        yiew_1_2.addChild(yiew_1_2_2);
        yiew_1_2_2.name = "head1";
        yiew_1_2_2.view = "RelativeLayout";
        yiew_1_2_2.width = "match";
        yiew_1_2_2.height = "48";
        yiew_1_2_2.paddingLeft = "16";
        yiew_1_2_2.paddingRight = "16";
        yiew_1_2_2.background = "#ffffff";


        Yiew yiew_1_2_2_1 = new Yiew();
        yiew_1_2_2.addChild(yiew_1_2_2_1);
        yiew_1_2_2_1.view = "ImageView";
        yiew_1_2_2_1.width = "16dp";
        yiew_1_2_2_1.height = "16dp";
        yiew_1_2_2_1.src = "http://onpxz5rdd.bkt.clouddn.com/ic_service_black.png";
        yiew_1_2_2_1.layout_centerVertical = true;


        Yiew yiew_1_2_2_2 = new Yiew();
        yiew_1_2_2.addChild(yiew_1_2_2_2);
        yiew_1_2_2_2.view = "TextView";
        yiew_1_2_2_2.marginLeft = "24";
        yiew_1_2_2_2.text = "接受部门";
        yiew_1_2_2_2.textSize = 14;
        yiew_1_2_2_2.textColor = "#444444";
        yiew_1_2_2_2.layout_centerVertical = true;


        Yiew yiew_1_2_2_3 = new Yiew();
        yiew_1_2_2.addChild(yiew_1_2_2_3);
        yiew_1_2_2_3.view = "TextView";
        yiew_1_2_2_3.width = "wrap";
        yiew_1_2_2_3.text = "状态";
        yiew_1_2_2_3.textColor = "#444444";
        yiew_1_2_2_3.layout_alignParentRight = true;
        yiew_1_2_2_3.layout_centerVertical = true;


        Yiew yiew_1_2_3 = new Yiew();
        yiew_1_2.addChild(yiew_1_2_3);
        yiew_1_2_3.view = "line";


        Yiew yiew_1_2_4 = new Yiew();
        yiew_1_2.addChild(yiew_1_2_4);
        yiew_1_2_4.name = "pane";
        yiew_1_2_4.view = "RelativeLayout";
        yiew_1_2_4.width = "match";
        yiew_1_2_4.height = "wrap";
        yiew_1_2_4.paddingLeft = "16";
        yiew_1_2_4.paddingTop = "16";
        yiew_1_2_4.paddingRight = "16";
        yiew_1_2_4.paddingBottom = "16";
        yiew_1_2_4.background = "#ffffff";


        Yiew yiew_1_2_4_1 = new Yiew();
        yiew_1_2_4.addChild(yiew_1_2_4_1);
        yiew_1_2_4_1.name = "platform";
        yiew_1_2_4_1.view = "TextView";
        yiew_1_2_4_1.text = "平台:   wqrwer";
        yiew_1_2_4_1.textSize = 14;
        yiew_1_2_4_1.textColor = "#666666";


        Yiew yiew_1_2_4_2 = new Yiew();
        yiew_1_2_4.addChild(yiew_1_2_4_2);
        yiew_1_2_4_2.name = "content1";
        yiew_1_2_4_2.view = "TextView";
        yiew_1_2_4_2.id = 102;
        yiew_1_2_4_2.marginTop = "12";
        yiew_1_2_4_2.text = "内容:   ";
        yiew_1_2_4_2.textSize = 14;
        yiew_1_2_4_2.textColor = "#666666";
        yiew_1_2_4_2.below = "@platform";


        Yiew yiew_1_2_4_3 = new Yiew();
        yiew_1_2_4.addChild(yiew_1_2_4_3);
        yiew_1_2_4_3.view = "TextView";
        yiew_1_2_4_3.text = "对于给您造成的不便我们深表抱歉。您的本次投诉已处理完成，如对处理结果不满意您可以再次投诉，谢谢！";
        yiew_1_2_4_3.textSize = 14;
        yiew_1_2_4_3.textColor = "#666666";
        yiew_1_2_4_3.lineSpace = "18dp";
        yiew_1_2_4_3.toRightOf = "@content1";
        yiew_1_2_4_3.alignTop = "@content1";


        Yiew yiew_1_2_5 = new Yiew();
        yiew_1_2.addChild(yiew_1_2_5);
        yiew_1_2_5.name = "imagePane";
        yiew_1_2_5.view = "horizonLayout";
        yiew_1_2_5.width = "match_parent";
        yiew_1_2_5.height = "wrap_content";
        yiew_1_2_5.paddingLeft = "12dp";
        yiew_1_2_5.paddingTop = "16";
        yiew_1_2_5.paddingRight = "12dp";
        yiew_1_2_5.paddingBottom = "10dp";
        yiew_1_2_5.background = "#ffffff";


        Yiew yiew_1_2_5_1 = new Yiew();
        yiew_1_2_5.addChild(yiew_1_2_5_1);
        yiew_1_2_5_1.view = "ImageView";
        yiew_1_2_5_1.width = "74dp";
        yiew_1_2_5_1.height = "74dp";
        yiew_1_2_5_1.margin = "5dp";
        yiew_1_2_5_1.src = "http://img.sanjiang.com/image/20173/1/image1488349927926.jpg";


        Yiew yiew_1_2_5_2 = new Yiew();
        yiew_1_2_5.addChild(yiew_1_2_5_2);
        yiew_1_2_5_2.view = "ImageView";
        yiew_1_2_5_2.width = "74dp";
        yiew_1_2_5_2.height = "74dp";
        yiew_1_2_5_2.margin = "5dp";
        yiew_1_2_5_2.src = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=232163874,2153671052&fm=58";


        Yiew yiew_1_2_5_3 = new Yiew();
        yiew_1_2_5.addChild(yiew_1_2_5_3);
        yiew_1_2_5_3.view = "ImageView";
        yiew_1_2_5_3.width = "74dp";
        yiew_1_2_5_3.height = "74dp";
        yiew_1_2_5_3.margin = "5dp";
        yiew_1_2_5_3.src = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=232163874,2153671052&fm=58";


        Yiew yiew_1_2_5_4 = new Yiew();
        yiew_1_2_5.addChild(yiew_1_2_5_4);
        yiew_1_2_5_4.view = "ImageView";
        yiew_1_2_5_4.width = "74dp";
        yiew_1_2_5_4.height = "74dp";
        yiew_1_2_5_4.margin = "5dp";
        yiew_1_2_5_4.src = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=232163874,2153671052&fm=58";


        Yiew yiew_1_2_6 = new Yiew();
        yiew_1_2.addChild(yiew_1_2_6);
        yiew_1_2_6.name = "dv";
        yiew_1_2_6.view = "View";
        yiew_1_2_6.width = "match";
        yiew_1_2_6.height = "16";
        yiew_1_2_6.background = "#f6f6f6";


        Yiew yiew_1_2_7 = new Yiew();
        yiew_1_2.addChild(yiew_1_2_7);
        yiew_1_2_7.name = "contact";
        yiew_1_2_7.view = "RelativeLayout";
        yiew_1_2_7.width = "match";
        yiew_1_2_7.height = "48";
        yiew_1_2_7.background = "#ffffff";


        Yiew yiew_1_2_7_1 = new Yiew();
        yiew_1_2_7.addChild(yiew_1_2_7_1);
        yiew_1_2_7_1.view = "TextView";
        yiew_1_2_7_1.marginLeft = "24";
        yiew_1_2_7_1.text = "联系人";
        yiew_1_2_7_1.textSize = 14;
        yiew_1_2_7_1.textColor = "#666666";
        yiew_1_2_7_1.layout_centerVertical = true;


        Yiew yiew_1_2_7_2 = new Yiew();
        yiew_1_2_7.addChild(yiew_1_2_7_2);
        yiew_1_2_7_2.view = "TextView";
        yiew_1_2_7_2.width = "wrap";
        yiew_1_2_7_2.marginRight = "24";
        yiew_1_2_7_2.text = "my god";
        yiew_1_2_7_2.textColor = "#666666";
        yiew_1_2_7_2.layout_alignParentRight = true;
        yiew_1_2_7_2.layout_centerVertical = true;


        Yiew yiew_1_2_8 = new Yiew();
        yiew_1_2.addChild(yiew_1_2_8);
        yiew_1_2_8.view = "line";


        Yiew yiew_1_2_9 = new Yiew();
        yiew_1_2.addChild(yiew_1_2_9);
        yiew_1_2_9.name = "mobile";
        yiew_1_2_9.view = "RelativeLayout";
        yiew_1_2_9.width = "match";
        yiew_1_2_9.height = "48";
        yiew_1_2_9.background = "#ffffff";


        Yiew yiew_1_2_9_1 = new Yiew();
        yiew_1_2_9.addChild(yiew_1_2_9_1);
        yiew_1_2_9_1.view = "TextView";
        yiew_1_2_9_1.marginLeft = "24";
        yiew_1_2_9_1.text = "手机";
        yiew_1_2_9_1.textSize = 14;
        yiew_1_2_9_1.textColor = "#666666";
        yiew_1_2_9_1.layout_centerVertical = true;


        Yiew yiew_1_2_9_2 = new Yiew();
        yiew_1_2_9.addChild(yiew_1_2_9_2);
        yiew_1_2_9_2.view = "TextView";
        yiew_1_2_9_2.width = "wrap";
        yiew_1_2_9_2.marginRight = "24";
        yiew_1_2_9_2.text = "132943...";
        yiew_1_2_9_2.textColor = "#666666";
        yiew_1_2_9_2.layout_alignParentRight = true;
        yiew_1_2_9_2.layout_centerVertical = true;


        Yiew yiew_1_2_10 = new Yiew();
        yiew_1_2.addChild(yiew_1_2_10);
        yiew_1_2_10.view = "View";
        yiew_1_2_10.width = "match";
        yiew_1_2_10.height = "16";
        yiew_1_2_10.background = "#f6f6f6";


        Yiew yiew_1_2_11 = new Yiew();
        yiew_1_2.addChild(yiew_1_2_11);
        yiew_1_2_11.view = "verticalLayout";
        yiew_1_2_11.width = "match";
        yiew_1_2_11.height = "wrap";
        yiew_1_2_11.padding = "20";
        yiew_1_2_11.background = "#ffffff";


        Yiew yiew_1_2_11_1 = new Yiew();
        yiew_1_2_11.addChild(yiew_1_2_11_1);
        yiew_1_2_11_1.name = "attach1";
        yiew_1_2_11_1.view = "TextView";
        yiew_1_2_11_1.text = "对于给您造成的不便我们深表抱歉。您的本次投诉已处理完成，如对处理结果不满意您可以再次投诉，谢谢！";
        yiew_1_2_11_1.textSize = 14;
        yiew_1_2_11_1.textColor = "#666666";
        yiew_1_2_11_1.lineSpace = "18dp";


        Yiew yiew_1_2_11_2 = new Yiew();
        yiew_1_2_11.addChild(yiew_1_2_11_2);
        yiew_1_2_11_2.view = "View";
        yiew_1_2_11_2.width = "match";
        yiew_1_2_11_2.height = "36";


        View rootView = YiewEngine.createView(context, null, yiew_1,null);

        setContentView(rootView);

    }




    public void refresh() {

        load();

    }




}
