<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/8
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员首页</title>

    <style>
        *{
            font-family: 楷体;
            font-size: large;
        }

        a{
            color: #0000FF;
        }


    </style>
</head>
<body>

    <div>
        <a href="/m/customer/getAllUserByPage">用户管理</a>
        <a href="/m/book/bookList">图书管理</a>
        <a href="/m/orderAndDetail/getAllOrderAndDetailByPage">订单管理</a>
        <!--<a href="/pay/topay?totalMoney=100&orderId=101">支付宝支付开发</a>-->
    </div>


</body>
</html>
