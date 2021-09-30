<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: caoxiaodong
  Date: 2021/9/27
  Time: 下午3:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@include file="/pages/common/header.jsp"%>
    <script type="text/javascript">
        $(function () {


            $(".confirm_button").click(function () {
                if ($("#pn_input").val() != null) {
                    var pageNo = $("#pn_input").val();
                    if (pageNo < 1 || pageNo > ${requestScope.page.pageTotal}) {
                        alert("请输入可到达的页码！");
                        $("#pn_input").val(${requestScope.page.pageNo});
                        return false;
                    }
                    location.href = "http://localhost:8080/book_whole/client/clientBookServlet?action=page&pageNo=" + pageNo;
                } else {
                    alert("请输入页码！");
                    return false;
                }
            });

            $(".book_add").click(function () {
                if (${empty sessionScope.userId}) {
                    alert("亲，请您先登录🙂");
                    location.href = "http://localhost:8080/book_whole/pages/user/login.jsp";
                } else {
                    var bookId = $(this).attr("bookId");
                    location.href = "http://localhost:8080/book_whole/cartServlet?action=addCartItem&bookId=" + bookId;
                }
            });


        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">网上书城</span>
    <div>


        <c:if test="${empty sessionScope.username}">
            <a href="pages/user/login.jsp">登录</a>
            <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        </c:if>
        <c:if test="${not empty sessionScope.username}">
            <span>欢迎<span class="um_span">${sessionScope.username}</span>光临尚硅谷书城</span>
            <a href="orderServlet?action=showMyOrder&userId=${sessionScope.userId}">我的订单</a>
        </c:if>

        <a href="cartServlet?action=exhibit&userId=${sessionScope.userId}">购物车</a>
        <a href="pages/manager/manager.jsp">后台管理</a>

    </div>
</div>


<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/clientBookServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                <input id="max" type="text" name="max" value="${param.max}"> 元
                <input id="search_button" type="submit" value="查询" />
            </form>
        </div>
        <div style="text-align: center">
            <span>您的购物车中有3件商品</span>
            <div>
                您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
            </div>
        </div>





        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="static/img/default.jpg" />
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <c:choose>
                        <c:when test="${book.stock > 0}">
                            <div class="book_add" bookId="${book.id}">
                                <button>加入购物车</button>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div>
                                掌柜的正在补货中！
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </c:forEach>







    </div>

    <%@include file="/pages/common/page_nav.jsp"%>
    
    

</div>

<%@include file="/pages/common/footer.jsp"%>
<%--这里不加斜杆，是因为index.jsp本身就在web目录下，可以被直接访问到--%>
<%--加上斜杠等价于，访问到web目录--%>
</body>
</html>