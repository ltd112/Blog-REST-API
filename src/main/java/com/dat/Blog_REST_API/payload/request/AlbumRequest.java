package com.dat.Blog_REST_API.payload.request;

import com.dat.Blog_REST_API.model.Photo;
import com.dat.Blog_REST_API.model.user.User;
import com.dat.Blog_REST_API.payload.UserDateAuditPayload;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class AlbumRequest extends UserDateAuditPayload {
    private Long id;
    private String title;
    private User user;
    private List<Photo> photo;

    public List<Photo> getPhotos(){
        return this.photo == null ? null : new ArrayList<>(photo);
    }

    public void setPhoto(List<Photo> photo){
        if(photo == null)
            this.photo = null;
        else{
            this.photo = Collections.unmodifiableList(photo);
        }
    }
}
