<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/20
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>订单结算界面</title>
    <style>
        .settlement-a,#order-reciver{
            color: blue;
        }
    </style>
    <script src="static/js/jquery-3.3.1.min.js"></script>
</head>
<body>
    <div>
        <img id="refresh" src="static/image/刷新.jpg" onclick="refreshLocal()"
             style="text-align: right">
    </div>
    <!--<div id="order-reciver">
        <a>设置收货信息</a>
    </div>-->

    <div id="settlement-orderDetail-list">
        <table>
            <thead>
            <td><input type="checkbox" class="settle-od-check-all"></td>
            <td>图书名称</td>
            <td>单价</td>
            <td>数量</td>
            <td>折扣</td>
            <td>总价</td>
            </thead>
            <c:forEach items="${od}" var="ods">
                <tr>
                    <td>
                        <input type="checkbox" data-odCount="${ods.detailBookAmount}"
                               data-odPrice="${ods.detailBookPrice}" data-odDiscount="${ods.detailBookDiscount}"
                               class="settle-od-check">
                    </td>
                    <td>${ods.detailBookName}</td>
                    <td>${ods.detailBookPrice}</td>
                    <td>${ods.detailBookAmount}</td>
                    <td>${ods.detailBookDiscount}</td>
                    <td>${ods.detailTotalMoney}</td>
                </tr>
            </c:forEach>
            <tr>
                <td>
                    <span id="od-user"></span>共有商品<span id="od-count"></span>件，合计<span id="od-total"></span>元
                    <span id="od-settlement"  style="color: green">支付宝--订单支付</span>
                </td>
            </tr>
        </table>

    </div>

    <!--<div>
        <a class="settlement-a">支付宝扫码支付( ´﹀` )</a>
    </div>-->
    

    <script>



        $(function(){
           getCount();
           getTotal();
           total_load();
           odcheckclick();
            toPay();
        });

        function refreshLocal(){
            alert("刷新本页面");
            window.location.reload();
        }


        function toPay(){
            $("#od-settlement").click(function(){
                var money = $("#od-total").text();
                alert("需要支付" + money + "元");
                //window.location.href = "/toPay";

            });
        }


        //计算购物车总价
        function total_load(){
            var total = 0;
            $("#od-total").text(total)
        }
        //全选
        function odcheckclick(){
            var count = 0;
            $(".settle-od-check-all").click(function(){
                var chs = document.getElementsByClassName("settle-od-check");
                for (var i=0;i<chs.length;i++){
                    if (chs[i].checked){
                        chs[i].checked = false;
                        alert("false");
                    } else {
                        chs[i].checked = true;
                        alert("true");
                    }
                }
            });
        }

        //得到购物车中的商品总价
        function getTotal() {
            $(".settle-od-check").click(function () {
                var total = 0;
                //表示所有复选框
                $.each($(":checkbox"),function (index,element) {
                    if (element.checked == true){//表示所有选中的复选框
                        var price = $(this).attr("data-odPrice");
                        total += parseInt(price);
                    }
                })
                $("#od-total").text(total);
            })
        }

        //得到购物车中的图书总数
        function getCount(){
            $(".settle-od-check").click(function () {
                var count = 0;
                $.each($(":checkbox"),function (index,element) {
                    if (element.checked == true){
                        var c = $(this).attr("data-odCount");
                        //count++;
                        count += parseInt(c);
                    }
                })
                $("#od-count").text(count);
            })
        }


    </script>
</body>
</html>
