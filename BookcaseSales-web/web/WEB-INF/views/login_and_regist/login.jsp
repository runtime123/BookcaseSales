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
    <title>用户登录</title>
    <script src="/static/js/jquery-3.3.1.min.js"></script>

    <style>
        body{
            background-image: url("/static/image/云空.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            font-family: 楷体;
            margin: auto;
        }
        #denglu{
            margin: auto;
            border: 1px solid red;
            width: 400px;
            height: 300px;
            text-align: center;
            position: relative;
            top: 100px;
            background-color: snow;
        }

        input{
            width: 300px;
            height: 35px;

        }

        button{
            width: 60px;
            height: 30px;
            background-color: khaki;
        }
    </style>
</head>
<body>
<div id="denglu">
    <h1>登录</h1>
    <form id="form">
        账号：<input type="text" name="customerName" /><br><br>
        密码：<input type="password" name="customerPwd" maxlength="6"/><br><br><br>
        <button type="button" id="button">登 录</button>
    </form>

</div>


<script>


    function login() {
        //获取登录信息数据并转换成josn类型
        var $jsonData = {};
        $.each($("#form").serializeArray(),function(i,e){
            $jsonData[e.name] = e.value;
        })

        $.ajax({
            url:"/denglu",
            data:JSON.stringify($jsonData),
            type:"POST",
            dateType:"json",
            contentType:"application/json;charset=utf-8",
            success:function (data) {
                alert(data)
                if (data == "manager"){
                    //管理员登陆成功进入管理员首页
                    window.location.href = "managerIndex"
                }else if (data == "customer"){
                    /*用户登录成功进入用户首页
                    注释：这里不能用user这个关键词，否则会影响这个功能
                     */
                    window.location.href = "userIndex";
                } else {
                    alert("用户名或密码错误")
                }
            }
        });
    }

    $(function () {
        $("#button").click(function () {
           login();
        })
    })

</script>

</body>
</html>
