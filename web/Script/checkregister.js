window.onload=function(){
    with(document.forms[0]){
        inputcolor(user);
        inputcolor(pwd);
        inputcolor(repwd);
        inputcolor(mail);
    }
}
function inputcolor(input){
    input.className = "norm";
    input.onfocus=function(){
        this.className = "focus";
    }
}
function check(node,regex,divnode){     //封装通用的校验方法
    var b=false;
    var divNode = document.getElementById(divnode);
    if(regex.test(node.value)){
        node.className = "norm";
        divNode.style.display = "none";
        b=true;
    }
    else{
        node.className = "err";
        divNode.style.display = "block";
    }
    return b;
}
function checkUser(user){               //校验用户名
    var reg=new RegExp("^[a-z]{5,8}$");
    return check(user, reg, "userid");
}
function checkpwd(psw){                 //校验密码
    var pwdreg=new RegExp("^\\d{5,8}$");
    return check(psw, pwdreg, "pwdid");
}
function checkrepwd(repsw) {             //校验确认密码
    var b=false;
    var v1=repsw.value;//校验
    var v2 = document.getElementsByName("pwd")[0].value;
    //
    var divNode = document.getElementById("repwdid");
    if(v1==v2) {
        repsw.className = "norm";
        divNode.style.display = "none";
        b=true;
    }
    else{
        repsw.className = "err";
        divNode.style.display = "block";
    }
    return b;
}
function checkMail(mail){               //校验邮件
    var mailreg=/^\w+@\w+(\.\w+)+$/;
    return check(mail, mailreg, "mailid");
}
function checkForm(formNode){
    with(formNode){
        if(checkpwd(psw) && checkrepwd(repsw) && checkMail(mail)){
            event.returnValue=true;
        }
        else
            event.returnValue=false;
    }
}