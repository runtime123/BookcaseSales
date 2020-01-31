<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2020/1/29
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table id="tb-order-settment">
    <thead>
    <td><input type="checkbox" class="settle-od-check-all"></td>
    <td>图书名称</td>
    <td>单价</td>
    <td>数量</td>
    <td>折扣</td>
    <td>总价</td>
    </thead>
    <tbody id="tbody-od">
        <c:forEach items="${od}" var="ods">
        <tr>
            <td>
                <input type="checkbox" data-odCount="${ods.detailBookAmount}"
                data-odPrice="${ods.detailBookPrice}" data-odDiscount="${ods.detailBookDiscount}"
                class="settle-od-check">
            </td>
            <td>${ods.detailBookName}</td>
            <td>${ods.detailBookPrice}</td>
            <td>${ods.detailBookAmount}</td>
            <td>${ods.detailBookDiscount}</td>
            <td>${ods.detailTotalMoney}</td>
        </tr>
    </c:forEach>
    </tbody>
    <tr>
        <td>共有商品<span id="od-count"></span>件，合计<span id="od-total"></span>元</td>
    </tr>

</table>

</body>
</html>
