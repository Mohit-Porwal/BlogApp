package com.springboot.blog.payload;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

//The @Data annotation, automatically generates the getters and setters, the to String and hashcode methods, and helps to reduce all the boilerplate code.
@Data
public class PostDTO {
    @Id
    private long id;

    //title should not be null or empty
    //title should have at least two characters
    @NotEmpty
    @Size(min=2, message="Post title should have at least two characters")
    private String title;

    //post description should not be null or empty
    //should have at least 10 characters
    @NotEmpty
    @Size(min=10, message = "Post description should have at least ten characters")
    private String description;

    @NotEmpty
    private String content;
    private Set<CommentDTO> comments;
}

