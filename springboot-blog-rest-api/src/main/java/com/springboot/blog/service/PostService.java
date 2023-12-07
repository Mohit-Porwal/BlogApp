package com.springboot.blog.service;

import com.springboot.blog.entity.Post;
import com.springboot.blog.payload.PostDTO;

import java.util.List;

public interface PostService {
    public PostDTO createPost(PostDTO postDTO);

    public List<PostDTO> getAllPosts();

}
