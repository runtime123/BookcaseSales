<%--
  Created by IntelliJ IDEA.
  User: ZHANG GUO QIAN
  Date: 2019/12/3
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加图书</title>
    <script src="/static/js/jquery-3.3.1.min.js"></script>
</head>
<body>
    <div>
        <form id="form">
            图书类型：<input type="text" name="DetailId"><br>
            图书名称：<input type="text" name="BookName"><br>
            图书作者：<input type="text" name="BookAuthor"><br>
            &nbsp; &nbsp;&nbsp; &nbsp;出版社<input type="text" name="BookPublisher"><br>
            出版日期:<input type="date" name="BookPublisherDate"><br>
            图书进价：<input type="text" name="BookPurchasePrice"><br>
            图书售价：<input type="text" name="BookSellPrice"><br>
            价格折扣：<input type="text" name="BookDiscount"><br>
            库存数量：<input type="text" name="BookAmount"><br>
            图书销量:<input type="text" name="BookSales"><br>
            封面路径：<input type="file" name="BookCover"><br>
            图书简介：<input type="text" name="BookIntroduce"><br>

            <button type="button" id="addButtom">添加</button>
        </form>
    </div>

<script>

    $("#addButtom").onclick = function(){
        alert("进行添加")
        $jsonData = {};
        $.each($("#form").serializeArray(), function(i,e){
            $jsonData[e.name] = e.value;
        })
        $.ajax({
            url:"/book/add",
            type:"POST",
            dataType:"json",
            data:JSON.stringify($jsonData),
            success:function () {
                alert("添加成功！")
            }
        })
    }



</script>

</body>
</html>
