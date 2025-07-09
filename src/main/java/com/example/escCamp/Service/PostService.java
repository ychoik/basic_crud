package com.example.escCamp.Service;

import com.example.escCamp.Dto.PostDto;
import com.example.escCamp.Entity.Post;
import com.example.escCamp.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    //Repository를 주입받음
    private final PostRepository postRepository;

    //게시글 저장
    public Post createPost(PostDto dto){
        //DTO -> Entity
        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();

        //db에 저장
        return postRepository.save(post);


    }

    //게시글 전체 조회
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    //번호로 특정 게시글 조회
    public Post getPostById(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
    }

    //제목으로 특정 게시글 조회
    public List<Post> getPostByTitle(String title){
        return postRepository.findByTitleContaining(title);
    }



}
