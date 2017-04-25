


**根据json数据创建view**

>#####  简介

    json2view is a simple library that can convert a compatible JSON file to an Android view so you can load dynamically the view in your Android app without the need to update the APK.
    根据https://github.com/Avocarrot/json2view 自己手动修改成自己所需要的数据结构

>##### 使用场景

  1. 使用场景1：使用json创建本地视图，

  2. 场景2：根据服务器返回的json数据创建视图。

  3. 配合andfix等热修复，可以达到不需要更新版本而更新app的目的。
  因为json2view更新视图，andfix更新逻辑。



>##### 优点

    1. 使用场景1：使用json创建本地视图，

    2. 场景2：根据服务器返回的json数据创建视图。

    3. 配合andfix等热修复，可以达到不需要更新版本而更新app的目的。
     因为json2view更新视图，andfix更新逻辑。

>##### 原理

     1. 根据当前branch更新代码
     2. 查找port的端口号占用的进程pid
     3. clean chche，compile code，kill pid ，restart service

>##### 测试

    运行稳定。

>##### 后续

    1. 如果有10个spring boot 服务，每个spring boot 工程下都放置一个makefile.py,可以批量一键部署系统。
    2. 增加自动输入密码模块，用expect模块自动输入密码，不需要手输，一键启动。但需要每台服务器安装Pexpect模块。

>##### 附： 因为现在linux大多数内置python 2.0+，部署不需要安装额外软件，所以python的版本也是2.0+。




**，**







>you can create view use json data like this

```markdown
{
  "view": "scrollView",
  "width": "match",
  "height": "match",
  "background": "#f6f6f6",
  "child": [
    {
      "view": "RelativeLayout",
      "width": "match",
      "height": "wrap",
      "background": "#ffffff",
      "property": {
      },
      "child": [
        {
          "id": 1001,
          "view": "TextView",
          "width": "wrap",
          "text": "bb",
          "textColor": "#333333",
          "height": "wrap",
          "margin": "20",
          "click": "myClick",
          "background": "#cccccc",
          "padding": "20"

        },
        {
          "id": 1002,
          "view": "TextView",
          "width": "100",
          "text": "cc",
          "textColor": "#666666",
          "height": "wrap",

          "click": "myClick2",
          "background": "#eeeeee",

          "layout_alignParentRight":true
        },
        {
          "id": 1003,
          "view": "TextView",
          "width": "wrap",
          "text": "below",
          "textColor": "#666666",
          "height": "wrap",


          "background": "#aaaaaa",

          "layout_below": 1002,
          "layout_alignLeft": 1002

        }

      ]
    },
    {
      "view": "View",
      "width": "match",
      "unit": "px",
      "height": "1",
      "background": "#e1e1e1"
    },
    {
      "view": "horizonLayout",
      "width": "match",
      "height": "wrap",
      "child": [

      ]
    },
    {
      "view": "TextView",
      "width": "wrap",
      "text": "asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasda",
      "textColor": "#333333",
      "height": "wrap",
      "margin": "20",
      "background": "#cccccc",
      "padding": "20"
    }
  ]
}

```






