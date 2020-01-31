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
    <!--<div id="order-reciver">
        <a>设置收货信息</a>
    </div>-->

    <div id="settlement-orderDetail-list">

    </div>

    <!--<div>
        <a class="settlement-a">支付宝扫码支付( ´﹀` )</a>
    </div>-->
    

    <script>

        $(function(){
           loadIng();
           getCount();
           getTotal();
           total_load();
           odcheckclick();
        });

        function loadIng(){
            $.ajax({
                url:"getOrderDetailByCutomerId",
                method:"GET",
                success:function(res){
                    alert("查询成功！");
                    alert(res);
                    $("#settlement-orderDetail-list").append(res);
                }
            })
        }
        /*
        function toPay(){
            $(".settlement-a").click(function(){
                window.location.href = "/toPay";
            });
        }
        */

        //计算购物车总价
        function total_load(){
            var total = 0;
            $("#od-total").text(total)
        }
        //全选
        function odcheckclick(){
            var count = 0;
            $(".settle-od-check-all").click(function(){
                alert("fldfldfkdkfdlfjdfdlfjsdlfksdafldjfldkjfdslkfj");
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
