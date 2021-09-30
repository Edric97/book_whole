<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>结算页面</title>
    <%@include file="/pages/common/header.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">结算</span>
    <div>
        <span>欢迎<span class="um_span">${sessionScope.username}</span>光临尚硅谷书城</span>
        <a href="orderServlet?action=showMyOrder&userId=${sessionScope.userId}">我的订单</a>
        <a href="index.jsp">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
</div>

<div id="main">

    <h1>你的订单已结算，订单号为${requestScope.orderId}</h1>


</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>