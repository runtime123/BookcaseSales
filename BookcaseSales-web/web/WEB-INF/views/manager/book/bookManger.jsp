<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2020/2/17
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书管理界面</title>
    <style>

        img{
            width: 150px;
            height: 200px;
        }
    </style>
</head>
<body>

    <table id="m-book-table">
        <tr>
            <td><input type="checkbox" class="m-b-check"></td>
            <td>ID</td>
            <td>类型</td>
            <td>书名</td>
            <td>作者</td>
            <td>出版社</td>
            <td>出版时间</td>
            <td>进价</td>
            <td>售价</td>
            <td>折扣</td>
            <td>库存</td>
            <td>销量</td>
            <td>封面</td>

        </tr>
        <c:forEach var="book" items="${book.list}">
            <tr>
                <td><input type="checkbox" class="m-b-check"></td>
                <td>${book.bookId}</td>
                <td>${book.detailId}</td>
                <td>${book.bookName}</td>
                <td>${book.bookAuthor}</td>
                <td>${book.bookPublisher}</td>
                <td>${book.bookPublisherDate}</td>
                <td>${book.bookPurchasePrice}</td>
                <td>${book.bookSellPrice}</td>
                <td>${book.bookDiscount}</td>
                <td>${book.bookAmount}</td>
                <td>${book.bookSales}</td>
                <td>
                    <img src="/${book.bookCover}">
                </td>

            </tr>
        </c:forEach>
        <tr>
            <td>
                <a id="m-book-add" href="/m/book/toAdd">图书上架</a>
                <a id="m-book-update">图书修改</a>
                <a id="m-book-delete">图书下架</a>
            </td>
        </tr>
    </table>



</body>
</html>
