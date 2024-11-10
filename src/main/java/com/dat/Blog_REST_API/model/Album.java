package com.dat.Blog_REST_API.model;

import com.dat.Blog_REST_API.model.audit.UserDateAudit;
import com.dat.Blog_REST_API.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "albums", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"}) })
public class Album  extends UserDateAudit {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Photo> photos;

    @JsonIgnore
    public User getUser(){
        return user;
    }

    public List<Photo> getPhoto(){
        return this.photos == null ? null: new ArrayList<>(this.photos);
    }

    public void setPhoto(List<Photo> photo){
        if(photo == null)
            this.photos = null;
        else
            this.photos = Collections.unmodifiableList(photo);
    }

}
