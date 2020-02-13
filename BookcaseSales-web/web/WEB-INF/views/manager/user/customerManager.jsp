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
    <c:forEach items="${customerList.list}" var="customer">
        <tr>
            <td class="m-customer-id">${customer.customerId}</td>
            <td>${customer.customerName}</td>
            <td>${customer.customerPwd}</td>
            <td>${customer.customerPhone}</td>
            <td>${customer.customerAddress}</td>
            <td>${customer.customerEmail}</td>
            <td>${customer.customerType}</td>
            <td>
                <a class="m-custoemr-update" data-customerId="${customer.customerId}"
                href="/m/customer/toUpdate?customerId=${customer.customerId}">修改</a>
                <a class="m-customer-delete" data-customerId="${customer.customerId}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>


    <ul>
        <li><a href="/m/customer/getAllUserByPage?pageNum=1">首页</a></li>
        <li><a href="/m/customer/getAllUserByPage?pageNum=${customerList.prePage}">上一页</a> </li>
        <li>
            <c:forEach items="${customerList.navigatepageNums}" var="p">
                <a href="/m/customer/getAllUserByPage?pageNum=${p}">${p}</a>
            </c:forEach>
        </li>
        <li><a href="/m/customer/getAllUserByPage?pageNum=${customerList.nextPage}">下一页</a></li>
        <li><a href="/m/customer/getAllUserByPage?pageNum=${customerList.pages}">尾页</a></li>
    </ul>


<script src="/static/js/jquery-3.3.1.min.js"></script>

<script>
    $(function () {
        deleteCustomer();
    })

    //刷新界面
    function refreshIndex(){
        window.location.reload();
    }

    //删除用户信息
    function deleteCustomer(){

        $(".m-customer-delete").click(function (){
            var customerId = $(this).attr("data-customerId");
            alert(customerId);

            $.ajax({
                url:"/m/customer/delete?customerId=" + customerId,
                method:"POST",
                success:function () {
                    refreshIndex();
                }
            })


        });
    }


</script>
</body>
</html>
