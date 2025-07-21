package com.example.escCamp.Service;

import com.example.escCamp.Dto.PostDto;
import com.example.escCamp.Entity.Post;
import com.example.escCamp.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "해당 게시글을 찾을 수 없습니다. ID: " + id));
    }

    //제목으로 특정 게시글 조회
    public List<Post> getPostByTitle(String title){
        List<Post> result = postRepository.findByTitleContaining(title);
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 제목의 게시글이 없습니다.");
        }
        return result;
    }

    //게시글 수정 기능
    public Post updatePost(Long id, PostDto dto) {
        Post post = getPostById(id); // 존재 여부 확인
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setWriter(dto.getWriter());
        return postRepository.save(post);
    }

    //게시글 삭제 기능
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "삭제할 게시글이 없습니다. ID: " + id);
        }
        postRepository.deleteById(id);
    }









}
