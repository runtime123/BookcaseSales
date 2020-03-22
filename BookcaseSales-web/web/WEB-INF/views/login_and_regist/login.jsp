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

    <link rel="stylesheet" href="static/css/login.css">
</head>
<body>
<div id="denglu">
    <h1 class="title">登录</h1>
    <form id="form">
        <div class="ib">
            账号：<input type="text" name="customerName" />
        </div>
        <div class="ib">
            密码：<input type="password" name="customerPwd" maxlength="6"/>
        </div>
    </form>
        <button type="button" id="button">登 录</button>
    <div class="rg">
        如果没有注册，请点击 <a href="javascript:;" onclick="toRegist()"><u>注册</u></a>
    </div>
        <!--<button type="button" onclick="toRegist()" >注册</button>-->
</div>


<script>


    function toRegist(){
        window.location.href = "/regist";
    }

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
                alert("登陆成功");
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
