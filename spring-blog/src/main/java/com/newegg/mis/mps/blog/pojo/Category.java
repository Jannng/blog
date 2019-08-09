package com.newegg.mis.mps.blog.pojo;

import java.sql.Timestamp;

/**
 * Created by jt1n on 2019/8/9.
 */
public class Category {
    private Long categoryId;

    private String categoryName;

    private Timestamp categoryDate;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Timestamp getCategoryDate() {
        return categoryDate;
    }

    public void setCategoryDate(Timestamp categoryDate) {
        this.categoryDate = categoryDate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDate=" + categoryDate +
                '}';
    }
}
