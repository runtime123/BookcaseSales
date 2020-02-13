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
    <script src="/static/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div>
    <form id="form-u">
        <input type="text" id="custoemrId" name="customerId" value="${uc.customerId}"><br>
        <input type="text" id="custoemrName" name="customerName" value="${uc.customerName}"><br>
        <input type="text" id="custoemrPwd" name="customerPwd" value="${uc.customerPwd}"><br>
        <input type="text" id="custoemrPhone" name="customerPhone" value="${uc.customerPhone}"><br>
        <input type="text" id="custoemrAddress" name="customerAddress" value="${uc.customerAddress}"><br>
        <input type="text" id="custoemrEmail" name="customerEmail" value="${uc.customerEmail}"><br>
        <input type="text" id="custoemrType" name="customerType" value="${uc.customerType}"><br>
        <input type="button" id="customerUpdate" value="修改">
    </form>
</div>

<script>
   $(function(){
       loadTable();
   })

    function loadTable() {
        $("#customerUpdate").click(function () {
            var $jsonData = {};
            $.each($("#form-u").serializeArray(),function(i,e){
                $jsonData[e.name] = e.value;
            })

            $.ajax({
                url:"/m/customer/doUpdate",
                data:JSON.stringify($jsonData),
                type:"POST",
                dateType:"json",
                contentType:"application/json;charset=utf-8",
                success:function () {
                    alert("修改应该成功了吧")
                        window.location.href = "/m/customer/getAllUserByPage"
                }
            })
        });
    }
</script>
</body>
</html>
