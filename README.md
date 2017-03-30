you can creat view use json data like this 
根据json数据创建view，
使用场景1：使用json创建本地视图，场景2：根据服务器返回的json数据创建视图。
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
