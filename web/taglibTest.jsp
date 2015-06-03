<%@ page language="java" import="java.util.*, com.Diablo.JDBC.Person" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="java.util.Locale" %>
<%@ page import="java.io.File" %>
<% request.setAttribute("localeList", Locale.getAvailableLocales()); %>
<%

    List<Person> personList = new ArrayList<Person>();

    int i = 1;

    Person person = new Person();
    person.setId(i++);
    person.setName("张三");
    person.setAge(20);
    person.setSex("男");
    person.setAddress("北京市海淀区上地软件园");
    person.setBirthday("2008-08-08");
    person.setMobile("13820080808");
    person.setTelephone("69653234");
    person.setCity("北京");

    personList.add(person);

    Person person2 = new Person();
    person2.setId(i++);
    person2.setName("李四");
    person2.setAge(20);
    person2.setSex("男");
    person2.setAddress("北京市东皇城根锡拉胡同");
    person2.setBirthday("2008-01-01");
    person2.setMobile("13820080808");
    person2.setTelephone("20054879");
    person2.setCity("北京");

    personList.add(person2);

    Person person3 = new Person();
    person3.setId(i++);
    person3.setName("王五");
    person3.setAge(20);
    person3.setSex("男");
    person3.setAddress("北京市东皇城根锡拉胡同");
    person3.setBirthday("2008-01-01");
    person3.setMobile("13820080808");
    person3.setTelephone("20054879");
    person3.setCity("北京");

    personList.add(person3);

    Person person4 = new Person();
    person4.setId(i++);
    person4.setName("王二麻子");
    person4.setAge(20);
    person4.setSex("男");
    person4.setAddress("北京市东皇城根锡拉胡同");
    person4.setBirthday("2008-01-01");
    person4.setMobile("13820080808");
    person4.setTelephone("20054879");
    person4.setCity("北京");

    personList.add(person4);

    Person person5 = new Person();
    person5.setId(i++);
    person5.setName("王二麻子");
    person5.setAge(20);
    person5.setSex("男");
    person5.setAddress("北京市东皇城根锡拉胡同");
    person5.setBirthday("2008-01-01");
    person5.setMobile("13820080808");
    person5.setTelephone("20054879");
    person5.setCity("北京");

    personList.add(person5);

    Person person6 = new Person();
    person6.setId(i++);
    person6.setName("王二麻子");
    person6.setAge(20);
    person6.setSex("男");
    person6.setAddress("北京市东皇城根锡拉胡同");
    person6.setBirthday("2008-01-01");
    person6.setMobile("13820080808");
    person6.setTelephone("20054879");
    person6.setCity("北京");

    personList.add(person6);

    Person person7 = new Person();
    person7.setId(i++);
    person7.setName("王二麻子");
    person7.setAge(20);
    person7.setSex("男");
    person7.setAddress("北京市东皇城根锡拉胡同");
    person7.setBirthday("2008-01-01");
    person7.setMobile("13820080808");
    person7.setTelephone("20054879");
    person7.setCity("北京");

    personList.add(person7);

    request.setAttribute("personList", personList);
    String URI = request.getRequestURI();
    String SPath = request.getServletPath();
    String CPath = request.getContextPath();


