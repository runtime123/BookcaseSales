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
    //private String DetailTypeName;//图书的详细类型名称
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

    public Integer getBookId() {
        return BookId;
    }

    public void setBookId(Integer bookId) {
        BookId = bookId;
    }

    public Integer getDetailId() {
        return DetailId;
    }

    public void setDetailId(Integer detailId) {
        DetailId = detailId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        BookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return BookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        BookPublisher = bookPublisher;
    }

    public Date getBookPublisherDate() {
        return BookPublisherDate;
    }

    public void setBookPublisherDate(Date bookPublisherDate) {
        BookPublisherDate = bookPublisherDate;
    }

    public BigDecimal getBookPurchasePrice() {
        return BookPurchasePrice;
    }

    public void setBookPurchasePrice(BigDecimal bookPurchasePrice) {
        BookPurchasePrice = bookPurchasePrice;
    }

    public BigDecimal getBookSellPrice() {
        return BookSellPrice;
    }

    public void setBookSellPrice(BigDecimal bookSellPrice) {
        BookSellPrice = bookSellPrice;
    }

    public Integer getBookDiscount() {
        return BookDiscount;
    }

    public void setBookDiscount(Integer bookDiscount) {
        BookDiscount = bookDiscount;
    }

    public Integer getBookAmount() {
        return BookAmount;
    }

    public void setBookAmount(Integer bookAmount) {
        BookAmount = bookAmount;
    }

    public Integer getBookSales() {
        return BookSales;
    }

    public void setBookSales(Integer bookSales) {
        BookSales = bookSales;
    }

    public String getBookCover() {
        return BookCover;
    }

    public void setBookCover(String bookCover) {
        BookCover = bookCover;
    }

    public String getBookIntroduce() {
        return BookIntroduce;
    }

    public void setBookIntroduce(String bookIntroduce) {
        BookIntroduce = bookIntroduce;
    }

    public BookInfo() {
    }

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
}
