package com.dat.Blog_REST_API.model.user;

import com.dat.Blog_REST_API.model.Album;
import com.dat.Blog_REST_API.model.Comment;
import com.dat.Blog_REST_API.model.Post;
import com.dat.Blog_REST_API.model.Todo;
import com.dat.Blog_REST_API.model.audit.DateAudit;
import com.dat.Blog_REST_API.model.role.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}),@UniqueConstraint(columnNames = {"email"}) })
public class User extends DateAudit {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    @Size(max = 40)
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    @Size(max = 40)
    private String lastName;

    @NotBlank
    @Column(name = "user_name")
    @Size(max = 15)
    private String userName;

    @NotBlank
    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(max = 100)
    private String password;


    @NotBlank
    @NaturalId
    @Size(max = 40)
    @Column(name = "email")
    @Email
    private String email;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    private String phone;
    private String website;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Todo> todos;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Album> albums;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "company_id")
    private Company company;

    public User(String firstName, String lastName, String userName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public List<Todo> getTodos(){
        return todos == null ? null : new ArrayList<>(todos);
    }

    public void setTodos(List<Todo> todos){
        if(todos == null)
            this.todos = null;
        else{
            this.todos = Collections.unmodifiableList(todos);
        }
    }

    public List<Album> getAlbums(){
        return albums == null ? null : new ArrayList<>(albums);
    }

    public void setAlbums(List<Album> albums){
        if(albums == null)
            this.albums = null;
        else {
            this.albums = Collections.unmodifiableList(albums);
        }
    }
    public List<Post> getPosts(){
        return posts == null ? null : new ArrayList<>(posts);
    }

    public void setPosts(List<Post>  posts){
        if(posts == null)
            this.posts = null;
        else {
            this.posts = Collections.unmodifiableList(posts);
        }
    }
    public List<Role> getRoles(){
        return roles == null ? null : new ArrayList<>(roles);
    }

    public void setRoles(List<Role> roles){
        if(roles == null)
            this.roles = null;
        else {
            this.roles = Collections.unmodifiableList(roles);
        }
    }


}
