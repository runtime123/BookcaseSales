<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/16
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我的购物车</title>
   <!-- <link  rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
    <script src="static/js/angular.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="static/js/mycart1.js" type="text/javascript" charset="utf-8"></script>-->
    <script src="static/js/jquery-3.3.1.min.js"></script>
</head>
<body ng-app>

<c:if test="${cart == null}">
    穷鬼，你的购物车为空，滚一边去。
</c:if>
<div>
    <input type="button" onclick="refreshLocal()" value="❤">
</div>
<c:if test="${cart != null}">
    <table>
        <tr>
            <td><input type="checkbox" class="cart-check-all"></td>
            <td>cartID</td>
            <td>用户</td>
            <td>书名</td>
            <td>单价</td>
            <td>数量</td>
            <td>折扣</td>
            <td>总价</td>
            <td>管理</td>
        </tr>
        <c:forEach var="cart" items="${cart}">
            <tr>
                <td><input type="checkbox" data-cartId="${cart.cartId}"
                           data-bookprice="${cart.cartBookAllprice}" data-cartBookDiscount="${cart.cartBookDiscount}"
                          data-bookcount="${cart.cartBookCount}" data-cartCustomerId="${cart.cartCustomerId}"
                           data-cartBookName="${cart.cartBookName}" data-cartBookSellPrice="${cart.cartBookSellPrice}"
                           class="cart-check"></td>
                <td>${cart.cartId}</td>
                <td>${cart.cartCustomerId}</td>
                <td class="cart-name">${cart.cartBookName}</td>
                <td class="money" data-cartBookSellPrice="${cart.cartBookSellPrice}">${cart.cartBookSellPrice}</td>
                <td>
                    <input type="button" class="cart-sub" value="-" data-CartBookName="${cart.cartBookName}">
                    <input type="text" class="count"  value=" ${cart.cartBookCount}">
                    <input type="button" class="cart-add" value="+" data-CartBookName="${cart.cartBookName}">
                </td>
                <td>${cart.cartBookDiscount}</td>
                <td class="allMoney">￥<span class="Money">${cart.cartBookAllprice}</span></td>
                <td>
                    <a class="cart-delete" data-cartBookName="${cart.cartBookName}">删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr><td><span id="user"></span>共有图书<span id="count"></span>本，合计<span id="total"></span>元</td></tr>
    </table>

    <div>
        <a href="/deleteAll">清空购物车</a>
        <a id="settlement" style="color: blue" >结算</a><!--点击此键进入一个订单结算界面，


        在订单界面里有按键 《修改订单》《取消订单》《订单支付》，可以在这里面设置收获用户的信息，可以通过修改订单进行订单信息的更改，
         点击付款进行二维码支付，付款成功生成一个已付款的订单，否则生成一个未付款的订单。并返回购物车界面-->
    </div>



</c:if>

<script>

    //刷新本jsp界面
    function refreshLocal(){
        window.location.reload();
    }
    //购物车购书数量+1
    function addCart1(){
        $(".cart-add").click(function(){
            var cartBookName = $(this).attr("data-cartBookName");
           $.ajax({
               url:"/add?CartBookName="+cartBookName,
               type:"POST",
               contentType:"application/json;charset=utf-8",
               success:function (data) {
                   if (data = "user/cart"){
                       alert("数量+1成功！");
                       window.location.href = "getCart";
                   }
               }
           })
        })
    }
    //购物车数量—1
    function subCart1(){
        $(".cart-sub").click(function(){
            var cartBookName = $(this).attr("data-cartBookName");
            alert(cartBookName);
            $.ajax({
                url:"/sub?CartBookName="+cartBookName,
                type:"POST",
                contentType:"application/json;charset=utf-8",
                success:function (data) {
                    if (data = "user/cart"){
                        alert("数量-1成功！");
                        window.location.href = "getCart";
                    }
                }
            })
        })
    }
    //删除某类商品
    function deleteCart(){
        $(".cart-delete").click(function(){
            var cartBookName = $(this).attr("data-cartBookName");
            $.ajax({
                url:"/deleteOne?CartBookName="+cartBookName,
                type:"POST",
                success:function(){//不知是什么原因，此处没有运行，可能是url这个字是关键词，导致此处受到影响
                    refreshLocal();
                }
            })

        })
    }
    //清空购物车
    function deleteCartAll(){
        $.ajax({
            url:"/deleteAll",
            type:"POST",
            success:function(url){
                if (url == "user/cart") {
                    window.location.href = "getCart";
                }
            }
        })
    }
    //一进入购物车界面开始计算购物车商品
    function total_load(){
        var price = 0;
        $.each($(":checkbox"),function (index,element) {
            if (element.checked == true){
                var price = $(this).attr("data-bookprice");
                $(".allMoney").text(price);
            }
        })
    }

    //全选
    function checkclick(){
        var count = 0;
        $(".cart-check-all").click(function(){
            var chs = document.getElementsByClassName("cart-check");
            for (var i=0;i<chs.length;i++){
                if (chs[i].checked){
                    chs[i].checked = false;
                } else {
                    chs[i].checked = true;
                }
            }
        });
    }

    //得到购物车中的商品总价
    function getTotal() {
        $(".cart-check").click(function () {
            var total = 0;
            //表示所有复选框
            $.each($(":checkbox"),function (index,element) {
                if (element.checked == true){//表示所有选中的复选框
                    var price = $(this).attr("data-bookprice");
                    total += parseInt(price);
                }
            })
            $("#total").text(total);
        })
    }

    //得到购物车中的图书总数
    function getCount(){
        $(".cart-check").click(function () {
            var count = 0;
            $.each($(":checkbox"),function (index,element) {
                if (element.checked == true){
                    var c = $(this).attr("data-bookcount");
                    //count++;
                    count += parseInt(c);
                }
            })
            $("#count").text(count);
        })
    }

    //进入订单结算页面
    function toSettlement(){
        $("#settlement").click(function(){
            //设置订单金额
            var totalMoney = 0;
            $.each($(":checkbox"),function(index,element){
                if (element.checked == true){
                    var cartId = $(this).attr("data-cartId");
                    //获取订单金额
                    var price = $(this).attr("data-bookprice");
                    totalMoney += parseInt(price);
                    //通过cartId和totalMoney进行生成订单和订单细节操作
                    $.ajax({
                        url:"/orderSettlement?cartId=" + cartId + "&totalMoney=" + totalMoney,
                        method:"POST",
                        success:function () {
                            refreshLocal();
                            //显示要结算的订单信息
                            window.location.href = "/getOrderDetailByCutomerId";
                        }
                    })

                }
            })

        })
    }



    $(function () {
        total_load();
        addCart1();
        subCart1();
        deleteCart();
        checkclick();
        getCount();
        getTotal();
       toSettlement();

    })
</script>

</body>
</html>
