package com.arthas.yiew.encode;

/**
 * Created by zhangyn on 17/3/31.
 */

public class YiImageView  extends Yiew {

    {
        view = "ImageView";
    }


//    public String scaleType;
//    public String src;

    public String getScaleType() {
        return scaleType;
    }

    public void setScaleType(String scaleType) {
        this.scaleType = scaleType;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
