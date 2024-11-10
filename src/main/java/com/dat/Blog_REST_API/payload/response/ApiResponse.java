package com.dat.Blog_REST_API.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonPropertyOrder({
        "success",
        "message"
})
public class ApiResponse implements Serializable {

    @Serial
    @JsonIgnore
    private static final long serialVersionUID = 7702134516418120340L;

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("message")
    private String message;

    @JsonIgnore
    private HttpStatus status;

    public ApiResponse(){

    }

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(Boolean success, HttpStatus status, String message) {
        this.success = success;
        this.status = status;
        this.message = message;
    }
}
