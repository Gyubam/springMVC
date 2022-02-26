//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.springMVC.controller;

import com.example.springMVC.dto.ArticleForm;
import com.example.springMVC.entity.Article;
import com.example.springMVC.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleRepository articleRepository;

    public ArticleController() {
    }

    @GetMapping({"articles/new"})
    public String newArticleForm() {
        String version = SpringVersion.getVersion();
        System.out.println(version);
        return "articles/new";
    }

    @PostMapping({"/articles/create"})
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        Article article = form.toEntity();
        log.info(article.toString());
        Article saved = (Article)this.articleRepository.save(article);
        log.info(saved.toString());
        return "";
    }
}
