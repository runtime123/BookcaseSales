package com.dao;

import com.entity.BookInfo;
import com.entity.BookTypeDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookDao {

    List<BookInfo> getAllBookByPage(@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

    void bookAdd(BookInfo bookInfo);

    void bookDelete(int BookId);

    void bookUpdate(BookInfo bookInfo);

    List<BookInfo> selectOne(@RequestParam("BookName") String BookName);

    //根据销量查询图书信息
    List<BookInfo> getAllBookBySales();

    //查询图书类型相关信息
    List<BookTypeDetail> getBookType();

    List<BookInfo> getBookByDetailTypeName(String DetailTypeName);


}
