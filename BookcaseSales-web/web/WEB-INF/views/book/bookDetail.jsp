<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2020/3/4
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>图书详情</title>
    <link rel="stylesheet" href="/static/css/book-detail.css">
    <script src="static/js/modernizr-custom-v2.7.1.min.js"></script>
    <script src="static/js/jquery-3.3.1.min.js"></script>
    <script src="static/js/zgq-book-detail.js"></script>


</head>
<body>
<div class="Xcontent">
    <ul class="Xcontent01">
        <!--图书封面-->
        <div class="Xcontent06">
            <img src="${bookInfoById.bookCover}" style="width: 400px;height: 500px">
        </div>

        <ol class="Xcontent13">
            <div class="Xcontent14"><a href="#"><p id="cartBookName">${bookInfoById.bookName}</p></a></div>
            <div class="Xcontent15">
                <img src="static/image/book-detail/shangpinxiangqing/热销.jpg"
                style="width: 150px;height: 30px">
            </div>
            <br>
            <div class="Xcontent16">
                <p>图书简介：${bookInfoById.bookIntroduce}</p>
            </div>
            <div class="Xcontent17">
                <p class="Xcontent18">售价</p>
                <p class="Xcontent19">￥<span id="cartBookSellPrice">${bookInfoById.bookSellPrice}</span></p>
                <div class="Xcontent20">
                    <p class="Xcontent21">促销 <span id="cartBookDiscount">${bookInfoById.bookDiscount}</span>折</p>
                    <img src="static/image/book-detail/shangpinxiangqing/X12.png">
                    <p class="Xcontent22">领610元新年礼券，满再赠好礼</p>
                </div>
                <div class="Xcontent23">
                    <p class="Xcontent24">服务</p>
                    <p class="Xcontent25">30天无忧退货&nbsp;&nbsp;&nbsp;&nbsp;       48小时快速退款 &nbsp;&nbsp;&nbsp;&nbsp;        满88元免邮</p>
                </div>

            </div>

            <div class="Xcontent30">
                <p class="Xcontent31">数量</p>
                <div class="Xcontent32"><img src="static/image/book-detail/shangpinxiangqing/X15.png"></div>
                <form>
                    <input id="input" class="input" value="1"></form>
                <div class="Xcontent33"><img src="static/image/book-detail/shangpinxiangqing/16.png"></div>

            </div>
            <br><br>
                <div class="Xcontent34">
                    <a onclick="buyNow()"><img class="buy-now" src="static/image/book-detail/shangpinxiangqing/X17.png"></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a class="add-cart"><img src="static/image/book-detail/shangpinxiangqing/X18.png"></a>
                </div>


        </ol>

    </ul>

</div>





<script>
    $(function () {
        detailAddCart();//加入购物车
       // buyNow();//立即购买
    })



    /*加入购物车*/
    function detailAddCart(){
        $(".add-cart").click(function () {
            var cartBookName = document.getElementById("cartBookName").innerText;
            var cartBookSellPrice = document.getElementById("cartBookSellPrice").innerText;
            var cartBookCount = document.getElementById("input").value;
            var cartBookDiscount = document.getElementById("cartBookDiscount").innerText;
            var cartBookAllprice = parseInt(cartBookSellPrice)*parseInt(cartBookCount)*parseInt(cartBookDiscount)/10;

            $.ajax({
                url:"/addCartBybookDetailJsp",
                method:"POST",
                data:{
                    "cartBookName":cartBookName,
                    "cartBookSellPrice":cartBookSellPrice,
                    "cartBookCount":cartBookCount,
                    "cartBookDiscount":cartBookDiscount,
                    "cartBookAllprice":cartBookAllprice
                },
                success:function (res) {
                    alert('添加成功')
                    window.location.href = "userIndex";
                }
            })

        });
    }

    /*立即购买*/
    function buyNow(){
        alert("你点击了立即购买按键！")

    }
</script>
</body>
</html>
