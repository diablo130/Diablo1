<%--
  Created by IntelliJ IDEA.
  User: 黄粟
  Date: 2015/5/26
  Time: 10:33
  To change this template use File | Settings | File Templates.
  功能：页面主要功能处理区域，此页面实现数据可视化
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="main"style="height: 400px">
  <script type="text/javascript">
    // 基于准备好的dom，初始化echarts图表
    var myChart = echarts.init(document.getElementById('main'));

    var option = {
      tooltip: {
        show: true
      },
      legend: {
        data:['销量']
      },
      xAxis : [
        {
          type : 'category',
          data : ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
        }
      ],
      yAxis : [
        {
          type : 'value'
        }
      ],
      series : [
        {
          "name":"销量",
          "type":"bar",
          "data":[5, 20, 40, 10, 10, 20]
        }
      ]
    };

    // 为echarts对象加载数据
    myChart.setOption(option);
  </script>
</div>
