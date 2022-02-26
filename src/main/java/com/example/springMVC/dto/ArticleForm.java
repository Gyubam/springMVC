//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.springMVC.dto;

import com.example.springMVC.entity.Article;

public class ArticleForm {
    private String title;
    private String content;

    public Article toEntity() {
        return new Article((Long)null, this.title, this.content);
    }

    public ArticleForm(final String title, final String content) {
        this.title = title;
        this.content = content;
    }

    public String toString() {
        return "ArticleForm(title=" + this.title + ", content=" + this.content + ")";
    }
}
