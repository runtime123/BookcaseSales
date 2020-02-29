<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2020/2/17
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书上架</title>
</head>
<body>
    <div>
        <form id="m-form-book-add"
              enctype="multipart/form-data" method="post" action="/m/book/add">
            <input type="text" name="bookId">
            <input type="text" name="detailId">
            <input type="text" name="bookName">
            <input type="text" name="bookAuthor">
            <input type="text" name="bookPublisher">
            <input type="date" name="bookPublisherDate">
            <input type="text" name="bookPurchasePrice">
            <input type="text" name="bookSellPrice">
            <input type="text" name="bookDiscount">
            <input type="text" name="bookAmount">
            <input type="text" name="bookSales">
            <input type="file" name="myfile" id="myfile">
            <input type="text" name="bookIntroduce">
            <input type="submit" id="m-form-book-add-button" value="图书上架">
        </form>
    </div>

    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script>
        $(function(){

        })

        /**
         * 添加图书信息
         */
        function bookAdd(){
            $("#m-form-book-add-button").click(function(){
                alert("book上架")
                var $jsonData = {};
                $.each($("#m-form-book-add").serializeArray(),function(i,e){
                    $jsonData[e.name] = e.value;
                })

                alert(JSON.stringify($jsonData))

                $.ajax({
                    url:"/m/book/add",
                    method:"POST",
                    data:JSON.stringify($jsonData),
                    contentType:"application/json",
                    success:function(){
                        alert("书籍添加成功");
                    }
                })

            });
        }


    </script>
</body>
</html>
