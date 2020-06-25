<%--
  Created by IntelliJ IDEA.
  User: luffyk
  Date: 2020/6/25
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="manage/admin_user.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_categoryselect">分类管理</a><span class="crumb-step">&gt;</span><span>修改分类</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="admin_docategoryupdate" method="post" id="myform" >
                <input type="hidden" name="category_id" value="${requestScope.category.CATEGORY_ID}" >
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>父分类id：</th>
                        <td>
                            <select class="common-text required" id="title" name="parent_id">
                                <!--如果request域中的分类的父分类id为0，说明这个分类的父分类为根分类，所以，根分类被选中-->
                                <c:if test="${requestScope.category.CATEGORY_PARENT_ID == 0}">
                                    <option value="0" selected="selected">根分类</option>
                                </c:if>
                                <option value="0">根分类</option>
                                <c:forEach items="${requestScope.categories}" var="category">
                                    <c:if test="${category.CATEGORY_PARENT_ID == 0}">
                                        <c:choose>
                                            <c:when  test="${category.CATEGORY_ID == requestScope.category.CATEGORY_PARENT_ID}">
                                                <!--如果request域中的分类的父分类id和遍历所有的一级分类中某一个分类的id相等，那么，遍历得到的这个分类，就是request域中分类的父分类，那么，这个父分类被选中-->
                                                <option value="${category.CATEGORY_ID}" selected="selected">${category.CATEGORY_NAME}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${category.CATEGORY_ID}">${category.CATEGORY_NAME}</option>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>分类名称：</th>
                        <td><input class="common-text" name="category_name" size="50" value="${requestScope.category.CATEGORY_NAME}" type="text"></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="修改" type="submit">
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
