//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.springMVC.entity;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // DB가 인식
@AllArgsConstructor
@ToString
@NoArgsConstructor // 디폴트 생성자 추가
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column
    private String content;


}
