package com.user;

import com.entity.BookInfo;
import com.service.BookService;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestBookQueryServiceImpl {
    @Autowired
    private BookService bookService;
    @Test
    public void selectOne() {
        List<BookInfo> bookInfos = bookService.selectOne("《吞噬星空》");
        for (BookInfo bookInfo : bookInfos) {
            System.out.println("----------------" + bookInfo);
        }

    }
    @Test
    public void getBookDetail(){
        BookInfo book = bookService.getBookBybookId(2);
        System.out.println(book);
    }
}
