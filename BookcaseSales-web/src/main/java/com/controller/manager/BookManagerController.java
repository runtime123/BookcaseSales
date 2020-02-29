package com.controller.manager;

import com.entity.BookInfo;
import com.github.pagehelper.PageInfo;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/m/book")
public class BookManagerController {
    @Autowired
    private BookService bookService;



    @RequestMapping("/bookList")
    public String bookQuery(
            @RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "2",required = false)int pageSize
    , Model model){
        //分页查询所有图书信息
        List<BookInfo> bookList = bookService.getAllBookByPage(pageNum,pageSize);
        //分页处理
        PageInfo pageInfo = new PageInfo(bookList);
        //存入model
        model.addAttribute("book",pageInfo);
        return "manager/book/bookManger";
    }

    /**
     * 图书添加方法，包含了文件上传，日期时间格式设计等知识点
     * 但因为AJAX整体接收前端数据对象时无法获得上传的文件信息，故只能暂时使用表单提交
     */
    //文件上传后储存盘路径
    public static final String FILE_DIRECTORY = "D:\\学习资料文件夹\\二学年个人项目\\TwoYearProject\\BookcaseSales\\BookcaseSales-web\\src\\main\\resources\\static\\image";
    @RequestMapping("/add")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public String add(HttpServletRequest request,HttpServletResponse response,
                      //@RequestBody BookInfo bookInfo,@RequestParam(value = "myfile",required = false) MultipartFile myfile
                     MultipartFile myfile,Date bookPublisherDate){
        //是接收的数据全部为UTF-8格式
        response.setCharacterEncoding("UTF-8");
        Integer bookId = Integer.valueOf(request.getParameter("bookId"));
        Integer detailId = Integer.valueOf(request.getParameter("detailId"));
        String bookName = request.getParameter("bookName");
        String bookAuthor = request.getParameter("bookAuthor");
        String bookPublisher = request.getParameter("bookPublisher");
        Date time = bookPublisherDate;
        BigDecimal bookPurchasePrice = BigDecimal.valueOf(Integer.parseInt(request.getParameter("bookPurchasePrice")));
        BigDecimal bookSellPrice = BigDecimal.valueOf(Integer.parseInt(request.getParameter("bookSellPrice")));
        Integer bookDiscount = Integer.parseInt(request.getParameter("bookDiscount"));
        Integer bookAmount = Integer.parseInt(request.getParameter("bookAmount"));
        Integer bookSales = Integer.parseInt(request.getParameter("bookSales"));
        String myfileName = myfile.getOriginalFilename();
        System.out.println("===============================" + myfileName);
        String bookIntroduce = request.getParameter("bookIntroduce");
        BookInfo bookInfo = new BookInfo(bookId,detailId,bookName,bookAuthor,bookPublisher,bookPublisherDate,
                bookPurchasePrice,bookSellPrice,bookDiscount,bookAmount,bookSales,myfileName,bookIntroduce);
        System.out.println(bookInfo);
        String path = FILE_DIRECTORY + File.separator + myfileName;
        bookInfo.setBookCover("/static/image/" + myfileName);
        File file = new File(path);
        try {
            myfile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bookService.bookAdd(bookInfo);

        return "manager/book/bookManger";
    }

    @RequestMapping("/delete")
    public String delete(int BookId){
        bookService.bookDelete(BookId);
        return "";
    }

    @RequestMapping("/update")
    public String update(){

        return "";
    }


    /**
     * 前往图书添加界面
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAddBook(){
        return "manager/book/bookAdd";
    }

    /**
     * 进行图书添加操作
     */
    @RequestMapping("/doAdd")
    public String doAddBook(){

        return "manager/book/bookManger";
    }

}
