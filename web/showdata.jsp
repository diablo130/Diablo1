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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>MainPage</title>
<%--<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>--%>

<link rel="stylesheet" type="text/css" href="/Style/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/Style/buttons.css">
<link rel="stylesheet" type="text/css" href="/Style/table.css">
<script type="text/javascript" src="/Script/jquery.js"></script>
<script type="text/javascript" src="/Script/bootstrap.min.js"></script>
<script type="text/javascript" src="/Script/esl.js"></script>
<script src="/Script/echarts-all.js"></script>

<script>
  $(document).ready(function(){
    $('.dropdown-toggle').dropdown();

    /*$("#passid").hide();*/      //关闭注册
    /*$("#registerid").attr("disabled", true);*/            //注册按钮失效


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
  <%@include file="Views/head.jsp"%>                       <%--头部页面--%>
    <div class="row-fluid" >                                <%--内容页面--%>
        <%--侧边栏--%>
        <%@ include file="Views/side.jsp"%>

        <div class="span8" style="border: aqua 2px solid;height: 500px">
            <%-- <h3 style="color: #999999">Fast-Entry</h3>--%>
            <h3 style="color: #999999;padding-top: 10px;padding-left: 10px;">
                Result Display<%--<button type="button">abc</button>--%>
            </h3>

            <%@include file="Views/functions.jsp"%>
        </div>
    </div>
</div>


</body>
</html>



<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>