//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.springMVC.dto;

import com.example.springMVC.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class ArticleForm {

    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }

}
