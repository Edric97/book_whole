<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%@include file="/pages/common/header.jsp" %>
    <script type="text/javascript">
        $(function () {

            $("#certainAuthor_button").click(function () {
                var author = $("#authorName").val();
                location.href = "http://localhost:8080/book_whole/manager/bookServlet?action=listAuthorWord&authorName=" + author;
            });

            $(".deleteClass").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】吗");
            });

            $(".updateClass").click(function () {
                return confirm("你确定要修改【" + $(this).parent().parent().find("td:first").text() + "】吗");
            });

            $(".confirm_button").click(function () {
                if ($("#pn_input").val() != null) {
                    var pageNo = $("#pn_input").val();
                    if (pageNo < 1 || pageNo > ${requestScope.page.pageTotal}) {
                        alert("请输入可到达的页码！");
                        $("#pn_input").val(${requestScope.page.pageNo});
                        return false;
                    }
                    location.href = "http://localhost:8080/book_whole/manager/bookServlet?action=page&pageNo=" + pageNo;
                } else {
                    alert("请输入页码！");
                    return false;
                }
            });


        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%@include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <table>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>
                输入指定作者:
            </td>
            <td>
                <input type="text" name="authorName" action="pages/manager/certainAuthor.jsp" id="authorName">
            </td>
            <td>
                <input type="button" value="确定" id="certainAuthor_button">
            </td>
        </tr>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>


        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a class="updateClass" href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>



        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>

    </table>



    <%@include file="/pages/common/page_nav.jsp"%>




</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>