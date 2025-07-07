package com.example.escCamp.Controller;

import com.example.escCamp.Entity.Post;
import com.example.escCamp.Dto.PostDto;
import com.example.escCamp.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    //게시글 작성
    @PostMapping
    public Post create(@RequestBody PostDto dto)
    {
        return postService.createPost(dto);
    }

    //게시글 목록 조회
    @GetMapping("/all")
    public List<Post> list()
    {
        return postService.getAllPosts();
    }

    //특정 게시글 조회 (GET / posts/{id})
    @GetMapping("/{id}")
    public  Post read(@RequestParam Long id)
    {
        return postService.getPostById(id);
    }

    @GetMapping("/{title}")
    public List<Post> titleRead(@RequestParam String title)
    {
        return postService.getPostByTitle(title);
    }






}
