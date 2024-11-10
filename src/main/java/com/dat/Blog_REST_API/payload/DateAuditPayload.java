package com.dat.Blog_REST_API.payload;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public abstract class DateAuditPayload {
    private Instant createdAt;
    private Instant updateAt;

}
