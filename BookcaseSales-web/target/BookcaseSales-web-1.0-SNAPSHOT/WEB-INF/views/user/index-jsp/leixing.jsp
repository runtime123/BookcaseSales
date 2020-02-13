<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/12
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<span style="text-align: center;color: gold; font-size: xx-large;">所有图书类型</span><br>
<table class="t-book-leixign">
    <tr>
        <td>&nbsp;&nbsp;哲学&nbsp;&nbsp;</td>
        <td>宗教&nbsp;&nbsp;</td>
        <td>文化&nbsp;&nbsp; </td>
    </tr>

    <tr>

        <td>&nbsp;&nbsp;军事&nbsp;&nbsp;</td>
        <td>经济&nbsp;&nbsp;</td>
        <td>文学&nbsp;&nbsp;</td>
    </tr>

    <tr>
        <td>&nbsp;&nbsp;玄幻&nbsp;&nbsp;</td>
        <td>武侠&nbsp;&nbsp;</td>
        <td>仙侠&nbsp;&nbsp;</td>
    </tr>

    <tr>
        <td>&nbsp;&nbsp;科幻&nbsp;&nbsp;</td>
        <td>都市&nbsp;&nbsp;</td>
        <td>体育&nbsp;&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;悬疑&nbsp;&nbsp;</td>
        <td>  启蒙&nbsp;&nbsp;</td>
        <td>  音乐&nbsp;&nbsp;</td>
    </tr>


</table>



<!--<c:forEach var="booktype" items="${bookTypeInfoList}">
                   <span>
                        <a class="getBook-a" data-bookName="${booktype.detailTypeName}"
                           style="color: blue">
                                ${booktype.detailTypeName}
                            &nbsp;&nbsp;</a>
                   </span>
</c:forEach>-->


