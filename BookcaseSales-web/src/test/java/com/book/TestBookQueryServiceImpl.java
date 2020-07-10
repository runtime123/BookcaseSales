package com.book;

import com.entity.BookInfo;
import com.service.BookService;
import config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.awt.print.Book;
import java.util.List;

/**
 * @author: ZGQ
 * @DATA: 2020/7/7 15:49
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestBookQueryServiceImpl {
    @Autowired
    private BookService bookService;

    @Test
    public void getBookBybookId() {
        BookInfo bookInfo = bookService.getBookBybookId(5);
        System.out.println(bookInfo);
    }
}
