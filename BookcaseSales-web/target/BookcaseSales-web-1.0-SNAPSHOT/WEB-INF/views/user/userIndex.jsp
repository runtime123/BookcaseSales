<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/8
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <title>用户首页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <!-- ZUI 标准版压缩后的 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/zui/1.9.1/css/zui.min.css">
    <!-- ZUI Javascript 依赖 jQuery -->
    <script src="//cdn.bootcss.com/zui/1.9.1/lib/jquery/jquery.js"></script>
    <!-- ZUI 标准版压缩后的 JavaScript 文件 -->
    <script src="//cdn.bootcss.com/zui/1.9.1/js/zui.min.js"></script>

    <script src="static/js/jquery-3.3.1.min.js"></script>

    <link rel="stylesheet" href="static/css/layui.css" media="all">
    <script src="static/js/layui.all.js"></script>
    <!--<link href="static/css/userIndex.css">-->

    <style type="text/css">
        * {
            font-family: 楷体;
            font-size: 16px;
        }

        div {
            margin-bottom: 2px;
        }

        a:link {
            text-decoration: none;
        }

        a:hover {
            text-decoration: none;
        }

        .biankuang:hover {
            border: 1px solid #DCDCDC;
        }


        .navbar-default{
            background-color: white;
        }

        .maindiv {
            margin: auto;
            float: left;
            width: 1360px;
            height: 300px;

            position: absolute;
            left: 3px;
            right: 3px;
        }
        .maindiv_left{
            background-image: url("static/image/风云榜.jpg");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            margin: auto;
            float: left;
            text-align: left;
            width: 200px;
            height: 299px;
        }
        .maindiv_center{

            margin: auto;
            float: left;
            text-align: center;
            height: 299px;
        }
        .maindiv_right{
            background-image: url("static/image/云空.jpg");
            margin: auto;
            float: left;
            text-align: center;
            width: 250px;
            height: 299px;

        }

        .bottom{
            position: absolute;
            margin: auto;
            float: left;
            width: 1360px;
            height: 800px;

            position: absolute;

            top: 410px;
        }

        #gouwuche:hover {
            border: 1px solid red;
        }

        .icon-shopping-cart:hover{
            border: 1px solid red;
        }
        /*轮播相关样式*/
        #test10{
            border: 1px dashed red;
            width: 900px;
            height: 299px;
        }
        .img-carsouel-parent{
            width: 900px;
            height: 299px;
        }
        .img-carsouel{
            width: 900px;
            height: 299px;
        }

       .t-book-leixign tr td{
            color: #0000FF;
            font-size: 20px;
            text-align: center;
        }





    </style>
</head>
<body>

<c:if test="${errMsg != null}">
    <script>
        alert('${errMsg}');
    </script>
</c:if>

<div>

    <!-- 导航条 -->
    <div id="nav">
        <nav class="navbar navbar-default" role="navigation">
            <ul class="nav navbar-nav nav-justified">
                <c:if test="${sessionScope.customer1 == null}">
                    <li><a href="/login" >欢迎来到书阁，<span style="color: blue">登录</span></a></li>
                    <li ><a href="/regist" style="text-align: left; color: blue">|免费注册</a></li>
                </c:if>

                <c:if test="${sessionScope.customer1 != null}">
                    <li><span>欢迎<span style="color: red">${customer1.customerName}</span>来到书阁</span></li>
                    <li ><a href="/logout" style="text-align: left; color: blue">|注销</a></li>
                </c:if>
                <li></li>
                <li></li>
                <li style="font-size: 26px; color: red;">书阁</li>
                <li></li>
                <li><a href="/orderList">我的订单</a></li>
                <li><a id="displaycart" href="/getCart">购物车</a></li>
                <li><a >联系客服</a></li>
                <!--<li><a >系统通知</a></li>-->
            </ul>
        </nav>
    </div>

    <!-- 首页主体内容 -->
    <div class="div1 container">
        <!-- 搜索框 -->
        <div class="row">
            <div class="col-sm-2" style="font-size: 20px;text-align: right;"><i class="icon icon-book icon-2x"></i>书阁</div>
            <div class="col-sm-10" style="width: 700px;">
                <div class="input-group">
                    <div class="input-control search-box search-box-circle has-icon-left has-icon-right search-example"
                         id="searchboxExample">
                        <input id="inputSearchExample3" type="search" class="form-control search-input" placeholder="搜索">
                        <label for="inputSearchExample3" class="input-control-icon-left search-icon"><i
                                class="icon icon-search icon-2x"></i></label>
                    </div>
                    <span class="input-group-btn">
							<button class="sousuo btn btn-primary" type="button">搜索</button>
						</span>
                </div>
            </div>
        </div>

        <!-- 分类查询()，轮播广告，图书热销榜(显示销量最高的10本书) -->
        <div class="maindiv" id="maindiv_all">
            <div class="maindiv_left" id="all-booktype">
                <!--加载所有图书类型-->

            </div>

            <div class="maindiv_center">
                <div class="layui-carousel" id="test10">
                    <div carousel-item="" class="img-carsouel-parent">
                        <div><img class="img-carsouel" src="static/image/l1.jpg"></div>
                        <div><img class="img-carsouel" src="static/image/l2.jpg"></div>
                        <div><img class="img-carsouel" src="static/image/l3.jpg"></div>
                        <div><img class="img-carsouel" src="static/image/l4.jpg"></div>
                        <div><img class="img-carsouel" src="static/image/l5.jpg"></div>
                        <div><img class="img-carsouel" src="static/image/l6.jpg"></div>
                        <!--<div><img class="img-carsouel" src="static/image/l7.jpg"></div>-->
                    </div>
                </div>
            </div>

            <div class="maindiv_right" id="fengyunbang">

            </div>
        </div>

    </div>

    <!-- 底部显示所有图书信息 -->
    <div class="bottom">
        <!-- 分页显示图书，每行四本，按销量来排 -->
        <div class="cards cards-condensed" id="book-list">
           <!--在这里分页显示所有图书-->
        </div>
    </div>


