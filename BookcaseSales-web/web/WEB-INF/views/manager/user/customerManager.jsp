<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/8
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理界面</title>

</head>
<body>

<table>
    <tr>
        <td>编号</td>
        <td>账号名</td>
        <td>密码</td>
        <td>电话</td>
        <td>地址</td>
        <td>邮箱</td>
        <td>类型</td>
        <td>用户管理</td>
    </tr>
    <c:forEach items="${customerList}" var="customer">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.customerName}</td>
            <td>${customer.customerPwd}</td>
            <td>${customer.customerPhone}</td>
            <td>${customer.customerAddress}</td>
            <td>${customer.customerEmail}</td>
            <td>${customer.customerType}</td>
            <td>
                <a href="/customerManager/toUpdate">修改</a>
                <a href="/customerManager/delete?customerId="+customer.customerId>删除</a>
            </td>
        </tr>
    </c:forEach>
</table>


    <ul>
        <li><a href="/customerManager/getAllByPage?pageNum=1">首页</a></li>
        <li><a href="/customerManager/getAllByPage?pageNum=${customerList.prePage}">上一页</a> </li>
        <li>
            <c:forEach items="${customerList.navigatepageNums}" var="p">
                <a href="/customerManager/getAllByPage?pageNum=${p}">${p}</a>
            </c:forEach>
        </li>
        <li><a href="/customerManager/getAllByPage?pageNum=${customerList.nextPage}">下一页</a></li>
        <li><a href="customerManager/getAllByPage?pageNum=${customerList.pages}">尾页</a></li>
    </ul>

<script>

</script>
</body>
</html>
