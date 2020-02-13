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
    <style>
        #o-all{
            font-family: 楷体;
        }
        a{
            color: blue;
        }
    </style>

    <script src="static/js/jquery-3.3.1.min.js"></script>
</head>
<body>
    <div id="o-all">
        <div>
        <table id="tb-order">
            <thead>
                <td>订单ID</td>
                <td>订单编号</td>
                <td>客户ID</td>
                <td>图书名称</td>
                <td>单价</td>
                <td>数量</td>
                <td>折扣</td>
                <td>总价</td>
                <td>接受者</td>
                <td>电话号码</td>
                <td>地址</td>
                <td>管理</td>
            </thead>
            <c:forEach items="${orders.list}" var="o">
                <tr>
                    <td class="o-oid">${o.orderId}</td>
                    <td>${o.orderSnid}</td>
                    <td>${o.orderCustomerId}</td>
                    <c:forEach items="${o.orderDetails}" var="od">

                           <td>${od.detailCustomerId}</td>
                            <td>${od.detailBookName}</td>
                            <td>${od.detailBookPrice}</td>
                            <td>${od.detailBookAmount}</td>
                            <td>${od.detailBookDiscount}</td>

                    </c:forEach>

                    <td>${o.orderReciver}</td>
                    <td>${o.orderPhone}</td>
                    <td>${o.orderAddr}</td>
                    <td>
                        <a>订单结算</a>
                        <a id="o-delete">取消订单</a>
                    </td>
                </tr>
            </c:forEach>
        </table>


    </div>
    </div>


    <script>
    $(function () {
       deleteOne();
    })

    function deleteOne() {
        $("#o-delete").click(function () {
            var orderId = $(".o-oid").text();
            alert(orderId)
            $.ajax({
                url:"deleteOrderAndDetailOne",
                method:"POST",
                data:{"orderId":orderId},
                success:function () {
                    alert("删除成功");
                }
            })
        })

    }
</script>
</body>
</html>
