<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/12
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<span>所有图书类型</span><br>
<c:forEach var="booktype" items="${bookTypeInfoList}">
                   <span>
                        <a class="getBook-a" data-bookName="${booktype.detailTypeName}" style="color: blue">${booktype.detailTypeName}/</a>
                   </span>
</c:forEach>


