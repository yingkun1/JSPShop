<%--
  Created by IntelliJ IDEA.
  User: luffyk
  Date: 2020/6/25
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_menu.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="manage/admin_user.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_categoryselect">图书管理</a><span class="crumb-step">&gt;</span><span>新增图书</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="admin_doproductadd" method="post" enctype="multipart/form-data" id="myform" >
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th>图书名称：</th>
                        <td><input class="common-text" name="product_name" size="50" value="" type="text"></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>图书分类：</th>
                        <td>
                            <select class="common-text required" id="title" name="parent_id">
                                <c:forEach items="${requestScope.categories}" var="category">
                                    <c:if test="${category.CATEGORY_PARENT_ID == 0}">
                                        <option disabled="disabled" value="${category.CATEGORY_ID}">${category.CATEGORY_NAME}</option>
                                        <c:forEach items="${requestScope.categories}" var="childcategory">
                                            <c:if test="${category.CATEGORY_ID == childcategory.CATEGORY_PARENT_ID}">
                                                <option value="${childcategory.CATEGORY_ID}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${childcategory.CATEGORY_NAME}</option>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>图书图片：</th>
                        <td><input class="common-text" name="product_image" size="50" value="" type="file"></td>
                    </tr>
                    <tr>
                        <th>图书价格：</th>
                        <td><input class="common-text" name="product_price" size="50" value="" type="text"></td>
                    </tr>
                    <tr>
                        <th>图书描述：</th>
                        <td><input class="common-text" name="product_desc" size="50" value="" type="text"></td>
                    </tr>
                    <tr>
                        <th>图书库存：</th>
                        <td><input class="common-text" name="product_stock" size="50" value="" type="text"></td>
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
