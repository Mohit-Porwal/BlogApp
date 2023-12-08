package com.springboot.blog.service;

import com.springboot.blog.payload.CommentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommentService {
    public CommentDTO createComment(long postID, CommentDTO commentDTO);
    public List<CommentDTO> getAllComments();
    public CommentDTO updateComment(long id);
    public void deleteComment(CommentDTO commentDTO);
}
