<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/12
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




    <span style="text-align: center;color: gold; font-size: xx-large;">图书热销榜</span>
    <table id="fengyunbang-table" style="text-align: center">
        <tr>
            <td>序号</td>
            <td>书名</td>
            <td>销量</td>
        </tr>
        <c:forEach var="bs" items="${bookInfoBySales}" varStatus="s">
            <tr>
                <td><font style="color: #FF5722">${s.index}</font></td>
                <td><a style="color: blue">${bs.bookName}</a></td>
                <td>${bs.bookSales}</td>
            </tr>
        </c:forEach>
    </table>




