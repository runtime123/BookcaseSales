package com.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 图书信息表，添加了一个拓展字段为图书信息表中的BookTypeName字段
 */
@Data
public class BookInfo {
    private Integer BookId;
    private Integer DetailId;//图书类型编号
    //拓展字段,图书类型名称
    private String DetailTypeName;//图书的详细类型名称
    private String BookName;
    private String BookAuthor;
    private String BookPublisher;
    private Date BookPublisherDate;
    private BigDecimal BookPurchasePrice;
    private BigDecimal BookSellPrice;
    private Integer BookDiscount;
    private Integer BookAmount;
    private Integer BookSales;
    private String BookCover;
    private String BookIntroduce;

    //不带BookId 、DetailTypeName
    public BookInfo(Integer detailId, String bookName, String bookAuthor, String bookPublisher, Date bookPublisherDate, BigDecimal bookPurchasePrice, BigDecimal bookSellPrice, Integer bookDiscount, Integer bookAmount, Integer bookSales, String bookCover, String bookIntroduce) {
        DetailId = detailId;
        BookName = bookName;
        BookAuthor = bookAuthor;
        BookPublisher = bookPublisher;
        BookPublisherDate = bookPublisherDate;
        BookPurchasePrice = bookPurchasePrice;
        BookSellPrice = bookSellPrice;
        BookDiscount = bookDiscount;
        BookAmount = bookAmount;
        BookSales = bookSales;
        BookCover = bookCover;
        BookIntroduce = bookIntroduce;
    }

    //不带DetailTypeName

    public BookInfo(Integer bookId, Integer detailId, String bookName, String bookAuthor, String bookPublisher, Date bookPublisherDate, BigDecimal bookPurchasePrice, BigDecimal bookSellPrice, Integer bookDiscount, Integer bookAmount, Integer bookSales, String bookCover, String bookIntroduce) {
        BookId = bookId;
        DetailId = detailId;
        BookName = bookName;
        BookAuthor = bookAuthor;
        BookPublisher = bookPublisher;
        BookPublisherDate = bookPublisherDate;
        BookPurchasePrice = bookPurchasePrice;
        BookSellPrice = bookSellPrice;
        BookDiscount = bookDiscount;
        BookAmount = bookAmount;
        BookSales = bookSales;
        BookCover = bookCover;
        BookIntroduce = bookIntroduce;
    }

    //全带了

    public BookInfo(Integer bookId, Integer detailId, String detailTypeName, String bookName, String bookAuthor, String bookPublisher, Date bookPublisherDate, BigDecimal bookPurchasePrice, BigDecimal bookSellPrice, Integer bookDiscount, Integer bookAmount, Integer bookSales, String bookCover, String bookIntroduce) {
        BookId = bookId;
        DetailId = detailId;
        DetailTypeName = detailTypeName;
        BookName = bookName;
        BookAuthor = bookAuthor;
        BookPublisher = bookPublisher;
        BookPublisherDate = bookPublisherDate;
        BookPurchasePrice = bookPurchasePrice;
        BookSellPrice = bookSellPrice;
        BookDiscount = bookDiscount;
        BookAmount = bookAmount;
        BookSales = bookSales;
        BookCover = bookCover;
        BookIntroduce = bookIntroduce;
    }
}
