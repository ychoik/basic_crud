package com.example.escCamp.Dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//게시글 데이터를 주고받기 위한 DTO
public class PostDto {

    private String title;
    private String content;
    private String writer;

}
