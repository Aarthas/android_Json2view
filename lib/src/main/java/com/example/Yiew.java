package com.example;

import java.util.ArrayList;

/**
 * Created by zhangyn on 17/3/31.
 */

public class Yiew extends YiewBean {

    public static final String verticalLayout = "verticalLayout";
    public static final String horizonLayout = "horizonLayout";
    public static final String TextView = "TextView";
    public static final String ImageView = "ImageView";
    public static final String View = "View";
    public static final String ScrollView = "ScrollView";
    public static final String scrollView = "scrollView";
    public static final String RelativeLayout = "RelativeLayout";
    public static final String FrameLayout = "FrameLayout";

    {
        view = "View";
    }

    public static final String MATCH = "match";
    public static final String WRAP = "wrap";

    public void addChild(Yiew yiew) {
        if (child == null)
        {
            child = new ArrayList<>();

        }
        child.add(yiew);
    }


//    public String width;
//    public String height;
//    public String unit;
//    public int id;
//    public String click;
//    public String visibility;
//    public String background;
//    public String tag;
//    public ArrayList<PropertyBean> propertys;
//    public ArrayList<YiewBean> child;
//
//    public int padding;
//    public int paddingLeft;
//    public int paddingTop;
//    public int paddingRight;
//    public int paddingBottom;
//    public int margin;
//    public int marginLeft;
//    public int marginTop;
//    public int marginRight;
//    public int marginBottom;


    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }


    public void setWidth(String width) {
        this.width = width;
    }


    public void setHeight(String height) {
        this.height = height;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public ArrayList<PropertyBean> getPropertys() {
        return propertys;
    }

    public void setPropertys(ArrayList<PropertyBean> propertys) {
        this.propertys = propertys;
    }

    public ArrayList<YiewBean> getChild() {
        return child;
    }

    public void setChild(ArrayList<YiewBean> child) {
        this.child = child;
    }

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public void setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
    }

    public int getPaddingTop() {
        return paddingTop;
    }

    public void setPaddingTop(int paddingTop) {
        this.paddingTop = paddingTop;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public void setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
    }

    public int getPaddingBottom() {
        return paddingBottom;
    }

    public void setPaddingBottom(int paddingBottom) {
        this.paddingBottom = paddingBottom;
    }

    public int getMargin() {
        return margin;
    }

    public void setMargin(int margin) {
        this.margin = margin;
    }

    public int getMarginLeft() {
        return marginLeft;
    }

    public void setMarginLeft(int marginLeft) {
        this.marginLeft = marginLeft;
    }

    public int getMarginTop() {
        return marginTop;
    }

    public void setMarginTop(int marginTop) {
        this.marginTop = marginTop;
    }

    public int getMarginRight() {
        return marginRight;
    }

    public void setMarginRight(int marginRight) {
        this.marginRight = marginRight;
    }

    public int getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(int marginBottom) {
        this.marginBottom = marginBottom;
    }
}
