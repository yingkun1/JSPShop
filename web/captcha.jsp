<%--
  Created by IntelliJ IDEA.
  User: luffyk
  Date: 2020/6/22
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>验证码页面</title>
    <script type="text/javascript"
            src="js/jquery-1.12.4.min.js"></script>
</head>
<body>
<form action="confirm_captcha" method="post">
    请输入验证码：<input type="text" name="code" style="width: 80px;" /> <img id="imgObj" alt="验证码"
                                                                       src="captcha"><a  onclick="changeImg()">换一张</a><br/> <input
        type="submit" value="提交" />
</form>

</body>
<script type="text/javascript">
    $(function() {

    });

    function changeImg() {
        var imgSrc = $("#imgObj");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", chgUrl(src));
    }

    // 时间戳
    // 为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();
        url = url.substring(0, 20);
        if ((url.indexOf("&") >= 0)) {
            url = url + "×tamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }

</script>
</html>
