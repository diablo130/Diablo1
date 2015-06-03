<%--
  Created by IntelliJ IDEA.
  User: 黄粟
  Date: 2015/5/26
  Time: 9:46
  To change this template use File | Settings | File Templates.
  功能：content页面中的侧边手风琴菜单
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="span4" style="border: darkmagenta 2px solid;padding:10px;height: 500px">
  <h3 style="color: #999999">Fast-Entry</h3>
  <div class="accordion" id="accordion-364724">
    <div class="accordion-group">
      <div class="accordion-heading">
        <a class="accordion-toggle collapsed" data-parent="#accordion-364724"  href="introduction.jsp">Introduction(介绍)</a>
      </div>
    </div>
    <div class="accordion-group">
      <div class="accordion-heading">
        <a class="accordion-toggle collapsed" data-parent="#accordion-364724" href="#accordion-element-738713">Filing(文件处理)</a>
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
        <a class="accordion-toggle" data-parent="#accordion-364724"  href="#accordion-element-374288">Data-Analysis(数据分析)</a>
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
            href="mailto:jy0188836@163.com?subject=FeedBack&amp;body=Dear%20xxx
%3A" target="_blank">Contact Me(联系我)</a>
      </div>
    </div>
    <div class="accordion-group">
      <div class="accordion-heading">
        <a class="accordion-toggle" data-parent="#accordion-364724" data-
           toggle="collapse" href="http://www.test.com">Help(帮助)</a>
      </div>
    </div>
  </div>
</div>
