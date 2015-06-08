<%--
  Created by IntelliJ IDEA.
  User: 黄粟
  Date: 2015/5/26
  Time: 9:41
  To change this template use File | Settings | File Templates.
  功能：包含页面的下半部分
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row-fluid" >
  <%--侧边栏--%>
  <%@ include file="side.jsp"%>

  <div class="span8" style="border: aqua 2px solid;height: 500px">
    <%-- <h3 style="color: #999999">Fast-Entry</h3>--%>
    <h3 style="color: #999999;padding-top: 10px;padding-left: 10px;">
      Result Display<%--<button type="button">abc</button>--%>
    </h3>

    <%@include file="functions.jsp"%>

  </div>
</div>
