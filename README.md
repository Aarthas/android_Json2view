


**根据json数据创建view**

>#####  简介

    json2view is a simple library that can convert a compatible JSON file to an Android view
    so you can load dynamically the view in your Android app without the need to update the APK.
    根据https://github.com/Avocarrot/json2view 自己手动修改成自己所需要的数据结构

>##### 使用场景

      1. 使用json创建本地视图，json文件放置在assets，可以使用子文件夹，分门别类管理。
      2. 根据服务器返回的json view数据动态创建视图，若需要界面的更改，一定程度上更改服务器代码即可更改界面。
	  3. 搭建静态服务器，请求json文件渲染本地视图，可以达到更改json，一秒钟更新界面，达到敏捷开发的目的。
	  4. 搭配使用热更新框架，如andfix，json2view来改变视图，andfix更改逻辑，可以动态改变整个activity的大多数需求。
      5. 后期若加上flexboxlayout的布局，Android和ios 各有一个flexboxlayout的布局库，ios再实现一套json2view的引擎，
      可以达到写一次json文件，就可以产生ios和Android两个原生界面，且布局相差不大，减少开发工作量。
      缺点：
      1. 不能更改逻辑，只有视图功能。
      2. json文件没有提示功能。
      3. 暂不支持list。
      4. 目前支持的功能比较简单，用作简单的展示界面或简单逻辑的界面，不能应用于逻辑复杂的界面。

>##### 使用

>    1.创建json文件

    {
      "head": {
        "process": "AndroidLayout"
      },
      "template": {
        "view": "verticalLayout",
        "width": "match",
        "height": "match",
        "background": "#f6f6f6",
        "child": [
          {
            "view": "TextView",
            "text": "页面的简单使用",
            "width": "120dp",
            "height": "30dp",
            "textColor": "#444444",
            "padding": "16dp",
            "textSize": "16"
          }
        ]
      }
    }
>    2.把json bean 转为View

    XView xview = gson.fromJson(jsonString, XView.class);

    View contentView = XViewMain.startProcess(context,  xview );

    setContentView(contentView);


>##### 组件


View 组件

|属性      |     Type    |  说明          | 可选值|
|:-----   |:----------|:-----------|:------  |
|id       |int       |         |  id >=1  |
|tag  |String       |                |   |
|padding  |String       |           默认单位dp,10dp,10px    |   |
|background  |String       |      网络图片          |   |
|onClick  |String       |          方法名      |   |
|visibility  |String       |                | gone  visible  invisible  |


ViewGroup 属性

|属性      |     Type    |  说明          | 可选值|
|:-----   |:----------|:-----------|:------  |
|padding  |String       |           默认单位dp , 10dp,10px   |  |


TextView 属性

|属性      |     Type    |  说明          | 可选值|
|:-----   |:----------|:-----------|:------  |
|text  |String       |                |   |
|textColor  |String       |        #123443       |   |
|textSize  |String       |       默认单位sp         |   |
|maxLine  |int       |               |   |
|hint  |String       |               |   |
|hintColor  |String       |               |   |
|lineSpace  |String       |        android:lineSpacingExtra="4dp"        |   |
|gravity  |String       |       大小写不敏感        |  CENTER_VERTICAL等 |


ImageView 属性

|属性      |     Type    |  说明          | 可选值|
|:-----   |:----------|:-----------|:------  |
|src  |String       |       网络图片         |   |
|scaleType  |String       |  默认FIT_XY       |  MATRIX，FIT_XY，FIT_START，FIT_CENTER等 |


FrameLayout

|属性      |     Type    |  说明          | 可选值|
|:-----   |:----------|:-----------|:------  |
|gravity  |String       |         大小写不敏感       |   CENTER_VERTICAL等 |


LinearLayout 分为 VerticalLayout ，HorizonLayout

|属性      |     Type    |  说明          | 可选值|
|:-----   |:----------|:-----------|:------  |
|gravity  |String       |         大小写不敏感       |   CENTER_VERTICAL等 |
|weight  |int       |                |    |



RelativeLayout

|属性      |     Type    |  说明          | 可选值|
|:-----   |:----------|:-----------|:------  |
|layout_alignParentLeft  |bool       |                |    |
|layout_alignParentTop  |bool       |                |    |
|layout_alignParentRight  |bool       |                |    |
|layout_alignParentBottom  |bool       |                |    |
|layout_centerInParent  |bool       |                |    |
|layout_centerHorizontal  |bool       |                |    |
|layout_centerVertical  |bool       |                |    |
|below  |String       |                |    |
|toLeftOf  |String       |                |    |
|toRightOf  |String       |                |    |
|above  |String       |                |    |
|alignLeft  |String       |                |    |
|alignRight  |String       |                |    |
|alignTop  |String       |                |    |
|alignBottom  |String       |                |    |
|alignBaseline  |String       |                |    |

ScrollView

|属性      |     Type    |  说明          | 可选值|
|:-----   |:----------|:-----------|:------  |
|无属性  |int       |     默认scrollbar=none           |    |




扩展字段

|属性      |     Type    |  说明          | 可选值|
|:-----   |:----------|:-----------|:------  |
|name  |String       |     组件的名字，把RelativeLayout的相关越约束用name代替id          |    |
|child  |数组       |     子控件列表          |    |
|data  |数组       |     组件的数据          |    |

gravity 取值TOP,BOTTOM,LEFT,RIGHT,CENTER_VERTICAL,FILL_VERTICAL,CENTER_HORIZONTAL,FILL_HORIZONTAL,CENTER

>#####  性能与测试

    运用比较稳定，运用反射的地方不多，性能的影响微乎其微。

>##### 后续

     1. 实现flexboxlayout
     2. 与热更新同时使用








>example 例子

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






