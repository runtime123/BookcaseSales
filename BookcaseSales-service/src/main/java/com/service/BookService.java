package com.service;

import com.entity.BookInfo;
import com.entity.BookTypeDetail;

import java.util.List;

public interface BookService {
    //分页插叙所有图书信息
    List<BookInfo> getAllBookByPage(int pageNum, int pageSize);

    void bookAdd(BookInfo bookInfo);

    void bookDelete(int BookId);

    void bookUpdate(BookInfo bookInfo);
    //根据书名模糊查询图书信息
    List<BookInfo> selectOne(String BookName);
    //根据图书销量倒序图书信息
    List<BookInfo> getAllBookBySales();
    //查询所有图书类型
    List<BookTypeDetail> getBookType();
    //根据图书类型查询图书信息
    List<BookInfo> getBookByDetailTypeName(String DetailTypeName);
    //通过图书ID查询图书信息
    BookInfo getBookBybookId(Integer bookId);
}