%>
<% request.setAttribute("files", new File("d:\\").listFiles()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <style>
        table {
            border-collapse: collapse;
            border: 1px solid #000000;
        }

        td {
            border: 1px solid #000000;
            font-size: 12px;
            padding: 2px;
        }

        .title td {
            text-align: center;
            background: #cccccc;
        }
    </style>
</head>
<body>
<sql:setDataSource driver="com.mysql.jdbc.Driver" user="root" password="admin"
url="jdbc:mysql://localhost:3306/information?user=root&pass=admin" var="datasource" />
<c:catch var="e">
    <sql:query var="rs" dataSource="${datasource}" scope="page" >
        select * from 公交数据表
    </sql:query>
    <%--<sql:update var="result" dataSource="${datasource}">
        insert into xxxx(name,sex)value('zhangsan','male')
    </sql:update>
    影响到的条数：${result}--%>

    <table>
        <tr>
            <c:forEach var="columnName" items="${rs.columnNames}">
                <td>${columnName}</td>
            </c:forEach>
        </tr>
        <c:forEach var="row" items="${rs.rows}">
            <tr>
                <c:forEach var="columnName" items="${rs.columnNames}">
                    <td>${row[columnName]}</td>
                </c:forEach>
                <%--<td>${row.日期}</td>
                <td>${row['到站人数']}</td>
                <td>${row['图']}</td>
                <td>${row['节']}</td>
                <td>${row['其他']}</td>--%>
            </tr>
        </c:forEach>
    </table>
</c:catch>
<c:if test="${e!=null}">
    <div style="color: #ff0019">Exception:${e.message}</div>
</c:if>



<%--分割字符串--%>
<%--<c:set value="${fn:split(header['accept'], ',')}" var="names" />
header['accept']:<br/>
<c:forEach items="${names}" var="name">
    ${name} <br/>
</c:forEach>--%>

<%--合并字符串--%>
<%--<%
    request.setAttribute("array",new String[]{"a","b","c","d","e","f"});
%>
${fn:join(array,'::')}

<br/><hr/>--%>

<%--取字符串、集合、数组的长度:<br/>
"${[pageContext.request.requestURI]}:"${fn:length(pageContext.request.requestURI)}<br/>
${fn:length(header)}<br/>--%>
<%--
uri:<%=URI%><br/>
SPath:<%=SPath%><br/>
CPath:<%=CPath%><br/>
uri:/taglibTest.jsp
SPath:/taglibTest.jsp
CPath:--%>


<%--endWiths的用法--%>
<%--<table >
    <tr>
        <th>File Name</th>
        <th>type</th>
    </tr>
    <c:forEach var="file" items="${files}">
        <tr>
            <td>
                ${file.name}
            </td>
            <td>
                <c:choose>
                    <c:when test="${file.directory}">文件夹</c:when>
                    <c:otherwise>
                        <c:if test="${fn:endsWith(file.name,'.jpg')}">JPG图片</c:if>
                        <c:if test="${fn:endsWith(file.name,'.exe')}">exe文件</c:if>
                        <c:if test="${fn:endsWith(file.name,'.txt')}">文本</c:if>
                        <c:if test="${fn:endsWith(file.name,'.doc')}">word文档</c:if>
                        <c:if test="${fn:endsWith(file.name,'.xls')}">excel表</c:if>
                        <c:if test="${fn:endsWith(file.name,'.log')}">日志</c:if>
                        <c:if test="${fn:endsWith(file.name,'.sql')}">数据库</c:if>
                    </c:otherwise>
                </c:choose>
            </td>

        </tr>
    </c:forEach>
</table>--%>

<%--<jsp:useBean id="curdate" class="java.util.Date"></jsp:useBean>
<fmt:formatDate value="${curdate}"/><br/>
<fmt:formatDate value="${curdate}" pattern="yyyy/MM/dd HH:mm:ss:sss"/>--%>

<%--<fmt:parseDate value="2014-12-12" />--%>


<%--数字、字符串--%>
<%--<fmt:parseNumber value="1,100"></fmt:parseNumber>
<br/>
<fmt:parseNumber value="1,000" parseLocale="de"></fmt:parseNumber>--%>


<%--时区--%>
<%--<% Map<String, TimeZone> map = new HashMap<String, TimeZone>();
    for (String id : TimeZone.getAvailableIDs()) {
        map.put(id, TimeZone.getTimeZone(id));
    }
    request.setAttribute("timeZoneIds", TimeZone.getAvailableIDs());
    request.setAttribute("timeZone", map);
%>
<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
<fmt:setLocale value="zh_CN"/>
现在时刻：<%=TimeZone.getDefault().getDisplayName()%>
</
>
<fmt:formatDate value="${date}" type="both"/><br/>
<table>
    <tr>
        <th>时区ID</th>
        <th>时区</th>
        <th>现在时间</th>
        <th>时差</th>
    </tr>
    <tr>
        <c:forEach var="ID" items="${timeZoneIds}" varStatus="status">
            <td>${ID}</td>
            <td>${timeZone[ID].displayName}</td>
            <td><fmt:formatDate value="${date}" type="both" timeZone="${ID}"/></td>
            <td>${timeZone[ID].rawOffset/60/60/1000}</td>
        </c:forEach>
    </tr>
</table>--%>


<%--本地化--%>
<%--<table>
  <tr>
    <th>Locale</th>
    <th>Language</th>
    <th>Date and Time</th>
    <th>Number</th>
    <th>currency</th>
  </tr>
  <jsp:useBean id="date" class="java.util.Date" ></jsp:useBean>
  <c:forEach var="locale" items="${localeList}">
    <fmt:setLocale value="${locale}"/>
    <tr>
      <td>${locale.displayName}</td>
      <td>${locale.displayLanguage}</td>
      <td><fmt:formatDate value="${date}" type="both"/> </td>
      <td><fmt:formatNumber value="10000.5"/> </td>
      <td><fmt:formatNumber value="10000.5" type="currency"/> </td>
    </tr>
  </c:forEach>
</table>--%>


<%--测试Map--%>
<%--<table>
  <tr>
    <td>Header Name</td>
    <td>Header Value</td>
  </tr>
  <c:forEach items="${header}" var="item">
    <tr>
      <td>${item.key}</td>
      <td>${item.value}</td>
    </tr>
  </c:forEach>
</table>--%>

<%--测试List--%>
<%--
<table>
  <tr class="title">
    <td>编号</td>
    <td>姓名</td>
    <td>年龄</td>
    <td>性别</td>
    <td>城市</td>
    <td>地址</td>
    <td>生日</td>
    <td>手机</td>
    <td>电话</td>
  </tr>

  <c:forEach items="${ personList }" var="person">

    <tr>
      <td>${ person.id }</td>
      <td>${ person.name }</td>
      <td>${ person.age }</td>
      <td>${ person.sex }</td>
      <td>${ person.city }</td>
      <td>${ person.address }</td>
      <td>${ person.birthday }</td>
      <td>${ person.mobile }</td>
      <td>${ person.telephone }</td>
    </tr>

  </c:forEach>

</table>

<br/>
<br/>
<br/>

<table>
  <tr class="title">
    <td>编号</td>
    <td>姓名</td>
    <td>年龄</td>
    <td>性别</td>
    <td>城市</td>
    <td>地址</td>
    <td>生日</td>
    <td>手机</td>
    <td>电话</td>
  </tr>

  <c:forEach items="${ personList }" varStatus="varStatus">

    <tr bgcolor="${ varStatus.index % 2 == 1 ? '#EFEFEF' : '#FFFFFF' }">
      <td>${ varStatus.current.id }</td>
      <td>${ varStatus.current.name }</td>
      <td>${ varStatus.current.age }</td>
      <td>${ varStatus.current.sex }</td>
      <td>${ varStatus.current.city }</td>
      <td>${ varStatus.current.address }</td>
      <td>${ varStatus.current.birthday }</td>
      <td>${ varStatus.current.mobile }</td>
      <td>${ varStatus.current.telephone }</td>
    </tr>
  </c:forEach>
</table>
--%>

<%--<table>
  <c:forTokens items="a,b,c,d,e,f,g,h,j,k" delims="," begin="1"  step="2" var="item" varStatus="varstatus">
    <tr>
        <td>${varstatus.index}</td>
        <td>${item}</td>
    </tr>
  </c:forTokens>
</table>--%>

<%--<c:set scope="page" var="number">
<c:out value="${1+1}"/>
</c:set>

<c:set scope="request" var="number">
  <%=3%>
</c:set>

<c:set scope="session" var="number">
  4
</c:set>

<table border="1" width="70%">
  <tr>
    <th>pageScope.number</th>
    <td><c:out value="${pageScope.number}" default="No Data" /></td>
  </tr>
  <tr>
    <th>request.number</th>
    <td><c:out value="${requestScope.number}" default="No Data" /></td>
  </tr>
  <tr>
    <th>session.number</th>
    <td><c:out value="${sessionScope.number}" default="No Data" /></td>
  </tr>
</table>--%>
<hr/>


<%--提交表单--%>
<%--<fmt:requestEncoding value="UTF-8"/>
<form action="${pageContext.request.requestURI}" method="post">
  关键字：<input name="key" /><c:out value="${param.key}" default="输入关键字"></c:out>
  <br/><br/>
  <input type="submit"/>
</form>--%>
</body>
</html>
