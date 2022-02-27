package com.example.springMVC.api;

import com.example.springMVC.dto.ArticleForm;
import com.example.springMVC.entity.Article;
import com.example.springMVC.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleApiController {

    @Autowired
    private ArticleRepository articleRepository;

    // GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleRepository.findAll();
    }

    @GetMapping("/api/articles/{id}")
    public Article index(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    // POST
    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto) {
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }

    // PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id,
                                          @RequestBody ArticleForm dto) {
        // 1: 수정용 엔티티 생성
        Article article = dto.toEntity();

        // 2: 대상 엔티티를 조회
        Article target = articleRepository.findById(id).orElse(null);


        // 3: 잘못된 요청 처리(대상이없거나, id 다른경우)
        if (target == null || id != article.getId()) {
            // 400, 잘못된 요청 응답
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        target.patch(article);

        Article updated = articleRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    // DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {

        Article target = articleRepository.findById(id).orElse(null);

        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        articleRepository.delete(target);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
