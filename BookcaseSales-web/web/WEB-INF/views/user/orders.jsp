<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/20
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单显示界面</title>
</head>
<body>
    <div>显示订单信息</div>
    <div>
        <table id="tb-order">
            <thead>
                <td>订单ID</td>
                <td>订单编号</td>
                <td>客户ID</td>
                <!--<td>图书ID</td>
                <td>图书名称</td>
                <td>单价</td>
                <td>数量</td>
                <td>折扣</td>
                <td>总价</td>-->
                <td>接受者</td>
                <td>电话号码</td>
                <td>地址</td>
                <td>管理</td>
            </thead>
            <c:forEach items="${orders.list}" var="o">
                <tr>
                    <td>${o.orderId}</td>
                    <td>${o.orderSnid}</td>
                    <td>${o.orderCustomerId}</td>



                    <td>${o.orderReciver}</td>
                    <td>${o.orderPhone}</td>
                    <td>${o.orderAddr}</td>
                    <td>
                        <a>订单结算</a>
                        <a>修改订单</a>
                        <a>取消订单</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

<script>
    /**
     * <!--<td>${o.orderDetails.detailBookId}</td>
     <td>${o.orderDetails.detailBookName}</td>
     <td>${o.orderDetails.detailBookPrice}</td>
     <td>${o.orderDetails.detailBookAmount}</td>
     <td>${o.orderDetails.detailBookDiscount}</td>
     <td>${o.orderDetails.detailBookMoney}</td>-->
     https://github.com/Thehickey/BookCityManagementSystem-parent/blob/master/BookCity-Web/web/WEB-INF/views/customer/order.jsp
     */
</script>
</body>
</html>
