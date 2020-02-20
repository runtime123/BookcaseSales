<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2020/2/10
  Time: 19:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示订单信息和订单细节信息界面</title>

    <style>
        a{
            color: #0000FF;
        }
    </style>
</head>
<body>
    <div>
        <table id="m-order-list">
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
            <td>订单管理</td>
            </thead>
            <c:forEach items="${orderList.list}" var="o">
                <tr>
                    <td class="o-oid">${o.orderId}</td>
                    <td>${o.orderSnid}</td>
                    <td>${o.orderCustomerId}</td>
                    <c:forEach items="${o.orderDetails}" var="od">
                        <td>${od.detailBookName}</td>
                        <td>${od.detailBookPrice}</td>
                        <td>${od.detailBookAmount}</td>
                        <td>${od.detailBookDiscount}</td>
                        <td>${od.detailTotalMoney}</td>
                    </c:forEach>

                    <td>${o.orderReciver}</td>
                    <td>${o.orderPhone}</td>
                    <td>${o.orderAddr}</td>
                    <td>
                        <a class="m-ood-update" data-orderId="${o.orderId}"
                        href="/m/orderAndDetail/toUpdateJsp?orderId=${o.orderId}">修改订单及其细节</a>

                        <a class="m-ood-delete" data-orderId="${o.orderId}">取消订单</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>


    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script>
        $(function(){
            deleteOrder();
            //updateOrder();
        });

        function deleteOrder(){
            $(".m-ood-delete").click(function () {
                var orderId = $(this).attr("data-orderId");
                alert(orderId);
                $.ajax({
                    url:"/m/orderAndDetail/deleteOrder?orderId=" + orderId,
                    method:"POST",
                    success:function(){
                        alert("删除成功");
                        refresh()
                    }
                });
            })
        }

        function updateOrder(){
            $(".m-ood-update").click(function(){
                var orderId = $(this).attr("data-orderId");
                alert(orderId);
                $.ajax({
                    url:"/m/orderAndDetail/toUpdateJsp?orderId=" + orderId,
                    method:"POST",
                    success:function(){
                        alert("进入修改界面");
                    }
                })
            })
        }


        function refresh(){
            window.location.reload();
        }
    </script>

</body>
</html>
