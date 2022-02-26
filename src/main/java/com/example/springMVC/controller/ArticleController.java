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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = "+ id);

        // 1. id를 데이터로 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2. 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        // 3. 보여줄 페이지를 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(){

        // 1. 모든 article 가져온다



        return "";
    }
}
