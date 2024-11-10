package com.dat.Blog_REST_API.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentRequest {
    @NotBlank
    @Size(min = 10, message = "Comment must be at least 10 characters long")
    private String body;
}
