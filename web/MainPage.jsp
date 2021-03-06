<%--
Created by IntelliJ IDEA.
User: 黄粟
Date: 2015/5/18
Time: 12:11
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html
<%--<meta charset="utf-8">--%>
<meta http-equiv="X-UA-Comp atible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>MainPage</title>
<%--<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>--%>

<link rel="stylesheet" type="text/css" href="/Style/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/Style/buttons.css">
<script type="text/javascript" src="/Script/jquery.js"></script>
<script type="text/javascript" src="/Script/bootstrap.min.js"></script>
<script type="text/javascript" src="/Script/esl.js"></script>
<script src="/Script/echarts-all.js"></script>


<script src="/Script/vendor/jquery.ui.widget.js"></script>
<script src="/Script/jquery.iframe-transport.js"></script>
<script src="/Script/jquery.fileupload.js"></script>

<script>
  $(document).ready(function(){
    $('.dropdown-toggle').dropdown();

      /*$("#passid").hide();*/      //关闭注册
      $("#registerid").attr("disabled", true);
    /*function clearForm(form) {    //清空表单
      // iterate over all of the inputs for the form
      // element that was passed in
      $(':input', form).each(function() {
        var type = this.type;
        var tag = this.tagName.toLowerCase(); // normalize case
        // it's ok to reset the value attr of text inputs,
        // password inputs, and textareas
        if (type == 'text' || type == 'password' || tag == 'textarea')
          this.value = "";
        // checkboxes and radios need to have their checked state cleared
        // but should *not* have their 'value' changed
        else if (type == 'checkbox' || type == 'radio')
          this.checked = false;
        // select elements need to have their 'selectedIndex' property set to -1
        // (this works for both single and multiple select elements)
        else if (tag == 'select')
          this.selectedIndex = -1;
      });
    };*/
  })
</script>
<body>
<div class="container-fluid" style="height: 600px">
  <div class="row-fluid">
    <div class="span12">
      <div class="navbar">
        <div class="navbar-inner">
          <div class="container-fluid">
            <a class="btn btn-navbar" data-target=".navbar-responsive-collapse"
               data-toggle="collapse"></a> <a class="brand" href="#">Data-Analysis</a>
            <div class="nav-collapse collapse navbar-responsive-collapse">
              <ul class="nav">
                <li>
                  <a href="http://www.163.com">Introduction</a>
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
                  <p id="info" style="color: #ff0112"><%="Welcome," + session.getAttribute("myname")%>&nbsp;&nbsp;&nbsp;<a href="/src/com.Diablo.Web/LogoutServlet" ><u>Logout</u></a></p>
                </div>
              <% } else {%>
              <form id="formid" class="navbar-form navbar-right" role="search" action="/src/com.Diablo.Web/LoginServlet" method="post">
                <input id="userid" type="text" name="username" value="" placeholder="Username..." style="height:30px;"/>&nbsp;&nbsp;
                <input id="passid" type="password" name="password" placeholder="Password..." style="height:30px;"/> &nbsp;&nbsp;&nbsp;&nbsp;
                <button class="btn btn-primary" type="submit">Login</button>&nbsp;&nbsp;&nbsp;&nbsp;
                <button id="registerid" class="btn btn-primary" type="button" onclick="javascript:window.open('/register.jsp')">Register</button>
              </form>
              <%}%>
              </ul>
            </div>

          </div>
        </div>

      </div>
    </div>
  </div>
  <div class="row-fluid" >
    <div class="span4" style="border: darkmagenta 2px solid;padding:10px;height: 500px">
      <h3 style="color: #999999">Fast-Entry</h3>
      <div class="accordion" id="accordion-364724">
        <div class="accordion-group">
          <div class="accordion-heading">
            <a class="accordion-toggle collapsed" data-parent="#accordion-364724"
               data-toggle="collapse" href="index.jsp">Introduction(介绍)</a>
          </div>
        </div>
        <div class="accordion-group">
          <div class="accordion-heading">
            <a class="accordion-toggle collapsed" data-parent="#accordion-364724"
               data-toggle="collapse" href="#accordion-element-738713">Filing(文件处理)</a>
          </div>
          <div class="accordion-body collapse" id="accordion-element-738713">
            <div class="accordion-inner">
              Upload(文件上传)
            </div>
            <div class="accordion-inner">
              Preview(在线预览)
            </div>
            <div class="accordion-inner">
              Download(文件下载)
            </div>
            <div class="accordion-inner">
              Statistics(文件统计)
            </div>
          </div>
        </div>
        <div class="accordion-group">
          <div class="accordion-heading">
            <a class="accordion-toggle" data-parent="#accordion-364724" data-toggle="collapse" href="#accordion-element-374288">Data-Analysis(数据分析)</a>
          </div>
          <div class="accordion-body collapse" id="accordion-element-374288">
            <div class="accordion-inner">
              Upload/Clean(数据上传/清洗)
            </div>
            <div class="accordion-inner">
              Analsis(数据分析)
            </div>
            <div class="accordion-inner">
              Export_to_Excel/XML(数据导出)
            </div>
            <div class="accordion-inner">
              Others(其他)
            </div>
          </div>
        </div>
        <div class="accordion-group">
          <div class="accordion-heading">
            <a class="accordion-toggle collapsed" data-parent="#accordion-364724"
               data-toggle="collapse" href="mailto:jy0188836@163.com?subject=FeedBack&amp;body=Dear%20xxx
%3A" target="_blank">Contact Me(联系我)</a>
          </div>
        </div>
        <div class="accordion-group">
          <div class="accordion-heading">
            <a class="accordion-toggle" data-parent="#accordion-364724" data-
               toggle="collapse" href="showdata.jsp">Help(帮助)</a>
          </div>
        </div>
      </div>
    </div>

    <div class="span8" style="border: aqua 2px solid;height: 500px">
          <h3 style="color: #999999;padding-top: 10px;padding-left: 10px;">
            File UpLoad<%--<button type="button">abc</button>--%>
          </h3>
          <hr />
      <div style="border: #ff0714 1px solid;height: 380px">
        <form action="${pageContext.request.contextPath}/src/com.Diablo.Web/UploadHanderServlet" enctype="multipart/form-data" method="post">
          <input type="file" name="ada" multiple="multiple"/>
          <input type="submit" value="submit"/>
        <%--<table style="margin: 130px;">
            <tr>
              <th>Choose File Type:</th>
              <th><input type="radio" name="filetype"/>Word File </th>
              <th><input type="radio" name="filetype"/>Excel File </th>
            </tr>
            <tr>
              <td>Choose UpFiles(*.doc) or Excel(*.xlsx)</td>
              <td colspan="2"><input type="file" multiple="multiple" name=""/></td>
            </tr>
            <tr>
              <td colspan="3" align="center"><input class="button button-glow button-rounded button-caution" type="submit" id="subid" value="Up to Server"/> </td>
            </tr>
            <tr>
              <td colspan="3" align="center"><span id="feedbackinfo"></span></td>
            </tr>
          </table>--%>
        </form>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
