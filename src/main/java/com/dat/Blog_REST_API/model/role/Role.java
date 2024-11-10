package com.dat.Blog_REST_API.model.role;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated
    @NaturalId
    @Column(name = "name")
    private RoleName name;


    public Role(RoleName name){
        this.name = name;
    }
}
