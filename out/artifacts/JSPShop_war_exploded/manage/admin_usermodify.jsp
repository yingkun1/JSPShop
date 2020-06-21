<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: luffyk
  Date: 2020/6/21
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_menu.jsp"%>

<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="/jscss/admin/design/">作品管理</a><span class="crumb-step">&gt;</span><span>新增作品</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="admin_douserupdate" method="post" id="myform" >
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>用户id：</th>
                        <td>
                            <input class="common-text required" id="title" name="user_id" size="50" value="${requestScope.user.USER_ID}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th>用户名：</th>
                        <td><input class="common-text" name="username" size="50" value="${requestScope.user.USER_NAME}" type="text"></td>
                    </tr>
                    <tr>
                        <th>密码：</th>
                        <td><input class="common-text" name="password" size="50" value="${requestScope.user.USER_PASSWORD}" type="text"></td>
                    </tr>
                    <tr>
                        <th>确认密码：</th>
                        <td><input class="common-text" name="confirm_password" size="50" value="${requestScope.user.USER_PASSWORD}" type="text"></td>
                    </tr>
                    <tr>
                        <th>性别：</th>
                        <c:choose>
                            <c:when test="${requestScope.user.USER_SEX == 'T'}">
                                <td>
                                    男 <input type="radio" name="sex" value="T" checked="checked">
                                    女 <input type="radio" name="sex" value="F" >
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    男 <input type="radio" name="sex" value="T" >
                                    女 <input type="radio" name="sex" value="F" checked="checked">
                                </td>
                            </c:otherwise>
                        </c:choose>

                    </tr>
                    <tr>
                        <th>出生日期：</th>
                        <td><input class="common-text" name="birthday" size="50" value="${requestScope.user.USER_BIRTHDAY}" type="text"></td>
                    </tr>
                    <tr>
                        <th>电子邮箱：</th>
                        <td><input class="common-text" name="email" size="50" value="${requestScope.user.USER_EMAIL}" type="text"></td>
                    </tr>
                    <tr>
                        <th>手机号码：</th>
                        <td><input class="common-text" name="mobile" size="50" value="${requestScope.user.USER_MOBILE}" type="text"></td>
                    </tr>
                    <tr>
                        <th>送货地址：</th>
                        <td><input class="common-text" name="address" size="50" value="${requestScope.user.USER_ADDRESS}" type="text"></td>
                    </tr>

                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                            <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                        </td>
                    </tr>
                    </tbody></table>
            </form>
        </div>
    </div>

</div>
<!--/main-->
</div>
</body>
</html>
