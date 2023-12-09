package com.springboot.blog.payload;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String messaage;
    private String details;

    public ErrorDetails(Date timestamp, String messaage, String details) {
        this.timestamp = timestamp;
        this.messaage = messaage;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessaage() {
        return messaage;
    }

    public String getDetails() {
        return details;
    }
}
