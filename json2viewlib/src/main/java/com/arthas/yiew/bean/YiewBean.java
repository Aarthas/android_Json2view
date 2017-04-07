package com.arthas.yiew.bean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zhangyn on 17/3/29.
 */


public class YiewBean {
    public String name;

    // view
    public String view;
    public String width;
    public String height;

    public int id;
    public String click;
    public String visibility;

    public String tag;
    public ArrayList<PropertyBean> propertys;
    public ArrayList<Yiew> child;
    public HashMap<String,String> data;

    public String padding;
    public String paddingLeft;
    public String paddingTop;
    public String paddingRight;
    public String paddingBottom;
    public String margin;
    public String marginLeft;
    public String marginTop;
    public String marginRight;
    public String marginBottom;

    public String background;
    public String gravity;

    // linearlayout
    public String layout_gravity;
    public int weight;


    // textview
    public String text;

    public String textSize;
    public String textColor;

    public String hint;
    public int maxLine;
    public String hintColor;

    public String lineSpace;

    // imageview
    public String scaleType;
    public String src;


    //relativelayout
    public boolean layout_alignParentRight;
    public boolean layout_alignParentLeft;
    public boolean layout_alignParentTop;
    public boolean layout_alignParentBottom;

    public boolean layout_centerInParent;
    public boolean layout_centerHorizontal;
    public boolean layout_centerVertical;

    public int layout_toLeftOf;
    public int layout_toRightOf;
    public int layout_above;
    public int layout_below;

    public int layout_alignLeft;
    public int layout_alignRight;
    public int layout_alignTop;
    public int layout_alignBottom;





    public int layout_alignBaseline;


    //advance
    public String alignBaseline;
    public String below;
    public String alignBottom;
    public String toLeftOf;
    public String toRightOf;
    public String above;
    public String alignLeft;
    public String alignRight;
    public String alignTop;


//    @Override
//    public String toString() {
//        return "YiewBean{" +
//                "view='" + view + '\'' +
//                ", width='" + width + '\'' +
//                ", height='" + height + '\'' +
//                ", id=" + id +
//                ", click='" + click + '\'' +
//                ", visibility='" + visibility + '\'' +
//                ", tag='" + tag + '\'' +
//                ", propertys=" + propertys +
//                ", child=" + child +
//                ", padding=" + padding +
//                ", paddingLeft=" + paddingLeft +
//                ", paddingTop=" + paddingTop +
//                ", paddingRight=" + paddingRight +
//                ", paddingBottom=" + paddingBottom +
//                ", margin=" + margin +
//                ", marginLeft=" + marginLeft +
//                ", marginTop=" + marginTop +
//                ", marginRight=" + marginRight +
//                ", marginBottom=" + marginBottom +
//                ", background='" + background + '\'' +
//                ", gravity='" + gravity + '\'' +
//                ", layout_gravity='" + layout_gravity + '\'' +
//                ", weight=" + weight +
//                ", text='" + text + '\'' +
//                ", textSize=" + textSize +
//                ", textColor='" + textColor + '\'' +
//                ", hint='" + hint + '\'' +
//                ", maxLine=" + maxLine +
//                ", hintColor='" + hintColor + '\'' +
//                ", lineSpace=" + lineSpace +
//                ", scaleType='" + scaleType + '\'' +
//                ", src='" + src + '\'' +
//                ", layout_alignParentRight=" + layout_alignParentRight +
//                ", layout_alignParentLeft=" + layout_alignParentLeft +
//                ", layout_alignParentTop=" + layout_alignParentTop +
//                ", layout_alignParentBottom=" + layout_alignParentBottom +
//                ", layout_centerInParent=" + layout_centerInParent +
//                ", layout_centerHorizontal=" + layout_centerHorizontal +
//                ", layout_centerVertical=" + layout_centerVertical +
//                ", layout_toLeftOf=" + layout_toLeftOf +
//                ", layout_toRightOf=" + layout_toRightOf +
//                ", layout_above=" + layout_above +
//                ", layout_below=" + layout_below +
//                ", layout_alignLeft=" + layout_alignLeft +
//                ", layout_alignRight=" + layout_alignRight +
//                ", layout_alignTop=" + layout_alignTop +
//                ", layout_alignBottom=" + layout_alignBottom +
//                ", layout_alignBaseline=" + layout_alignBaseline +
//                '}';
//    }
}

