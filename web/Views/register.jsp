<%--
  Created by IntelliJ IDEA.
  User: 黄粟
  Date: 2015/5/18
  Time: 9:17
  To change this template use File | Settings | File Templates.
  功能：主页跳转过来的注册页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
  <script type="text/javascript" src="/Script/jquery.js"></script>
  <script type="text/javascript" src="/Script/style-table.js"></script>
  <script type="text/javascript" src="/Script/checkregister.js"></script>
  <link rel="stylesheet" type="text/css" href="/Style/css-table.css">
  <link rel="stylesheet" type="text/css" href="/Style/buttons.css">
  <style type="text/css">
    .attention{
      color: #ff0112;
      font-family: "Courier New";
    }
  </style>
</head>
<body>
<form method="post" action="/src/com.Diablo.Web/FormShow" onsubmit="checkForm(this)">
  <table align="center" bordercolor="#6633FF" border="1" cellspacing="0" width="70%">
    <tr>
      <th colspan="2" align="center">用户注册</th>
    </tr>
    <tr>
      <td align="left">User:<span class="attention">(请以邮箱名作为用户名)</span></td>
      <td>
        <input name="user" type="text" maxlength="30" onblur="checkMail(this)"/>
        <span id="mailid" class="errorinfo">输入不合法！</span>
      </td>
    </tr>
    <!--密码-->
    <tr >
      <td align="left">Password<span class="attention">(请输入6-8位数字作为密码)</span></td>
      <td >
        <input  align="left" name="pwd" type="password" maxlength="30" onblur="checkpwd(this)"/>
        <span id="pwdid" class="errorinfo">*密码输入错误！</span>
      </td>
    </tr>
    <!--密码-->
    <tr>
      <td align="left">Confirm Pwd<span class="attention">(请重复上面的密码)</span></td>
      <td>
        <input name="repwd" type="password" maxlength="30" onblur="checkrepwd(this)"/>
        <span id="repwdid"class="errorinfo">两次输入不一致！</span>
      </td>
    </tr>
    <!--提交/重置/-->
    <tr>
      <td colspan="2" align="center">
        <button type="submit" class="button button-primary button-rounded button-small">Register Now</button>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
