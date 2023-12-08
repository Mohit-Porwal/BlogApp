package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.BlogAPIException;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.CommentDTO;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
    public List<CommentDTO> getCommentsByPostId(long postId) {
        //retrieve comments by post id
        List<Comment> comments = commentRepository.findByPostId(postId);

        //convert list of comment entities to list of comment dtos
        return comments.stream().map(comment->mapToDTO(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDTO getCommentByCommentId(long postId, long commentId) {
        // retrieve post entity by id
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId));

        // retrieve comment by id
        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFoundException("Comment", "id", commentId));

        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        return mapToDTO(comment);
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
        comment.setEmail(commentDTO.getEmail());
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
