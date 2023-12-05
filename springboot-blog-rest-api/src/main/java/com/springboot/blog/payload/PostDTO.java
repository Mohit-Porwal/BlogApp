package com.springboot.blog.payload;

import jakarta.persistence.Id;
import lombok.Data;

//The @Data annotation, automatically generates the getters and setters, the to String and hashcode methods, and helps to reduce all the boilerplate code.
@Data
public class PostDTO {
    @Id
    private long id;
    private String title;
    private String description;
    private String content;
}

