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
                $(obj).next("img").next("span").html("");
            }else{
                $(obj).next("span").html("");
            }

        }
        function showPrompt(obj) {
            console.log("焦点离开，准备验证数据");
            if($(obj).attr("name")=="code"){
                $(obj).next("img").next("span").html("不能为空");
            }else{
                $(obj).next("span").html("不能为空");
            }
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
    <form action="#" method="post"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <p>用户注册</p>
        <p><input type="text" name="id" value="" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" placeholder="请输入用户ID"><span class="error" ></span></p>
        <p><input type="text" name="username" value="" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" placeholder="请输入用户名"><span class="error"></span></p>
        <p><input type="text" name="password" value="" placeholder="请输入密码"><span></span></p>
        <p><input type="text" name="confirm_password" value="" placeholder="请确认密码"><span></span></p>
        <p>
            男 <input style="width: 15px;height: 25px;margin-right: 50px"  type="radio" name="sex" value="T" checked="checked">
            女 <input style="width: 15px;height: 25px" type="radio" name="sex" value="F" ><span></span>
        </p>
        <p><input type="text" name="birthday" value="" onfocus="c.show(this)" placeholder="请输入生日"><span></span></p>
        <p><input type="text" name="email" value="" placeholder="请输入邮箱"><span></span></p>
        <p><input type="text" name="mobile" value="" placeholder="请输入手机号码"><span></span></p>
        <p><input type="text" name="address" value="" placeholder="请输入地址"><span></span></p>
        <p><input type="text" name="code" style="width: 80px;" placeholder="验证码" onfocus="cancelPrompt(this)" onblur="showPrompt(this)" /> <img id="imgObj" alt="验证码"
                                                                              src="captcha" onclick="changeImg()"><span class="error"></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p>完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>