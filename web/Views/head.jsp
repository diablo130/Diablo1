<%--
  Created by IntelliJ IDEA.
  User: 黄粟
  Date: 2015/5/26
  Time: 9:40
  To change this template use File | Settings | File Templates.
  功能：全局页面导航栏，头部文件
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row-fluid">
  <div class="span12">
    <div class="navbar">
      <div class="navbar-inner">
        <div class="container-fluid">
          <a class="btn btn-navbar" data-target=".navbar-responsive-collapse"
             data-toggle="collapse"></a> <a class="brand" href="index.jsp">Data-Analysis</a>
          <div class="nav-collapse collapse navbar-responsive-collapse">
            <ul class="nav">
              <li>
                <a href="introduction.jsp">Introduction</a>
              </li>
              <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown"
                   href="#">Filing</a>
                <ul class="dropdown-menu">
                  <li>
                    <a href="#">Upload</a>
                  </li>
                  <li>
                    <a href="#">Preview</a>
                  </li>
                  <li>
                    <a href="#">Download</a>
                  </li>
                  <li>
                    <a href="#">Statistic</a>
                  </li>
                </ul>
              </li>
              <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown"
                   href="#">Data-Analysis</a>
                <ul class="dropdown-menu">
                  <li>
                    <a href="#">Upload</a>
                  </li>
                  <li>
                    <a href="#">Analysis</a>
                  </li>
                  <li>
                    <a href="#">Export_to_Excel/XML</a>
                  </li>
                  <li>
                    <a href="#">Others</a>
                  </li>
                </ul>
              </li>
              <li>
                <a href="#">Contact-Me</a>
              </li>
              <li>
                <a href="#">Help</a>
              </li>
            </ul>

            <ul class="nav pull-right">
              <% if(session.getAttribute("login")=="yes") {%>
              <div style="padding-top: 10px;" class="form-group">
                <p id="info" style="color: #ff0112"><%="Welcome," + session.getAttribute("myname")%>&nbsp;&nbsp;&nbsp;<a href="/src/com.Diablo.Web/LogoutServlet" ><u>LogOut</u></a></p>
              </div>
              <% } else {%>
              <form id="formid" class="navbar-form navbar-right" role="search" action="/src/com.Diablo.Web/LoginServlet" method="post">
                <input id="userid" type="text" name="username" value="" placeholder="Username..." style="height:30px;"/>&nbsp;&nbsp;
                <input id="passid" type="password" name="password" placeholder="Password..." style="height:30px;"/> &nbsp;&nbsp;&nbsp;&nbsp;
                <button class="btn btn-primary" type="submit">Login</button>&nbsp;&nbsp;&nbsp;&nbsp;
                <button id="registerid" class="btn btn-primary" type="button" onclick="javascript:window.open('/Views/register.jsp')">Register</button>
              </form>
              <%}%>
            </ul>
          </div>

        </div>
      </div>

    </div>
  </div>
</div>
