<%--
  Created by IntelliJ IDEA.
  User: luffyk
  Date: 2020/6/22
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>" />
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
    <script>
        var flag = true;
        function changeImg() {
            console.log("点击了图片");
            let img = $("#imgObj");
            let src = img.attr("src");
            img.attr("src",chgUrl(src))
        }
        function chgUrl(url) {
            let timestamp = new Date().valueOf();
            url = url.substring(0,20);
            if(url.indexOf("?")>1){
                url = url+"&times="+timestamp;
            }else{
                url = url+"?timestamp="+timestamp+"&";
            }
            console.log(url);
            return url;
        }
        function cancelPrompt(obj) {
            console.log("焦点聚焦，取消后面的提示");
            if($(obj).attr("name")=="code"){
                $(obj).next("img").next("span").html("").removeClass("error");
            }else{
                $(obj).next("span").html("").removeClass("error");
            }

        }

        function showPrompt(obj) {
            console.log("焦点离开，准备验证数据");
            let attr = $(obj).attr("name");
            console.log(attr);
            switch (attr) {
                case "id":
                    if($(obj).val() == ""){
                        $(obj).next("span").html("用户id不能为空").addClass("error");
                        flag = false;
                    }else{
                        let url = 'dousernamecheck?id='+encodeURI($(obj).val())+"&"+new Date().valueOf();
                        $.get(url,function (data) {
                            console.log(data);
                            if(data == "true"){
                                $(obj).next("span").html("用户id已经被注册过了").addClass("error");
                                flag = false;
                            }else{
                                flag = true;
                            }

                        });
                    }
                    break;
                case "username":
                    if($(obj).val()==""){
                        $(obj).next("span").html("用户名不能为空").addClass("error");
                        flag = false;
                    }else{
                        flag = true;
                    }
                    break;
                case "password":
                    if($(obj).val()==""){
                        $(obj).next("span").html("密码不能为空").addClass("error");
                        flag = false;
                    }else{
                        flag = true;
                    }
                    break;
                case "confirm_password":
                    if($(obj).val()==""){
                        $(obj).next("span").html("确认密码不能为空").addClass("error");
                        flag = false;
                    }else if($(obj).val() != $("#password").val()){
                        $(obj).next("span").html("两次输入的密码不一致").addClass("error");
                        flag = false;
                    }else{
                        flag = true;
                    }
                    break;
                case "birthday":
                    if($(obj).val()==""){
                        $(obj).next("span").html("生日不能为空").addClass("error");
                        flag = false;
                    }else{
                        flag = true;
                    }
                    break;
                case "email":
                    if($(obj).val()==""){
                        $(obj).next("span").html("邮箱不能为空").addClass("error");
                        flag = false;
                    }else{
                        flag = true;
                    }
                    break;
                case "mobile":
                    if($(obj).val()==""){
                        $(obj).next("span").html("手机号码不能为空").addClass("error");
                        flag = false;
                    }else{
                        flag = true;
                    }
                    break;
                case "address":
                    if($(obj).val()==""){
                        $(obj).next("span").html("收货地址不能为空").addClass("error");
                        flag = false;
                    }else{
                        flag = true;
                    }
                    break;
                case "code":
                    if($(obj).val()==""){
                        $(obj).next("img").next("span").html("验证码不能为空").addClass("error");
                        flag = false;
                    }else{
                        let url = "dousercaptchacheck?captcha="+encodeURI($(obj).val())+"&"+new Date().valueOf();
                        $.get(url,function (data) {
                            if(data == "false"){
                                $(obj).next("img").next("span").html("验证码输入错误,请重新输入").addClass("error");
                                flag = false;
                            }else{
                                flag = true;
                            }
                        })
                    }
                    break;
            }

        }
        function checkForm(obj) {

            let elementsByTagName = obj.getElementsByTagName("input");
            for(let i =0;i<elementsByTagName.length;i++){
                if(elementsByTagName[i]!=null && elementsByTagName[i].getAttribute("onblur")){
                    showPrompt(elementsByTagName[i])
                }
            }
            return flag;
        }

    </script>
    <style>
        .error{
            display: inline-block;
            border: 1px solid #ff0000;
            background: #ff0000;
            margin-left: 20px;
        }
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="douserregister" method="post" onsubmit="return checkForm(this)" ><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <p>用户注册</p>
        <p><input type="text" name="id" value="" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" placeholder="请输入用户ID"><span></span></p>
        <p><input type="text" name="username" value="" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" placeholder="请输入用户名"><span></span></p>
        <p><input type="text" name="password" value="" id="password" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" placeholder="请输入密码"><span></span></p>
        <p><input type="text" name="confirm_password" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" value="" placeholder="请确认密码"><span></span></p>
        <p>
            男 <input style="width: 15px;height: 25px;margin-right: 50px"  type="radio" name="sex" value="T" checked="checked">
            女 <input style="width: 15px;height: 25px" type="radio" name="sex" value="F" ><span></span>
        </p>
        <p><input type="text" name="birthday" value="" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" placeholder="请输入生日"><span></span></p>
        <p><input type="text" name="email" value="" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" placeholder="请输入邮箱"><span></span></p>
        <p><input type="text" name="mobile" value="" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" placeholder="请输入手机号码"><span></span></p>
        <p><input type="text" name="address" value="" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" placeholder="请输入地址"><span></span></p>
        <p><input type="text" name="code" style="width: 80px;" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" placeholder="验证码" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" /> <img id="imgObj" alt="验证码"
                                                                              src="captcha" onclick="changeImg()"><span></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p>完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>