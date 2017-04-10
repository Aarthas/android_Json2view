package com.arthas.yiew.bean;

import com.arthas.yiew.IComponent;
import com.arthas.yiew.Utils;
import com.arthas.yiew.YiewConfig;
import com.arthas.yiew.YiewStore;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by zhangyn on 17/3/31.
 */

public class Yiew extends YiewBean implements Serializable {

    public static final String verticalLayout = "verticalLayout";
    public static final String horizonLayout = "horizonLayout";

    public static final String ScrollView = "ScrollView";
    public static final String scrollView = "scrollView";

    public static final String RelativeLayout = "RelativeLayout";
    public static final String FrameLayout = "FrameLayout";


    public static final String TextView = "TextView";
    public static final String ImageView = "ImageView";
    public static final String View = "View";


    @Override
    public String toString() {
        return "view=" + view;
    }

    public static final String MATCH = "match";
    public static final String WRAP = "wrap";


    public String getData(String key, String defaultValue) {
        if (data == null) {
            return defaultValue;
        } else {
            String s = data.get(key);
            if (s == null) {
                return defaultValue;
            }
            return s;
        }
    }

    public int getDataInt(String key, int defaultValue) {
        if (data == null) {
            return 0;
        } else {
            String s = data.get(key);
            if (s == null) {
                return defaultValue;
            } else {
                try {
                    int i = Integer.parseInt(s);
                    return i;
                } catch (Exception e) {
                    return defaultValue;
                }

            }

        }
    }

    public HashMap<String, String> data;
    public transient Yiew parentNode;
    private transient Yiew rootComponet;
    private transient YiewStore yiewStore;
    public transient android.view.View currentView;


    public void setRootComponet(Yiew rootComponet) {
        this.rootComponet = rootComponet;
    }

    public Yiew getRootComponet() {
        return rootComponet;
    }

    public void setYiewStore(YiewStore yiewStore) {
        this.yiewStore = yiewStore;
    }

    public YiewStore getYiewStore() {
        return yiewStore;
    }


    public void addChild(Yiew yiew) {
        if (child == null) {
            child = new ArrayList<>();

        }
        child.add(yiew);
    }


    public void removeAllYiew() {

        this.child.clear();

    }




    public <T extends android.view.View> T getView() {
        return (T) currentView;
    }

    public void invalid() {

        IComponent component = YiewConfig.findComponent(view);
        if (component != null) {
            component.render(this);
        }


    }
//

    public static Yiew create(String type, String width, String height) {
        Yiew yiew = new Yiew();
        yiew.view = type;
        yiew.width = width;
        yiew.height = height;
        return yiew;
    }


    public String getBackground() {
        if (background.startsWith("&")) {
            String a = Utils.getValueStringIfDataExist(this, background, null);
            return a;
        } else if (background != null) {
            return background;
        }
        return null;
    }


    public Yiew deepClone() {


        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(this);
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            Object o = oi.readObject();
            oi.close();
            bi.close();
            return (Yiew) o;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public void setComponentTemplate(Yiew template) {

        setRootComponet(this);
        Yiew to = this;
        Yiew from = template;

        to.view = from.view;
        to.child = from.child;

        if (to.name != null) {
            to.name = from.name;
        }
        if (to.id == 0) {
            to.id = from.id;
        }
        if (to.width == null) {
            to.width = from.width;
        }
        if (to.height == null) {
            to.height = from.height;
        }

        if (to.click == null) {
            to.click = from.click;
        }
        if (to.visibility == null) {
            to.visibility = from.visibility;
        }
        if (to.tag == null) {
            to.tag = from.tag;
        }
        if (to.padding == null) {
            to.padding = from.padding;
        }
        if (to.paddingLeft == null) {
            to.paddingLeft = from.paddingLeft;
        }
        if (to.paddingTop == null) {
            to.paddingTop = from.paddingTop;
        }
        if (to.paddingRight == null) {
            to.paddingRight = from.paddingRight;
        }
        if (to.paddingBottom == null) {
            to.paddingBottom = from.paddingBottom;
        }
        if (to.margin == null) {
            to.margin = from.margin;
        }
        if (to.marginLeft == null) {
            to.marginLeft = from.marginLeft;
        }
        if (to.marginTop == null) {
            to.marginTop = from.marginTop;
        }
        if (to.marginRight == null) {
            to.marginRight = from.marginRight;
        }
        if (to.marginBottom == null) {
            to.marginBottom = from.marginBottom;
        }
        if (to.background == null) {
            to.background = from.background;
        }
        if (to.gravity == null) {
            to.gravity = from.gravity;
        }
        if (to.layout_gravity == null) {
            to.layout_gravity = from.layout_gravity;
        }
        if (to.weight == 0) {
            to.weight = from.weight;
        }
        if (to.text == null) {
            to.text = from.text;
        }
        if (to.textSize == null) {
            to.textSize = from.textSize;
        }
        if (to.textColor == null) {
            to.textColor = from.textColor;
        }
        if (to.hint == null) {
            to.hint = from.hint;
        }
        if (to.maxLine == 0) {
            to.maxLine = from.maxLine;
        }
        if (to.hintColor == null) {
            to.hintColor = from.hintColor;
        }
        if (to.lineSpace == null) {
            to.lineSpace = from.lineSpace;
        }
        if (to.scaleType == null) {
            to.scaleType = from.scaleType;
        }
        if (to.src == null) {
            to.src = from.src;
        }
        if (!to.layout_alignParentRight) {
            to.layout_alignParentRight = from.layout_alignParentRight;
        }
        if (!to.layout_alignParentLeft) {
            to.layout_alignParentLeft = from.layout_alignParentLeft;
        }
        if (!to.layout_alignParentTop) {
            to.layout_alignParentTop = from.layout_alignParentTop;
        }
        if (!to.layout_alignParentBottom) {
            to.layout_alignParentBottom = from.layout_alignParentBottom;
        }
        if (!to.layout_centerInParent) {
            to.layout_centerInParent = from.layout_centerInParent;
        }
        if (!to.layout_centerHorizontal) {
            to.layout_centerHorizontal = from.layout_centerHorizontal;
        }
        if (!to.layout_centerVertical) {
            to.layout_centerVertical = from.layout_centerVertical;
        }

        if (to.alignBaseline == null) {
            to.alignBaseline = from.alignBaseline;
        }
        if (to.below == null) {
            to.below = from.below;
        }
        if (to.alignBottom == null) {
            to.alignBottom = from.alignBottom;
        }
        if (to.toLeftOf == null) {
            to.toLeftOf = from.toLeftOf;
        }
        if (to.toRightOf == null) {
            to.toRightOf = from.toRightOf;
        }
        if (to.above == null) {
            to.above = from.above;
        }
        if (to.alignLeft == null) {
            to.alignLeft = from.alignLeft;
        }
        if (to.alignRight == null) {
            to.alignRight = from.alignRight;
        }
        if (to.alignTop == null) {
            to.alignTop = from.alignTop;
        }

    }
}
