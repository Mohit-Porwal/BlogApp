package com.springboot.blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name="post",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {

    @Id
    private long id;
    private String title;
    private String description;
    private String content;
}
