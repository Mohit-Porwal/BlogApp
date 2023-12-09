package com.springboot.blog.service;

import com.springboot.blog.payload.CommentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    public CommentDTO createComment(long postID, CommentDTO commentDTO);
    public List<CommentDTO> getCommentsByPostId(long postId);

    public CommentDTO getCommentByCommentId(long postId, long commentId);
    public CommentDTO updateComment(Long postId, long commentId, CommentDTO updatedComment);
    public void deleteComment(CommentDTO commentDTO);
}
