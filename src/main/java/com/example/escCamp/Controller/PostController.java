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
    @GetMapping("/id/{id}")
    public  Post read(@RequestParam Long id)
    {
        return postService.getPostById(id);
    }

    @GetMapping("/title/{title}")
    public List<Post> titleRead(@RequestParam String title)
    {
        return postService.getPostByTitle(title);
    }

    //게시글 글 수정
    @PutMapping("/id/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody PostDto dto) {
        return postService.updatePost(id, dto);
    }

    //게시글 글 삭제
    @DeleteMapping("/id/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "삭제 완료 (ID: " + id + ")";
    }


}
