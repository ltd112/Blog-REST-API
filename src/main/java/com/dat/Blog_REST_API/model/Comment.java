package com.dat.Blog_REST_API.model;

import com.dat.Blog_REST_API.model.audit.UserDateAudit;
import com.dat.Blog_REST_API.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "comments")
public class Comment extends UserDateAudit {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotBlank
    @Size(min = 4, max = 50)
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(@NotBlank @Size(min = 10) String body){
        this.body = body;
    }

    @JsonIgnore
    public Post getPost(){
        return post;
    }

    @JsonIgnore
    public User getUser(){
        return user;
    }


}

