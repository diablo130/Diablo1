/**
 * Created by 黄粟 on 2015/6/5.
 */
var xmlHTTP;
function validate() {
    //获取表单提交的内容  
    var idField = document.getElementById("userName");
    //访问validate.do这个servlet，同时把获取的表单内容idField加入url字符串，以便传递给validate.do  
    var url = "/src/com.Diablo.Web/CheckServlet?id=" + escape(idField.value);
    //创建一个XMLHttpxmlHTTPuest对象xmlHTTP  
    if(window.XMLHttpRequest) {
        //IE7, Firefox, Opera支持
        xmlHTTP = new XMLHttpRequest();
    }else if(window.ActiveXObject) {
        //IE5,IE6支持
        xmlHTTP = new ActiveXObject("Microsoft.XMLHTTP");
    }
    /* 
     open(String method,String url, boolean )函数有3个参数 
     method参数指定向servlet发送请求所使用的方法，有GET,POST等 
     boolean值指定是否异步，true为使用，false为不使用。 
     我们使用异步才能体会到Ajax强大的异步功能。 
     */
    xmlHTTP.open("GET", url, true);
    //onreadystatechange属性存有处理服务器响应的函数,有5个取值分别代表不同状态  
    xmlHTTP.onreadystatechange = callback;
    //send函数发送请求  
    xmlHTTP.send(null);
}

function callback() {
    if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200) {
        var check = xmlHTTP.responseText;
        show (check);
    }
}

function show(str) {
    /*if(str == "好") {
        var show = "<font color='green'>恭喜，正确！！！！</font>";
        alert(str);
        document.getElementById("info").innerHTML = show;
    }
    else if( str == "坏") {
        var show = "<font color='red'>狠遗憾，错误！！！！</font>";
        alert(show);
        document.getElementById("info").innerHTML = show;
    }*/
    document.getElementById("info").innerHTML = str;
}  