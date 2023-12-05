package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDTO;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    //We are injecting the interface here and not the class. Hence, we are making a loose coupling here.
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create a blog post
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }
}
