<%--
  Created by IntelliJ IDEA.
  User: luffyk
  Date: 2020/6/19
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>" />
    <meta charset="UTF-8"/>
    <title>简单通用文章系统后台管理模板</title>
    <link rel="stylesheet" type="text/css" href="manage/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="manage/css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="manage/admin_index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="manage/admin_index.jsp">首页</a></li>
                <li><a href="#" target="index.jsp">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">管理员:${sessionScope.adminUser.USER_NAME}</a></li>
                <li><a href="admin_usermodify.jsp">修改密码</a></li>
                <li><a href="admin_douserlogout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="admin_douserselect"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                        <li><a href="admin_categoryselect"><i class="icon-font">&#xe005;</i>分类管理</a></li>
                        <li><a href="design.html"><i class="icon-font">&#xe006;</i>图书管理</a></li>
                        <li><a href="design.html"><i class="icon-font">&#xe004;</i>订单管理</a></li>
                        <li><a href="design.html"><i class="icon-font">&#xe012;</i>留言管理</a></li>
                        <li><a href="design.html"><i class="icon-font">&#xe052;</i>新闻链接</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe018;</i>系统管理</a>
                    <ul class="sub-menu">
                        <li><a href="system.html"><i class="icon-font">&#xe017;</i>系统设置</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe037;</i>清理缓存</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe046;</i>数据备份</a></li>
                        <li><a href="system.html"><i class="icon-font">&#xe045;</i>数据还原</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>