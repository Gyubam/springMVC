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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
//        log.info(form.toString());
        Article article = form.toEntity();
//        log.info(article.toString());
        Article saved = (Article) this.articleRepository.save(article);
//        log.info(saved.toString());
        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
//        log.info("id = "+ id);

        // 1. id를 데이터로 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2. 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        // 3. 보여줄 페이지를 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {

        // 1. 모든 article 가져온다
        List<Article> articleEntityList = articleRepository.findAll();

        // 2. 가져온 Article 묶음을 뷰로 전달!
        model.addAttribute("articleList", articleEntityList);

        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Article articleEntity = articleRepository.findById(id).orElse(null);

        model.addAttribute("article", articleEntity);


        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form) {

//        log.info(form.toString());

        // 1. dto를 엔티티로 변환한다
        Article articleEntity = form.toEntity();

        // 2. 엔티티를 db로 저장한다
        // 2-1. db에서 기존 데이터를 가져온다
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        // 2-2. 기존 데이터의 값을 갱신한다
        if (target != null) {
            articleRepository.save(articleEntity);
        }
        return "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){

        // 1. 삭제 대상을 가져온다
        Article target = articleRepository.findById(id).orElse(null);

        // 2. 대상을 삭제한다
        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제가 완료되었습니다.");
        }


        return "redirect:/articles";
    }
}
