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
    <title>显示订单信息和订单细节信息</title>
    <script src="static/js/jquery-3.3.1.min.js"></script>
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
                        <a id="m-o-update" data-orderId="${o.orderId}">修改订单及其细节</a>

                        <a id="m-o-delete" data-orderId="${o.orderId}">取消订单</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <script>
        $(function(){
            deleteOrder();
        });

        function deleteOrder(){
          $("#m-o-delete").click(function(){
              var orderId = $(this).attr("data-orderId");
              alert(orderId);
              $.ajax({
                  url:"/m/orderAndDetail/deleteOrder" + orderId,
                  method:"POST",
                  success:function(){
                      alert("删除成功");
                      refresh()
                  }
              })
          });
        };

        function updateOrder(){
            $("#m-o-update").click(function(){
                var orderId = $(this).attr("data-orderId");
                $.ajax({
                    url:"" + orderId,
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
