package com.example;

import java.util.HashMap;

/**
 * Created by zhangyn on 17/4/1.
 */

public class YiViewCodeHelp {
    public static HashMap toMap(YiewBean obj) {
        HashMap hashMap = new HashMap();
        if (obj.view != null) {
            hashMap.put("view", obj.view);
        }
        if (obj.width != null) {
            hashMap.put("width", obj.width);
        }
        if (obj.height != null) {
            hashMap.put("height", obj.height);
        }

        if (obj.id != 0) {
            hashMap.put("id", obj.id);
        }
        if (obj.click != null) {
            hashMap.put("click", obj.click);
        }
        if (obj.visibility != null) {
            hashMap.put("visibility", obj.visibility);
        }
        if (obj.tag != null) {
            hashMap.put("tag", obj.tag);
        }
        if (obj.propertys != null) {
            hashMap.put("propertys", obj.propertys);
        }
        if (obj.child != null) {
            hashMap.put("child", obj.child);
        }
        if (obj.padding != 0) {
            hashMap.put("padding", obj.padding);
        }
        if (obj.paddingLeft != 0) {
            hashMap.put("paddingLeft", obj.paddingLeft);
        }
        if (obj.paddingTop != 0) {
            hashMap.put("paddingTop", obj.paddingTop);
        }
        if (obj.paddingRight != 0) {
            hashMap.put("paddingRight", obj.paddingRight);
        }
        if (obj.paddingBottom != 0) {
            hashMap.put("paddingBottom", obj.paddingBottom);
        }
        if (obj.margin != 0) {
            hashMap.put("margin", obj.margin);
        }
        if (obj.marginLeft != 0) {
            hashMap.put("marginLeft", obj.marginLeft);
        }
        if (obj.marginTop != 0) {
            hashMap.put("marginTop", obj.marginTop);
        }
        if (obj.marginRight != 0) {
            hashMap.put("marginRight", obj.marginRight);
        }
        if (obj.marginBottom != 0) {
            hashMap.put("marginBottom", obj.marginBottom);
        }
        if (obj.background != null) {
            hashMap.put("background", obj.background);
        }
        if (obj.gravity != null) {
            hashMap.put("gravity", obj.gravity);
        }
        if (obj.layout_gravity != null) {
            hashMap.put("layout_gravity", obj.layout_gravity);
        }
        if (obj.weight != 0) {
            hashMap.put("weight", obj.weight);
        }
        if (obj.text != null) {
            hashMap.put("text", obj.text);
        }
        if (obj.textSize != 0) {
            hashMap.put("textSize", obj.textSize);
        }
        if (obj.textColor != null) {
            hashMap.put("textColor", obj.textColor);
        }
        if (obj.hint != null) {
            hashMap.put("hint", obj.hint);
        }
        if (obj.maxLine != 0) {
            hashMap.put("maxLine", obj.maxLine);
        }
        if (obj.hintColor != null) {
            hashMap.put("hintColor", obj.hintColor);
        }
        if (obj.layout_alignParentTop) {
            hashMap.put("layout_alignParentTop", obj.layout_alignParentTop);
        }
        if (obj.layout_alignParentBottom) {
            hashMap.put("layout_alignParentBottom", obj.layout_alignParentBottom);
        }
        if (obj.layout_centerInParent) {
            hashMap.put("layout_centerInParent", obj.layout_centerInParent);
        }
        return hashMap;
    }
}
