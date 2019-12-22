package com.controller.book;

import com.entity.BookInfo;
import com.entity.BookTypeDetail;
import com.github.pagehelper.PageInfo;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookQueryController {

    @Autowired
    private BookService bookService;

    //进入首页
    @RequestMapping("/shouye")
    public String shouye(){
        return "user/userIndex";
    }

    //搜索框查询
    @RequestMapping("/selectOne")
    public String selectOne(
            @RequestParam(value = "BookName",required = false) String BookName,Model model){
        List<BookInfo> bookInfos = bookService.selectOne(BookName);
        model.addAttribute("getBookBySelectOne",bookInfos);

        return "user/index-jsp/bookSelect";
    }

    //分页查询所有图书
    @RequestMapping("/getAllBookByPage")
    public String getAllBookByPage(@RequestParam(value = "pageNum",defaultValue = "1",required = false) int pageNum,
                                   @RequestParam(value = "pageSize",defaultValue = "4",required = false)int pageSize,Model model){
        //获取所有图书信息
        List<BookInfo> bookInfoList = bookService.getAllBookByPage(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(bookInfoList);
        System.out.println(bookInfoList);
        model.addAttribute("bookInfoList",pageInfo);

        return "user/index-jsp/bookList";
    }

    //图书热销榜
    @RequestMapping("/bookSales")
    public String getAllBookBySales(Model model){
        List<BookInfo> bookInfosBySales = bookService.getAllBookBySales();
        System.out.println(bookInfosBySales);
        model.addAttribute("bookInfoBySales",bookInfosBySales);
        return "user/index-jsp/fengyunbang";
    }

    //图书类型信息
    @RequestMapping("/bookTypeInfo")
    public String getAllBookType(Model model){
        //获取所有图书类型信息
        List<BookTypeDetail> bookTypeInfoList = bookService.getBookType();
        model.addAttribute("bookTypeInfoList",bookTypeInfoList);
        System.out.println(bookTypeInfoList);
        return "user/index-jsp/leixing";
    }

    //根据图书类型查询所有图书
    @RequestMapping("/getAllBookByType")
    public String getAllBookByType(@RequestParam(value = "DetailTypeName",required = false) String DetailTypeName,Model model){
        List<BookInfo> bookInfoList = bookService.getBookByDetailTypeName(DetailTypeName);

        model.addAttribute("getBookByType",bookInfoList);
        return "user/index-jsp/bookTypeSelect";
    }

}
