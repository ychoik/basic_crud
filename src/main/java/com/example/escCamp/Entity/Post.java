package com.example.escCamp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    //게시글의 고유 ID (Primary Key)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//자동 증가
    private Long id;

    //게시글 제목
    private String title;

    //게시글 내용
    private String content;

    //작성자 이름
    private String writer;



}
