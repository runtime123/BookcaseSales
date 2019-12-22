<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/22
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--用于搜索框查询-->
<c:forEach var="book" items="${getBookBySelectOne}">
    <div class="col-md-4 col-sm-6 col-lg-3">
        <a class="card" href="###">
            <img src="${book.bookCover}" alt="" style="text-align: center;width: 200px;height: 250px;margin: 0 auto">
            <div class="caption">图书简介：${book.bookIntroduce}</div>
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