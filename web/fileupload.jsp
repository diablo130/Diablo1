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

<!--注意：1、地址 2、封装类型 3、提交类型-->
<form action="${pageContext.request.contextPath}/src/com.Diablo.Web/UploadHanderServlet" enctype="multipart/form-data" method="post">
    上传用户：<input type="text" name="username"><br/>
    上传文件1：<input type="file" name="file1"><br/>
    上传文件2：<input type="file" name="file2"><br/>
    <input type="submit" value="提交">
</form>


</body>
</html>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>