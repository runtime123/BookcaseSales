package com.controller.manager;

import com.entity.BookInfo;
import com.github.pagehelper.PageInfo;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/add")
    public String add(@RequestBody BookInfo bookInfo){

        bookService.bookAdd(bookInfo);

        return "manager/book/bookAdd";
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
