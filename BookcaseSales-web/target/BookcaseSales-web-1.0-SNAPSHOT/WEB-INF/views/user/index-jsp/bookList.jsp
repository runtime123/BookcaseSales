<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/13
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--用于主页分页查询图书数据-->
<c:forEach var="book" items="${bookInfoList.list}">
    <div class="col-md-4 col-sm-6 col-lg-3">
        <a class="card" href="/getBookInfoByBookId?bookId=${book.bookId}">
            <img class="book-cover-image" src="${book.bookCover}" alt="" style="text-align: center;width: 200px;height: 250px;margin: 0 auto" data-bookId="${book.bookId}">
            <div class="caption" data-bookId="${book.bookId}">图书简介：${book.bookIntroduce}</div>
            <div class="card-heading">
                <strong>${book.bookName}</strong>
                <span style="text-align: right; color: gold">作者：${book.bookAuthor}</span>

            </div>
            <div class="card-content text-muted">
                <span><strong style="color: red">￥:${book.bookSellPrice}</strong>&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp; 销量：<strong style="color: #737373">${book.bookSales}</strong>
                </span>
                <span id="gouwuche">
                    <a class="icon icon-shopping-cart"
                       style="text-align: center;font-size: large;color: blue"
                       data-bookName="${book.bookName}" data-bookSellPrice="${book.bookSellPrice}"
                       data-bookDiscount="${book.bookDiscount}">
                        <i><!-- 这里放购物车的图标 --></i>加入购物车
                    </a>
                    <strong>&nbsp;&nbsp;&nbsp;&nbsp;优惠${book.bookDiscount}折</strong>
                </span>
            </div>
        </a>
    </div>
</c:forEach>

<div class="col-sm-8" style="text-align: center">
    <ul class="pager">
        <li><a class="book-page-first" >首页</a></li>
        <li><a class="book-page-pre">上一页</a></li>

            <li><a class="book-page-p">${bookInfoList.pageNum}</a></li>

        <li><a class="book-page-next">下一页</a></li>
        <li><a class="book-page-end">尾页</a></li>
    </ul>
</div>

<script>
    $(function () {
        shouye();
        pre();
        p();
        next();
        end();
    });

    //首页
    function shouye() {
        $(".book-page-first").click(function(){
            var pageNum = 1;
            alert("当前页码：" + pageNum);
            $.ajax({
                url:"/getAllBookByPage",
                type:"POST",
                data:{pageNum:pageNum},
                success:function () {
                    alert(pageNum);
                }.done(function (res) {
                    alert(res);
                    $("#book-list").empty().append(res);
                })
            })
        });
    }

    //上一页
    function pre(){
        $(".book-page-pre").click(function(){
            var pageNum =  ${bookInfoList.prePage};
            alert("当前页码：" + pageNum);
            $.ajax({
                url:"/getAllBookByPage",
                type:"POST",
                data:{pageNum:pageNum},
                success:function () {
                    alert(pageNum);
                }.done(function (res) {
                    alert(res);
                    $("#book-list").empty().append(res);
                })
            })
        });
    }

    //页码
    function p(){
        $(".book-page-p").click(function(){
            var pageNum =  ${bookInfoList.pageNum};
            alert("当前页码：" + pageNum);
            $.ajax({
                url:"/getAllBookByPage",
                type:"POST",
                data:{pageNum:pageNum},
                success:function () {
                    alert(pageNum);
                }.done(function (res) {
                    alert(res);
                    $("#book-list").empty().append(res);
                })
            })
        });
    }

    //下一页
    function next(){
        $(".book-page-next").click(function(){
            var pageNum =  ${bookInfoList.nextPage};
            alert("当前页码：" + pageNum);
            $.ajax({
                url:"/getAllBookByPage",
                type:"POST",
                data:{pageNum:pageNum},
                success:function () {
                    alert(pageNum);
                }.done(function (res) {
                    alert(res);
                    $("#book-list").empty().append(res);
                })
            })
        });
    }

    //尾页
    function end(){
        $(".book-page-end").click(function(){
            var pageNum =  ${bookInfoList.pages};
            alert("当前页码：" + pageNum);
            $.ajax({
                url:"/getAllBookByPage",
                type:"POST",
                data:{pageNum:pageNum},
                success:function () {
                    alert(pageNum);
                }.done(function (res) {
                    alert(res);
                    $("#book-list").empty().append(res);
                })
            })
        });
    }
</script>