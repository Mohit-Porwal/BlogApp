package com.springboot.blog.payload;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CommentDTO {
    @Id
    private long id;
    private String name;
    private String email;
    private String comment;
}
