/**
 * Created by ���� on 2015/6/5.
 */
var xmlHTTP;
function validate() {
    //��ȡ���ύ������  
    var idField = document.getElementById("userName");
    //����validate.do���servlet��ͬʱ�ѻ�ȡ�ı�����idField����url�ַ������Ա㴫�ݸ�validate.do  
    var url = "/src/com.Diablo.Web/CheckServlet?id=" + escape(idField.value);
    //����һ��XMLHttpxmlHTTPuest����xmlHTTP  
    if(window.XMLHttpRequest) {
        //IE7, Firefox, Opera֧��
        xmlHTTP = new XMLHttpRequest();
    }else if(window.ActiveXObject) {
        //IE5,IE6֧��
        xmlHTTP = new ActiveXObject("Microsoft.XMLHTTP");
    }
    /* 
     open(String method,String url, boolean )������3������ 
     method����ָ����servlet����������ʹ�õķ�������GET,POST�� 
     booleanֵָ���Ƿ��첽��trueΪʹ�ã�falseΪ��ʹ�á� 
     ����ʹ���첽������ᵽAjaxǿ����첽���ܡ� 
     */
    xmlHTTP.open("GET", url, true);
    //onreadystatechange���Դ��д����������Ӧ�ĺ���,��5��ȡֵ�ֱ����ͬ״̬  
    xmlHTTP.onreadystatechange = callback;
    //send������������  
    xmlHTTP.send(null);
}

function callback() {
    if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200) {
        var check = xmlHTTP.responseText;
        show (check);
    }
}

function show(str) {
    /*if(str == "��") {
        var show = "<font color='green'>��ϲ����ȷ��������</font>";
        alert(str);
        document.getElementById("info").innerHTML = show;
    }
    else if( str == "��") {
        var show = "<font color='red'>���ź������󣡣�����</font>";
        alert(show);
        document.getElementById("info").innerHTML = show;
    }*/
    document.getElementById("info").innerHTML = str;
}  