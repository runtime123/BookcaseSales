package com.entity;

import lombok.Data;

@Data
public class BookTypeDetail {
    private Integer DetailId;//图书详细类型
    private Integer BookTypeId;//图书大类型
    private String DetailTypeName;

    public BookTypeDetail(Integer detailId, Integer bookTypeId, String detailTypeName) {
        DetailId = detailId;
        BookTypeId = bookTypeId;
        DetailTypeName = detailTypeName;
    }
}
