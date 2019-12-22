<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/3
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

    <table>
        <tr>
            <td>编号</td>
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
            <td>简介</td>
            <td>图书管理</td>
        </tr>

        <c:forEach var="book" items="${book.list}">
            <tr>
                <td>${book.BookId}</td>
                <td>${book.DetailId}</td>
                <td>${book.BookName}</td>
                <td>${book.BookAuthor}</td>
                <td>${book.BookPublisher}</td>
                <td>${book.BookPublisherDate}</td>
                <td>${book.BookPurchasePrice}</td>
                <td>${book.BookSellPrice}</td>
                <td>${book.BookDiscount}</td>
                <td>${book.BookAmount}</td>
                <td>${book.BookSales}</td>
                <td>${book.BookCover}</td>
                <td>${book.BookIntroduce}</td>
                <td>
                    <a>修改</a>
                    <a>删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>


    <ul>
        <li><a href="/book/bookList?pageNum=1">首页</a></li>
        <li><a href="/book/bookList?pageNum=${book.prePage}">上一页</a></li>
        <c:forEach items="${book.navigatepageNums}" var="p">
            <li><a href="/book/bookList?pageNum=${p}">${p}</a></li>
        </c:forEach>
        <li><a href="/book/bookList?pageNum=${book.nextPage}"></a></li>
        <li><a href="/book/bookList?pageNum=${book.pages}"></a></li>
    </ul>

</body>
</html>
