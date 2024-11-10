package com.dat.Blog_REST_API.payload;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class UserDateAuditPayload extends DateAuditPayload{
    private Long createdBy;
    private Long updatedBy;
}
