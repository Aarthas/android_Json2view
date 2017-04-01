package com.arthas.yiew.encode;

/**
 * Created by zhangyn on 17/3/31.
 */

public class YiVerticalLayout extends Yiew {
    {
        view = "verticalLayout";
    }


//    public String layout_gravity;
//    public int weight;
//    public String gravity;

    public String getLayout_gravity() {
        return layout_gravity;
    }

    public void setLayout_gravity(String layout_gravity) {
        this.layout_gravity = layout_gravity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }
}
