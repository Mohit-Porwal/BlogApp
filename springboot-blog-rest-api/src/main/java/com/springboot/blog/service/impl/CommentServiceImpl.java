package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.CommentDTO;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDTO createComment(long postId, CommentDTO commentDTO) {
        Comment comment = mapToEntity(commentDTO);

        Post post = postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
        comment.setPost(post);

        Comment newComment = commentRepository.save(comment);
        CommentDTO commentResponse = mapToDTO(newComment);

        return commentResponse;
    }

    @Override
    public List<CommentDTO> getAllComments() {
        return null;
    }

    @Override
    public CommentDTO updateComment(long id) {
        return null;
    }

    @Override
    public void deleteComment(CommentDTO commentDTO) {

    }

    private Comment mapToEntity(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setComment(commentDTO.getComment());
        comment.setName(commentDTO.getName());
        comment.setEmail(comment.getEmail());
        return comment;
    }

    private CommentDTO mapToDTO(Comment comment){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setComment(comment.getComment());
        commentDTO.setName(comment.getName());
        commentDTO.setEmail(comment.getEmail());
        return commentDTO;
    }
}
