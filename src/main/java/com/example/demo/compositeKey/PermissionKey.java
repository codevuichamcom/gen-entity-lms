package com.example.demo.compositeKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PermissionKey implements Serializable {
    @Column(name = "screen_id")
    Long screenId;

    @Column(name = "role_id")
    Long roleId;

}
