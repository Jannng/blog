package com.newegg.mis.mps.blog.pojo;

import java.sql.Timestamp;

/**
 * Created by jt1n on 2019/8/9.
 */
public class Article {
    private Long articleId;

    private Long userId;

    private String articleTitle;

    private String articleContent;

    private Long articleViews;

    private Long categoryId;

    private Long articleCommentCount;

    private Timestamp articleDate;

    private String categoryName;

    private String userAccount;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Long getArticleViews() {
        return articleViews;
    }

    public void setArticleViews(Long articleViews) {
        this.articleViews = articleViews;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getArticleCommentCount() {
        return articleCommentCount;
    }

    public void setArticleCommentCount(Long articleCommentCount) {
        this.articleCommentCount = articleCommentCount;
    }

    public Timestamp getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Timestamp articleDate) {
        this.articleDate = articleDate;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", userId=" + userId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleViews=" + articleViews +
                ", categoryId=" + categoryId +
                ", articleCommentCount=" + articleCommentCount +
                ", articleDate=" + articleDate +
                ", categoryName='" + categoryName + '\'' +
                ", userAccount='" + userAccount + '\'' +
                '}';
    }
}
