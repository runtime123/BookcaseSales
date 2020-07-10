package com.service.impl;

import com.dao.BookDao;
import com.entity.BookInfo;
import com.entity.BookTypeDetail;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired//(required = false)
    private BookDao bookDao;


    @Override
    public List<BookInfo> getAllBookByPage(int pageNum, int pageSize) {
       return bookDao.getAllBookByPage(pageNum,pageSize);
    }

    @Override
    public void bookAdd(BookInfo bookInfo) {
        bookDao.bookAdd(bookInfo);
    }

    @Override
    public void bookDelete(int BookId) {
        bookDao.bookDelete(BookId);
    }

    @Override
    public void bookUpdate(BookInfo bookInfo) {
        bookDao.bookUpdate(bookInfo);
    }

    @Override
    public List<BookInfo> selectOne(String BookName) {
        return bookDao.selectOne(BookName);
    }

    @Override
    public List<BookInfo> getAllBookBySales() {
        return bookDao.getAllBookBySales();
    }


    @Override
    public List<BookTypeDetail> getBookType() {
        return bookDao.getBookType();
    }

    //根据图书类型查询所有图书信息
    @Override
    public List<BookInfo> getBookByDetailTypeName(String DetailTypeName) {
        return bookDao.getBookByDetailTypeName(DetailTypeName);
    }

    @Override
    public BookInfo getBookBybookId(Integer bookId) {
        return bookDao.getBookByBookId(bookId);
    }
}
