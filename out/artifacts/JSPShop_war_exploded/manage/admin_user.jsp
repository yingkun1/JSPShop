<%--
  Created by IntelliJ IDEA.
  User: luffyk
  Date: 2020/6/19
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp"%>

    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="#" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="manage/admin_userAdd.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>ID</th>
                            <th>姓名</th>
                            <th>密码</th>
                            <th>性别</th>
                            <th>出生日期</th>
                            <th>用户相关信息</th>
                            <th>邮箱</th>
                            <th>手机号码</th>
                            <th>地址</th>
                            <th>用户状态</th>
                        </tr>
                        <c:forEach items="${requestScope.users}" var="user">
                            <tr>
                                <td class="tc"><input name="id[]" value="${user.USER_ID}" type="checkbox"></td>
                                <td>${user.USER_ID}</td>
                                <td>${user.USER_NAME}</td>
                                <td>${user.USER_PASSWORD}</td>
                                <c:choose>
                                    <c:when test="${user.USER_SEX == 'T'}">
                                        <td>男</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>女</td>
                                    </c:otherwise>
                                </c:choose>
                                <td>${user.USER_BIRTHDAY}</td>
                                <td>${user.USER_IDENTITY_CODE}</td>
                                <td>${user.USER_EMAIL}</td>
                                <td>${user.USER_MOBILE}</td>
                                <td>${user.USER_ADDRESS}</td>
                                <td>${user.USER_STATUS}</td>
                                <td>
                                    <a class="link-update" href="#">修改</a>
                                    <a class="link-del" href="#">删除</a>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                    <div class="list-page">
                        共${requestScope.totalNums}条记录
                        第${requestScope.currentPage}/${requestScope.totalPagesNums}页
                        <a href="admin_douserselect?count=10&currentPage=1">首页</a>
                        <a href="admin_douserselect?count=10&currentPage=${requestScope.currentPage-1 ==0 ? 1 :requestScope.currentPage-1}">上一页</a>
                        <a href="admin_douserselect?count=10&currentPage=${requestScope.currentPage+1 >requestScope.totalPagesNums ? requestScope.totalPagesNums:requestScope.currentPage+1}">下一页</a>
                        <a href="admin_douserselect?count=10&currentPage=${requestScope.totalPagesNums}">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>