package com.dat.Blog_REST_API.model;

import com.dat.Blog_REST_API.model.audit.UserDateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "tags")
public class Tag extends UserDateAudit {
    private static final long serialVersionUID = -5298707266367331514L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"))
    private List<Post> posts;

    public Tag(String name){
        this.name = name;
    }

    public List<Post> getPosts(){
        return posts == null ? null : new ArrayList<>(posts);
    }

    public void setPosts(List<Post> posts){
        if(posts == null)
            this.posts = null;
        else
            this.posts = Collections.unmodifiableList(posts);
    }

}
