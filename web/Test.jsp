<%--
  Created by IntelliJ IDEA.
  User: 黄粟
  Date: 2015/4/27
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.* " %>
<%--<%@ page import="javax.websocket.Session" %>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
    <script type="text/javascript" src="/Script/jquery.js"></script>
    <script type="text/javascript" src="/Script/bootstrap.min.js"></script>
    <script type="text/javascript" src="/Script/esl.js"></script>
    <script type="text/javascript" src="Script/echarts-all.js"></script>

    <script>
        /*$(function(){

         })*/
        function status() {
            alert("123123");
            <%--<jsp:forward page="Test.jsp" />--%>

        }
    </script>
    <style>
        div {
            float: left;
            padding: 3px;
            width: 50px;
            text-align: center;
            border: #ff0019 1px solid;
        }

    </style>
    <%--
<script>
  $(document).ready(function(){

  });
</script>--%>
</head>
<body>
<h1>THis is my FirstPage</h1>
<%

%>


<br/>
action参数：<c:out value="${param.action}"></c:out>
<fieldset>
    <c:if test="${param.action=='add'}">
        <legend>添加</legend>
        <table>
            <tr>
                <td>account</td>
                <td><input type="text" name="login"></td>
            </tr>
            <tr>
                <td>password</td>
                <td><input type="password" name="password"></td>
            </tr>
        </table>
    </c:if>
    <c:if test="${param.action=='edit'}">
        <legend>修改操作</legend>
        <table>
            <tr>
                <td>account</td>
                <td><c:out value="${param.login}" default="para login required"></c:out> </td>
            </tr>
            <tr>
                <td>password</td>
                <td><input type="password" name="password"></td>
            </tr>
        </table>
    </c:if>
</fieldset>
<br /><br /><br /><br /><br />
<c:forEach var="num" begin="2" end="100" step="2">
    <div>${num}</div>
</c:forEach>
<%--实例化一个对象，指定实体Bean，指定有效范围--%>
<jsp:useBean id="user1" class="com.Diablo.JDBC.UserInfo" scope="page"/>
<%--获取实体类的值--%>
<jsp:setProperty name="user1" property="*"/>
<p style="color: #ff0112">
    ${user1.username}
    <%-- <jsp:getProperty name="user1" property="username"/>--%>
</p>

<p style="color: #0d00ff">
    ${user1.password}
    <%-- <jsp:getProperty name="user1" property="password"/>--%>
</p>

<hr/>
<br /><br /><br /><br /><br />
<h2>Test Login</h2>

<% if (session.getAttribute("login") == "yes") {%>
<p id="info"><%="Welcome," + session.getAttribute("myname")%>&nbsp;&nbsp;&nbsp;<a href="#" onclick="status()">Logout</a>
</p>
<% } else {%>
<form id="formid" class="navbar-form navbar-right" role="search" action="/src/com.Rebecca.Web/FormCheck" method="post">
    <input id="userid" type="text" name="username"/>&nbsp;&nbsp;<input
        id="passid" type="text" name="password"/> &nbsp;&nbsp;&nbsp;&nbsp;
    <button class="btn btn-primary" type="submit">Login</button>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <button class="btn btn-primary" type="button" onclick="javascript:window.open('/register.jsp')">Register</button>
</form>
<%}%>
<hr/>
<button id="testid" type="button">testshow</button>
<p>测试Application</p>
<%=application.getInitParameter("diablo130")%>
<%=application.getInitParameter("root")%>

<p><a href="/src/com.Rebecca.Web/TestServlet">Servlet测试输出</a></p>

<p><%="用JSP测试输出" + application.getAttribute("diablo130") %>
</p>

<hr/>


<p><a href="/TestDB.jsp">helloJsp</a></p>
<hr/>
<form name="form1" action="/src/com.Rebecca.Web/FormCheck" method="POST">   <%--注意提交Action的路径--%>
    name:<input name="name" type="text">
    <input name="submit" value="提交" type="submit">
</form>
<hr/>
<h1>现在时间是：<%=(new java.util.Date()).toLocaleString()%>
</h1> <%--表达式--%>
<%--<h1>半径为<%=r%>米的圆，面积等于<%=area%></h1>--%>

<hr/>
<%
    int bufsize = out.getBufferSize();
    int restsize = out.getRemaining();
    out.println("当前缓冲区" + bufsize + "，当前剩余" + restsize);
    out.println(request.getRemoteAddr());
%>
<hr/>

<h1>练习4----------注册及反馈</h1>

<p><a href="/Views/register.jsp">注册页面</a></p>


<h1>练习5----------Servlet数据库查询</h1>

<p><a href="/src/com.Rebecca.Web/JDBCServlet">查询结果</a></p>
<hr/>
<h1>练习6----------绘制图表</h1>

<div id="main" style="height: 300px;width: auto;border: #dc0010 1px solid"></div>
<%--<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>--%>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="height:400px"></div>
<!-- ECharts单文件引入 -->
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts图表
    var myChart = echarts.init(document.getElementById('main'));

    var option = {
        tooltip: {
            show: true
        },
        legend: {
            data: ['销量']
        },
        xAxis: [
            {
                type: 'category',
                data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                "name": "销量",
                "type": "bar",
                "data": [5, 20, 40, 10, 10, 20]
            }
        ]
    };

    // 为echarts对象加载数据
    myChart.setOption(option);
</script>
<hr/>
</body>

</html>

