package com.example;

public class MyClass5 {


    public static void main(String[] args) throws Exception, IllegalAccessException {


        Yiew yiew_1 = new Yiew();
        yiew_1.view = "verticalLayout";
        yiew_1.width = "match";
        yiew_1.height = "match";
        yiew_1.background = "#f6f6f6";
        yiew_1.weight = 1;
        yiew_1.layout_centerInParent = true;


        Yiew yiew_1_1 = new Yiew();
        yiew_1.addChild(yiew_1_1);
        yiew_1_1.view = "RelativeLayout";
        yiew_1_1.width = "match";
        yiew_1_1.height = "48";
        yiew_1_1.background = "#ffffff";


        Yiew yiew_1_1_1 = new Yiew();
        yiew_1_1.addChild(yiew_1_1_1);
        yiew_1_1_1.view = "TextView";
        yiew_1_1_1.width = "wrap";
        yiew_1_1_1.height = "wrap";
        yiew_1_1_1.id = 1001;
        yiew_1_1_1.text = "客户投诉";
        yiew_1_1_1.textColor = "#999999";
        yiew_1_1_1.layout_centerInParent = true;


        Yiew yiew_1_1_2 = new Yiew();
        yiew_1_1.addChild(yiew_1_1_2);
        yiew_1_1_2.view = "TextView";
        yiew_1_1_2.width = "100";
        yiew_1_1_2.height = "48";
        yiew_1_1_2.id = 1002;
        yiew_1_1_2.click = "refresh";
        yiew_1_1_2.background = "#999999";
        yiew_1_1_2.gravity = "center";
        yiew_1_1_2.text = "刷续";
        yiew_1_1_2.textColor = "#666666";


        Yiew yiew_1_2 = new Yiew();
        yiew_1.addChild(yiew_1_2);
        yiew_1_2.view = "TextView";
        yiew_1_2.width = "match";
        yiew_1_2.height = "48";
        yiew_1_2.gravity = "CENTER";
        yiew_1_2.text = "aa";
        yiew_1_2.textSize = 18;
        yiew_1_2.textColor = "#999999";


        Yiew yiew_1_3 = new Yiew();
        yiew_1.addChild(yiew_1_3);
        yiew_1_3.view = "View";
        yiew_1_3.width = "match";
        yiew_1_3.height = "1";

        yiew_1_3.background = "#e1e1e1";


        Yiew yiew_1_4 = new Yiew();
        yiew_1.addChild(yiew_1_4);
        yiew_1_4.view = "horizonLayout";
        yiew_1_4.width = "match";
        yiew_1_4.height = "wrap";


        Yiew yiew_1_4_1 = new Yiew();
        yiew_1_4.addChild(yiew_1_4_1);
        yiew_1_4_1.view = "TextView";
        yiew_1_4_1.width = "wrap";
        yiew_1_4_1.height = "wrap";
        yiew_1_4_1.id = 1001;
        yiew_1_4_1.click = "myClick";
        yiew_1_4_1.padding = 20;
        yiew_1_4_1.margin = 20;
        yiew_1_4_1.background = "#cccccc";
        yiew_1_4_1.text = "bb";
        yiew_1_4_1.textColor = "#333333";


        Yiew yiew_1_4_2 = new Yiew();
        yiew_1_4.addChild(yiew_1_4_2);
        yiew_1_4_2.view = "TextView";
        yiew_1_4_2.width = "wrap";
        yiew_1_4_2.height = "wrap";
        yiew_1_4_2.id = 1002;
        yiew_1_4_2.click = "myClick2";
        yiew_1_4_2.padding = 20;
        yiew_1_4_2.margin = 20;
        yiew_1_4_2.background = "#eeeeee";
        yiew_1_4_2.text = "cc";
        yiew_1_4_2.textColor = "#666666";




    }


}
