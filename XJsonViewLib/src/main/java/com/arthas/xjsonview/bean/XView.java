package com.arthas.xjsonview.bean;

/**
 * Created by zhangyn on 17/4/7.
 */

public class XView {

    /**
     * head : {"process":"yiewEngine","component":[{"name":"group2","template":{"view":"RelativeLayout","width":"match","height":"48","background":"#ffffff","child":[{"name":"contact","view":"TextView","text":"联系人","textColor":"#666666","marginLeft":"24","textSize":"14","layout_centerVertical":true}]}}]}
     * template : {"view":"verticalLayout","width":"match","height":"match","background":"#f6f6f6","child":[{"view":"refreshBar"},{"view":"scrollView","width":"match","height":"match","child":[{"view":"group"},{"view":"group","background":"#fb9236","text":"自定义属性覆盖文字","textColor":"#fff"},{"view":"View","width":"match","height":"30dp"},{"view":"group","background":"#f6f6f6","text":"component事件"},{"view":"group","background":"#56b0f5","text":"事件,点击调用activity的showToast方法","textColor":"#fff","onClick":"showToast"},{"view":"group","background":"#f6f6f6","text":"普通事件"},{"name":"simpleEvent","onClick":"showToast","view":"RelativeLayout","width":"match","height":"48","background":"#d9Ff5858","paddingLeft":"16","paddingRight":"16","child":[{"view":"ImageView","src":"http://onpxz5rdd.bkt.clouddn.com/ic_service_black.png","width":"16dp","height":"16dp","layout_centerVertical":true},{"view":"TextView","text":"点击此处","textColor":"#444444","marginLeft":"24","textSize":"14","layout_centerVertical":true},{"view":"TextView","width":"wrap","text":">","textColor":"#444444","layout_alignParentRight":"true","layout_centerVertical":true}]},{"view":"group","background":"#f6f6f6","text":"application里，全局定义了一些component组件，查看代码便知"},{"view":"group","background":"#f6f6f6","text":"图片适配"},{"name":"imagePane","view":"horizonLayout","width":"match_parent","height":"wrap_content","background":"#ffffff","paddingLeft":"12dp","paddingRight":"12dp","paddingTop":"16","paddingBottom":"10dp","child":[{"view":"ImageView","src":"http://img.sanjiang.com/image/20173/1/image1488349927926.jpg","width":"74dp","height":"74dp","margin":"5dp"},{"view":"ImageView","src":"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=232163874,2153671052&fm=58","width":"74dp","height":"74dp","margin":"5dp"},{"view":"ImageView","src":"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=232163874,2153671052&fm=58","width":"74dp","height":"74dp","margin":"5dp"},{"view":"ImageView","src":"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=232163874,2153671052&fm=58","width":"74dp","height":"74dp","margin":"5dp"}]}]}]}
     */

    public XViewHead head;
    public XViewBody template;


    public String scope;
}
