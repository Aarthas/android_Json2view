package com.yi.generate;

import com.yi.bean.Yiew;

public class ServerCodeGenerateTest {


    public static void main(String[] args) throws Exception, IllegalAccessException {

        Yiew yiew_1 = new Yiew();
        yiew_1.view = "scrollView";
        yiew_1.width = "match";
        yiew_1.height = "match";
        yiew_1.background = "#f6f6f6";


        Yiew yiew_1_1 = new Yiew();
        yiew_1.addChild(yiew_1_1);
        yiew_1_1.view = "refreshBar";


        Yiew yiew_1_2 = new Yiew();
        yiew_1.addChild(yiew_1_2);
        yiew_1_2.name = "dv";
        yiew_1_2.view = "View";
        yiew_1_2.width = "match";
        yiew_1_2.height = "16";
        yiew_1_2.background = "#f6f6f6";


        Yiew yiew_1_3 = new Yiew();
        yiew_1.addChild(yiew_1_3);
        yiew_1_3.name = "head1";
        yiew_1_3.view = "RelativeLayout";
        yiew_1_3.width = "match";
        yiew_1_3.height = "48";
        yiew_1_3.paddingLeft = "16";
        yiew_1_3.paddingRight = "16";
        yiew_1_3.background = "#ffffff";


        Yiew yiew_1_3_1 = new Yiew();
        yiew_1_3.addChild(yiew_1_3_1);
        yiew_1_3_1.view = "ImageView";
        yiew_1_3_1.width = "16dp";
        yiew_1_3_1.height = "16dp";
        yiew_1_3_1.src = "http://onpxz5rdd.bkt.clouddn.com/ic_service_black.png";
        yiew_1_3_1.layout_centerVertical = true;


        Yiew yiew_1_3_2 = new Yiew();
        yiew_1_3.addChild(yiew_1_3_2);
        yiew_1_3_2.view = "TextView";
        yiew_1_3_2.marginLeft = "24";
        yiew_1_3_2.text = "舒服舒服";
        yiew_1_3_2.textSize = 14;
        yiew_1_3_2.textColor = "#444444";
        yiew_1_3_2.layout_centerVertical = true;


        Yiew yiew_1_3_3 = new Yiew();
        yiew_1_3.addChild(yiew_1_3_3);
        yiew_1_3_3.view = "TextView";
        yiew_1_3_3.width = "wrap";
        yiew_1_3_3.text = "close";
        yiew_1_3_3.textColor = "#444444";
        yiew_1_3_3.layout_alignParentRight = true;
        yiew_1_3_3.layout_centerVertical = true;


        Yiew yiew_1_4 = new Yiew();
        yiew_1.addChild(yiew_1_4);
        yiew_1_4.view = "line";


        Yiew yiew_1_5 = new Yiew();
        yiew_1.addChild(yiew_1_5);
        yiew_1_5.name = "pane";
        yiew_1_5.view = "RelativeLayout";
        yiew_1_5.width = "match";
        yiew_1_5.height = "wrap";
        yiew_1_5.paddingLeft = "16";
        yiew_1_5.paddingTop = "16";
        yiew_1_5.paddingRight = "16";
        yiew_1_5.paddingBottom = "16";
        yiew_1_5.background = "#ffffff";


        Yiew yiew_1_5_1 = new Yiew();
        yiew_1_5.addChild(yiew_1_5_1);
        yiew_1_5_1.name = "platform";
        yiew_1_5_1.view = "TextView";
        yiew_1_5_1.text = "购买平台:   wqrwer";
        yiew_1_5_1.textSize = 14;
        yiew_1_5_1.textColor = "#666666";


        Yiew yiew_1_5_2 = new Yiew();
        yiew_1_5.addChild(yiew_1_5_2);
        yiew_1_5_2.name = "content1";
        yiew_1_5_2.view = "TextView";
        yiew_1_5_2.id = 102;
        yiew_1_5_2.marginTop = "12";
        yiew_1_5_2.text = "阿萨德啊:   ";
        yiew_1_5_2.textSize = 14;
        yiew_1_5_2.textColor = "#666666";
        yiew_1_5_2.below = "@platform";


        Yiew yiew_1_5_3 = new Yiew();
        yiew_1_5.addChild(yiew_1_5_3);
        yiew_1_5_3.view = "TextView";
        yiew_1_5_3.text = "订单号订单号订单号订单号订单号订单号订单号";
        yiew_1_5_3.textSize = 14;
        yiew_1_5_3.textColor = "#666666";
        yiew_1_5_3.toRightOf = "@content1";
        yiew_1_5_3.alignTop = "@content1";


        Yiew yiew_1_6 = new Yiew();
        yiew_1.addChild(yiew_1_6);
        yiew_1_6.name = "imagePane";
        yiew_1_6.view = "horizonLayout";
        yiew_1_6.width = "match_parent";
        yiew_1_6.height = "wrap_content";
        yiew_1_6.paddingLeft = "12dp";
        yiew_1_6.paddingTop = "16";
        yiew_1_6.paddingRight = "12dp";
        yiew_1_6.paddingBottom = "10dp";
        yiew_1_6.background = "#ffffff";


        Yiew yiew_1_6_1 = new Yiew();
        yiew_1_6.addChild(yiew_1_6_1);
        yiew_1_6_1.view = "ImageView";
        yiew_1_6_1.width = "74dp";
        yiew_1_6_1.height = "74dp";
        yiew_1_6_1.margin = "5dp";
        yiew_1_6_1.src = "http://img.sanjiang.com/image/20173/1/image1488349927926.jpg";


        Yiew yiew_1_6_2 = new Yiew();
        yiew_1_6.addChild(yiew_1_6_2);
        yiew_1_6_2.view = "ImageView";
        yiew_1_6_2.width = "74dp";
        yiew_1_6_2.height = "74dp";
        yiew_1_6_2.margin = "5dp";
        yiew_1_6_2.src = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=232163874,2153671052&fm=58";


        Yiew yiew_1_6_3 = new Yiew();
        yiew_1_6.addChild(yiew_1_6_3);
        yiew_1_6_3.view = "ImageView";
        yiew_1_6_3.width = "74dp";
        yiew_1_6_3.height = "74dp";
        yiew_1_6_3.margin = "5dp";
        yiew_1_6_3.src = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=232163874,2153671052&fm=58";


        Yiew yiew_1_6_4 = new Yiew();
        yiew_1_6.addChild(yiew_1_6_4);
        yiew_1_6_4.view = "ImageView";
        yiew_1_6_4.width = "74dp";
        yiew_1_6_4.height = "74dp";
        yiew_1_6_4.margin = "5dp";
        yiew_1_6_4.src = "https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=232163874,2153671052&fm=58";


        Yiew yiew_1_7 = new Yiew();
        yiew_1.addChild(yiew_1_7);
        yiew_1_7.name = "dv";
        yiew_1_7.view = "View";
        yiew_1_7.width = "match";
        yiew_1_7.height = "16";
        yiew_1_7.background = "#f6f6f6";


        Yiew yiew_1_8 = new Yiew();
        yiew_1.addChild(yiew_1_8);
        yiew_1_8.name = "contact";
        yiew_1_8.view = "RelativeLayout";
        yiew_1_8.width = "match";
        yiew_1_8.height = "48";
        yiew_1_8.background = "#ffffff";


        Yiew yiew_1_8_1 = new Yiew();
        yiew_1_8.addChild(yiew_1_8_1);
        yiew_1_8_1.view = "TextView";
        yiew_1_8_1.marginLeft = "24";
        yiew_1_8_1.text = "舒服舒服";
        yiew_1_8_1.textSize = 14;
        yiew_1_8_1.textColor = "#666666";
        yiew_1_8_1.layout_centerVertical = true;


        Yiew yiew_1_8_2 = new Yiew();
        yiew_1_8.addChild(yiew_1_8_2);
        yiew_1_8_2.view = "TextView";
        yiew_1_8_2.width = "wrap";
        yiew_1_8_2.marginRight = "24";
        yiew_1_8_2.text = "aa";
        yiew_1_8_2.textColor = "#666666";
        yiew_1_8_2.layout_alignParentRight = true;
        yiew_1_8_2.layout_centerVertical = true;


        Yiew yiew_1_9 = new Yiew();
        yiew_1.addChild(yiew_1_9);
        yiew_1_9.view = "line";


        Yiew yiew_1_10 = new Yiew();
        yiew_1.addChild(yiew_1_10);
        yiew_1_10.name = "mobile";
        yiew_1_10.view = "RelativeLayout";
        yiew_1_10.width = "match";
        yiew_1_10.height = "48";
        yiew_1_10.background = "#ffffff";


        Yiew yiew_1_10_1 = new Yiew();
        yiew_1_10.addChild(yiew_1_10_1);
        yiew_1_10_1.view = "TextView";
        yiew_1_10_1.marginLeft = "24";
        yiew_1_10_1.text = "舒服舒服";
        yiew_1_10_1.textSize = 14;
        yiew_1_10_1.textColor = "#666666";
        yiew_1_10_1.layout_centerVertical = true;


        Yiew yiew_1_10_2 = new Yiew();
        yiew_1_10.addChild(yiew_1_10_2);
        yiew_1_10_2.view = "TextView";
        yiew_1_10_2.width = "wrap";
        yiew_1_10_2.marginRight = "24";
        yiew_1_10_2.text = "";
        yiew_1_10_2.textColor = "#666666";
        yiew_1_10_2.layout_alignParentRight = true;
        yiew_1_10_2.layout_centerVertical = true;


        Yiew yiew_1_11 = new Yiew();
        yiew_1.addChild(yiew_1_11);
        yiew_1_11.name = "attach";
        yiew_1_11.view = "View";
        yiew_1_11.width = "match";
        yiew_1_11.height = "16";
        yiew_1_11.background = "#f6f6f6";


        Yiew yiew_1_12 = new Yiew();
        yiew_1.addChild(yiew_1_12);
        yiew_1_12.view = "RelativeLayout";
        yiew_1_12.width = "match";
        yiew_1_12.height = "wrap";
        yiew_1_12.padding = "20";
        yiew_1_12.background = "#ffffff";


        Yiew yiew_1_12_1 = new Yiew();
        yiew_1_12.addChild(yiew_1_12_1);
        yiew_1_12_1.view = "TextView";
        yiew_1_12_1.text = "对于给您造成的不便我们深表抱歉。您的本次投诉已处理完成，如对处理结果不满意您可以再次投诉，谢谢！";
        yiew_1_12_1.textSize = 14;
        yiew_1_12_1.textColor = "#666666";
        yiew_1_12_1.lineSpace = "8";
        yiew_1_12_1.layout_centerVertical = true;


    }


}
