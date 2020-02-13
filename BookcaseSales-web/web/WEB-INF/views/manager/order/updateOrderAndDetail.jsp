<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2020/2/10
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="detail" value="${order.orderDetails}" scope="page"></c:set>
<html>
<head>
    <title>修改订单及其细节信息</title>
    <script src="/static/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div>
    <form id="m-form-o">
        <input type="text" id="orderId" class="orderId" value="${order.orderId}"><br>
        <input type="text" id="orderSnid" class="orderSnid" value="${order.orderSnid}"><br>
        <input type="text" id="orderCustomerId" class="orderCustomerId" value="${order.orderCustomerId}"><br>
        <input type="text" id="orderReciver" class="orderReciver" value="${order.orderReciver}"><br>
        <input type="text" id="orderPhone" class="orderPhone" value="${order.orderPhone}"><br>
        <input type="text" id="orderAddr" class="orderAddr" value="${order.orderAddr}"><br>
        <input type="text" id="orderCreateAt" class="orderCreateAt" value="${order.orderCreateAt}"><br>
        <input type="text" id="orderStatus" class="orderStatus" value="${order.orderPayStatus}"><br>
        <input type="text" id="orderLastCreateAt" class="orderLastCreateAt" value="${order.orderLastCreateAt}"><br>
        <input type="button" id="orderUpdate" value="修改">
    </form>
</div>
    <div>
        <form id="m-form-od">
            <input id="detailId" class="detail" value="${detail.get(0)}">
            <input id="detailOrderId" class="detail" value="${detail.get(1)}">
            <input id="detailCustomerId" class="detail" value="${detail.get(2)}">
            <input id="detailBookName" class="detail" value="${detail.get(3)}">
            <input id="detailBookPrice" class="detail" value="${detail.get(4)}">
            <input id="detailBookAmount" class="detail" value="${detail.get(5)}">
            <input id="detailBookDiscount" class="detail" value="${detail.get(6)}">
            <input id="detailTotalMony" class="detail" value="${detail.get(7)}">
            <input type="button" id="orderDetailUpdate" value="修改">
        </form>
    </div>

</body>
</html>
