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
</head>
<body>
    <div id="order-reciver">
        <a>设置收货信息</a>
    </div>

    <div id="dingdan">
        <table id="tb-order-settment">
            <tr>
                <td>用户</td>
                <td>图书名称</td>
                <td>单价</td>
                <td>数量</td>
                <td>折扣</td>
                <td>总价</td>

            </tr>

                 <tr>
                     <td>${orderCart.cartCustomerId}</td>
                     <td>${orderCart.cartBookName}</td>
                     <td>${orderCart.cartBookSellPrice}</td>
                     <td>${orderCart.cartBookCount}</td>
                     <td>${orderCart.cartBookDiscount}</td>
                     <td>${orderCart.cartBookAllprice}</td>
                 </tr>
                 <tr>
                     <td>共有图书<span id="count"></span>本，合计<span id="total"></span>元</td>
                 </tr>

        </table>
    </div>

    <div><a class="settlement-a">支付宝扫码支付( ´﹀` )</a></div>
    

    <script>
        $(function(){
            toPay();
            getCount();
            getTotal();
        });

        function toPay(){
            $(".settlement-a").click(function(){
                window.location.href = "/toPay";
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
    </script>
</body>
</html>
