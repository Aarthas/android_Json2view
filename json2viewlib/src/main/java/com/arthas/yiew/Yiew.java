package com.arthas.yiew;

import java.util.List;

/**
 * Created by zhangyn on 17/3/29.
 */


public class Yiew {


    public String view;
    public String width;
    public String height;
    public String unit;

    public List<PropertyBean> propertys;
    public List<Yiew> child;

    public int padding;
    public int paddingLeft;
    public int paddingTop;
    public int paddingRight;
    public int paddingBottom;
    public int margin;
    public int marginLeft;
    public int marginTop;
    public int marginRight;
    public int marginBottom;
    public int weight;

    public String layout_gravity;
    public String tag;

    public String gravity;
    public String text;

    public int textSize;
    public String textColor;
    public String background;
    public String hint;
    public int maxLine;
    public String hintColor;
    public String scaleType;
    public String src;
    public int id;
    public String click;
    public String visibility;

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



    public int getWidth() {
        if (width == null || width.equals("")) {
            return -2;
        }
        if (width.equals("match")) {
            return -1;
        } else if (width.equals("wrap")) {
            return -2;
        } else {
            if ("px".equals(unit)) {
                return Integer.valueOf(width);
            } else {
                return Utils.dip2px(Float.valueOf(width));
            }
        }
    }

    public int getHeight() {
        if (height == null || height.equals("")) {
            return -2;
        }
        if (height.equals("match")) {
            return -1;
        } else if (height.equals("wrap")) {
            return -2;
        } else {
            if ("px".equals(unit)) {
                return Integer.valueOf(height);
            } else {
                return Utils.dip2px(Float.valueOf(height));
            }


        }
    }


    @Override
    public String toString() {
        return "Yiew{" +
                "view='" + view + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", unit='" + unit + '\'' +
                ", propertys=" + propertys +
                ", child=" + child +
                ", padding=" + padding +
                ", paddingLeft=" + paddingLeft +
                ", paddingTop=" + paddingTop +
                ", paddingRight=" + paddingRight +
                ", paddingBottom=" + paddingBottom +
                ", margin=" + margin +
                ", marginLeft=" + marginLeft +
                ", marginTop=" + marginTop +
                ", marginRight=" + marginRight +
                ", marginBottom=" + marginBottom +
                ", weight=" + weight +
                ", layout_gravity='" + layout_gravity + '\'' +
                ", tag='" + tag + '\'' +
                ", gravity='" + gravity + '\'' +
                ", text='" + text + '\'' +
                ", textSize=" + textSize +
                ", textColor='" + textColor + '\'' +
                ", background='" + background + '\'' +
                ", hint='" + hint + '\'' +
                ", maxLine=" + maxLine +
                ", hintColor='" + hintColor + '\'' +
                ", scaleType='" + scaleType + '\'' +
                ", src='" + src + '\'' +
                ", id=" + id +
                ", click='" + click + '\'' +
                ", layout_alignParentRight=" + layout_alignParentRight +
                ", layout_alignParentLeft=" + layout_alignParentLeft +
                ", layout_alignParentTop=" + layout_alignParentTop +
                ", layout_alignParentBottom=" + layout_alignParentBottom +
                ", layout_centerInParent=" + layout_centerInParent +
                ", layout_centerHorizontal=" + layout_centerHorizontal +
                ", layout_centerVertical=" + layout_centerVertical +
                ", layout_toLeftOf=" + layout_toLeftOf +
                ", layout_toRightOf=" + layout_toRightOf +
                ", layout_above=" + layout_above +
                ", layout_below=" + layout_below +
                ", layout_alignLeft=" + layout_alignLeft +
                ", layout_alignRight=" + layout_alignRight +
                ", layout_alignTop=" + layout_alignTop +
                ", layout_alignBottom=" + layout_alignBottom +
                ", layout_alignBaseline=" + layout_alignBaseline +
                '}';
    }
}

