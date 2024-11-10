package com.dat.Blog_REST_API.payload.response;

import com.dat.Blog_REST_API.model.Photo;
import com.dat.Blog_REST_API.model.user.User;
import com.dat.Blog_REST_API.payload.UserDateAuditPayload;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlbumResponse extends UserDateAuditPayload {
    private Long id;
    private String title;

    private User user;
    private List<Photo> photo;

    public List<Photo> getPhoto() {
        return photo  == null ? null : new ArrayList<>(photo);
    }

    void setPhoto(List<Photo> photo){
        if(photo == null)
            this.photo = null;
        else{
            this.photo = Collections.unmodifiableList(photo);
        }
    }

}
