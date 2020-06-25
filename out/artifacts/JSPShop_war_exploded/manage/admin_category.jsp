<%--
  Created by IntelliJ IDEA.
  User: luffyk
  Date: 2020/6/24
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp"%>

<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="admin_douserselect" method="get">
                <table class="search-tab">
                    <tr>
                        <%--                            <th width="120">选择分类:</th>--%>
                        <%--                            <td>--%>
                        <%--                                <select name="search-sort" id="">--%>
                        <%--                                    <option value="">全部</option>--%>
                        <%--                                    <option value="19">精品界面</option><option value="20">推荐界面</option>--%>
                        <%--                                </select>--%>
                        <%--                            </td>--%>
                        <th width="70">关键字:</th>
                        <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                        <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="result-wrap">
        <form name="" action="admin_douserdelete" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="admin_addcategory"><i class="icon-font"></i>新增分类</a>
                    <%--                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>--%>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="100%">
                    <tr>
                        <th>ID</th>
                        <th>分类名称</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${requestScope.categories}" var="category">
                        <c:if test="${category.CATEGORY_PARENT_ID == 0}">
                            <tr>
                                <td>${category.CATEGORY_ID}</td>
                                <td>${category.CATEGORY_NAME}</td>
                                <td><a href="admin_tocategoryupdate?category_id=${category.CATEGORY_ID}">修改</a><a href="javascript:categoryDelete('你确定要删除这个分类吗?','admin_docategorydelete?category_id=${category.CATEGORY_ID}')">删除</a></td>
                                <c:forEach items="${requestScope.categories}" var="child_category">
                                    <c:if test="${child_category.CATEGORY_PARENT_ID == category.CATEGORY_ID}">
                                        <tr>
                                            <td>${child_category.CATEGORY_ID}</td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${child_category.CATEGORY_NAME}</td>
                                            <td><a href="admin_tocategoryupdate?category_id=${child_category.CATEGORY_ID}">修改</a><a href="javascript:categoryDelete('你确定要删除这个分类吗?','admin_docategorydelete?category_id=${child_category.CATEGORY_ID}')">删除</a></td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </tr>
                            <script>
                                function categoryDelete(message,url) {
                                    if(confirm(message)){
                                        location.href = url;
                                    }
                                }
                            </script>


                        </c:if>
                    </c:forEach>
                    <script>
                        function Delete(message,url) {
                            if(confirm(message)){
                                location.href = url;
                            }
                        }
                        function selectAll(object) {
                            let elementsByName = document.getElementsByName("id[]");
                            for(let i=0;i<elementsByName.length;i++){
                                elementsByName[i].checked = object.checked;
                            }
                        }
                        function DeleteMore(message,id) {
                            if(confirm(message)){
                                console.log(id);
                                let elementById = document.getElementById(id);
                                console.log(elementById);
                                elementById.submit();
                            }
                        }
                    </script>

                </table>
                <div class="list-page">
                    共${requestScope.totalNums}条记录
                    第${requestScope.currentPage}/${requestScope.totalPagesNums}页
                    <a href="admin_douserselect?${requestScope.keywords}">首页</a>
                    <a href="admin_douserselect?count=${requestScope.count}&currentPage=${requestScope.currentPage-1 ==0 ? 1 :requestScope.currentPage-1}${requestScope.keywords}">上一页</a>
                    <a href="admin_douserselect?count=${requestScope.count}&currentPage=${requestScope.currentPage+1 >requestScope.totalPagesNums ? requestScope.totalPagesNums:requestScope.currentPage+1}${requestScope.keywords}">下一页</a>
                    <a href="admin_douserselect?count=${requestScope.count}&currentPage=${requestScope.totalPagesNums}${requestScope.keywords}">尾页</a>
                </div>
            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>