</div>

<script>

    //轮播
    function carousel(){
        layui.use(['carousel', 'form'], function(){
            var carousel = layui.carousel
                ,form = layui.form;

            //图片轮播
            carousel.render({
                elem: '#test10'
                ,width: '900px'
                ,height: '299px'
                ,interval: 2000
            });

            //其它示例
            $('.demoTest .layui-btn').on('click', function(){
                var othis = $(this), type = othis.data('type');
                active[type] ? active[type].call(this, othis) : '';
            });
        });
    }
    //图书热销榜
    function fengyunbang() {
        $.ajax({
            url:"/bookSales",
            type:"GET"
        }).done(function (res) {
            $("#fengyunbang").append(res);
        })
    }
    //显示出所有图书类型
    function tushuleixing(){
        $.ajax({
            url:"/bookTypeInfo",
            type:"GET",
        }).done(function(res){
            $("#all-booktype").append(res);
            getBookByType();
        })
    }
    //搜索框查询,暂时出了故障，只能精确查询不能模糊查询
    function selectOne(){
        $(".btn-primary").click(function () {
            var name = $("#inputSearchExample3").val();
            alert(name);
            $.ajax({
                url:"/selectOne?BookName="+name,
                method:"POST",
                success:function () {
                    alert("搜索完成")
                }
            }).done(function (res) {
                $("#book-list").empty().append(res);//empty()清空当前内容
            })
        });
    }
    //分页显示所有图书信息
    function getAllBookByPageList(){
        $.ajax({
            url:"/getAllBookByPage",
            method:"GET"
        }).done(function (res) {
            $("#book-list").append(res);
            addCart();
        })
    }
    //根据类型查询涂书
    function getBookByType(){
        $(".getBook-a").click(function () {
            var typename = $(this).attr("data-bookName");
            $.ajax({
                url:"/getAllBookByType",
                method:"POST",
                data:{DetailTypeName:typename},
                datatype:"json",
                success:function () {
                    alert("类型查询加载中");
                }
            }).done(function (res) {
                $("#book-list").empty().append(res);
            })

        })
   }

    //将书籍加入购物车
    function addCart(){
        $(".icon-shopping-cart").click(function () {
            var CartBookName = $(this).attr("data-bookName");
            var CartBookSellPrice = $(this).attr("data-bookSellPrice");
            var CartBookDiscount = $(this).attr("data-bookDiscount");
            $.ajax({
                url:"getCartAdd?CartBookName="+CartBookName+"&CartBookSellPrice="+CartBookSellPrice+"&CartBookDiscount="+CartBookDiscount,
                type:"POST",
                contentType:"application/json;charset=utf-8",
                success:function (u) {
                    if (u == "user/userIndex"){
                        alert("添加成功！！！")
                        //window.location.href = "getCart";
                    }
                }
            })
        })
    }





    $(function () {
        //页面加载时要完成的function
        carousel();
        fengyunbang();
        tushuleixing();
        getAllBookByPageList();
       // addCart();
        selectOne();
    })
</script>

</body>
</html>
