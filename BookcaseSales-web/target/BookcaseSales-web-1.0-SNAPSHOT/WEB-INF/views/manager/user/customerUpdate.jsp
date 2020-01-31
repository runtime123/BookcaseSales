<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/21
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="uc" value="${uCustomer}"></c:set>
<html>
<head>
    <title>用户信息修改界面</title>
</head>
<body>
<div>
    <form id="form-u">
        <input type="text" name="customerId" value="${uc.customerId}">
        <input type="text" name="customerName" value="${uc.customerName}">
        <input type="text" name="customerPwd" value="${uc.customerPwd}">
        <input type="text" name="customerPhone" value="${uc.customerPhone}">
        <input type="text" name="customerAddress" value="${uc.customerAddress}">
        <input type="text" name="customerEmail" value="${uc.customerEmail}">
        <input type="text" name="customerType" value="${uc.customerType}">
        <input type="button" id="customerUpdate">
    </form>
</div>

<script>
    $(function () {
        loadTable();
    })

    function loadTable() {
        $("#customerUpdate").click(function () {
            var $jsonData = {};
            $.each($("#form-u").serializeArray(),function(i,e){
                $jsonData[e.name] = e.value;
            })
            $.ajax({
                url:"/doUpdate",
                data:JSON.stringify($jsonData),
                type:"POST",
                dateType:"json",
                contentType:"application/json;charset=utf-8",
                success:function (data) {
                    alert(data)
                    if (data == "manager/user/customerManager"){
                        window.location.href = "/customerManager/manger"
                    }
                }
            })
        });
    }
</script>
</body>
</html>
