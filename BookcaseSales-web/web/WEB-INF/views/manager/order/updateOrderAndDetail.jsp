<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2020/2/10
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改订单及其细节信息界面</title>
</head>
<body>
<div>
    <form id="m-form-o-u">
    <input type="text" id="orderId" name="orderId" value="${mOrderToUpdate.orderId}"><br>
    <input type="text" id="orderSnid" name="orderSnid" value="${mOrderToUpdate.orderSnid}"><br>
    <input type="text" id="orderCustomerId" name="orderCustomerId" value="${mOrderToUpdate.orderCustomerId}"><br>
    <input type="text" id="orderReciver" name="orderReciver" value="${mOrderToUpdate.orderReciver}"><br>
    <input type="text" id="orderPhone" name="orderPhone" value="${mOrderToUpdate.orderPhone}"><br>
    <input type="text" id="orderAddr" name="orderAddr" value="${mOrderToUpdate.orderAddr}"><br>
    <input type="text" id="orderCreateAt" name="orderCreateAt" value="${mOrderToUpdate.orderCreateAt}"><br>
    <input type="text" id="orderStatus" name="orderStatus" value="${mOrderToUpdate.orderPayStatus}"><br>
    <input type="text" id="orderLastCreateAt" name="orderLastCreateAt" value="${mOrderToUpdate.orderLastCreateAt}"><br>
    <input type="button" id="orderUpdate" value="修改">
</form>
</div>
    <div>
        <form id="m-form-od-u">
            <input type="text" id="detailId" name="detailId" value="${mOrderDetailToUpdate.detailId}">
            <input type="text" id="detailOrderId" name="detailOrderId" value="${mOrderDetailToUpdate.detailOrderId}">
            <input type="text" id="detailCustomerId" name="detailCustomerId" value="${mOrderDetailToUpdate.detailCustomerId}">
            <input type="text" id="detailBookName" name="detailBookName" value="${mOrderDetailToUpdate.detailBookName}">
            <input type="text" id="detailBookPrice" name="detailBookPrice" value="${mOrderDetailToUpdate.detailBookPrice}">
            <input type="text" id="detailBookAmount" name="detailBookAmount" value="${mOrderDetailToUpdate.detailBookAmount}">
            <input type="text" id="detailBookDiscount" name="detailDiscount" value="${mOrderDetailToUpdate.detailBookDiscount}">
            <input type="text" id="detailTotalMoney" name="detailTotalMoney" value="${mOrderDetailToUpdate.detailTotalMoney}">
            <input type="button" id="orderDetailUpdate" value="修改">
        </form>
    </div>


<script src="/static/js/jquery-3.3.1.min.js"></script>
<script>
    $(function(){
        updateOrder();
        updateOrderDetail()
    })

    function updateOrder(){
        $("#orderUpdate").click(function () {
            var $jsonData = {};
            $.each($("#m-form-o-u").serializeArray(),function(i,e){
                $jsonData[e.name] = e.value;
            })
            alert(JSON.stringify($jsonData))
           $.ajax({
               url:"/m/orderAndDetail/doUpdateOrder",
               data:JSON.stringify($jsonData),
               type:"POST",
               dateType:"json",
               contentType:"application/json;charset=utf-8",
               success(){
                   alert("修改成功");
                   window.location.href = "/m/orderAndDetail/getAllOrderAndDetailByPage";
               }
           })
        });
    }

    function updateOrderDetail(){
        $("#orderDetailUpdate").click(function () {
            var $jsonData = {};
            $.each($("#m-form-od-u").serializeArray(),function(i,e){
                $jsonData[e.name] = e.value;
            })
            alert(JSON.stringify($jsonData));
            $.ajax({
                url:"/m/orderAndDetail/doUpdateOrderDetail",
                method:"POST",
                data:JSON.stringify($jsonData),
                dateType:"json",
                contentType:"application/json;charset=utf-8",
                success(){
                    alert("修改成功");
                    window.location.href = "/m/orderAndDetail/getAllOrderAndDetailByPage";
                }
            })
        });
    }
</script>

</body>
</html>
