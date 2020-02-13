<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/4
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript"></script>

<html>
<head>
    <title>Title</title>
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <style>
        body{
            background-image: url("/static/image/建筑背景.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            font-family: 楷体;
            margin: auto;
            text-align: center;
        }

        div{
            margin: auto;
            text-align: center;
            position: absolute;
            top: 100px;
            left: 400px;
        }

        input{
            width: 300px;
            height: 35px;

        }

        button{
            width: 60px;
            height: 30px;
            background-color: linen;
        }
    </style>
</head>
<body>
<div id="zhuce">
    <form id="form">
        用户姓名：<input type="text" id="userName" name="customerName" autocomplete="off"/><br>
        用户密码：<input type="password" id="userPwd" name="customerPwd" maxlength="6"/><br>
        电话号码：<input type="tel" id="userPhone" name="customerPhone" maxlength="11" autocomplete="off"/><br>
        用户地址：<input type="text" id="userAddress" name="customerAddress" autocomplete="off"/><br>
        用户邮箱：<input type="email" id="userEmail" name="customerEmail" autocomplete="off"/><br>
        <!--注册类型：<input type="text" name="customerType" value="0"/><br><br>-->
        <button type="button" id="button">注 册</button>
    </form>


</div>

<script>
    function regist() {
        var $jsonData = {};
        $.each($("#form").serializeArray(),function(i,e){
            $jsonData[e.name] = e.value;
        })
        $.ajax({
            url:"/zhuce",
            data:JSON.stringify($jsonData),
            type:"POST",
            dateType:"json",
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                alert(data)
                if (data == "ok"){
                    window.location.href = "/login"
                }else {
                    alert("注册信息有误")
                }
            }
        })
    }

    $(function () {
        $("#button").click(function () {
           regist();
        })
    })
</script>
</body>
</html>
