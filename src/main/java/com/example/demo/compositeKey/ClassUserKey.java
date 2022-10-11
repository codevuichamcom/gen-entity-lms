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
public class ClassUserKey implements Serializable {
    @Column(name = "class_id")
    private Long classId;

    @Column(name = "user_id")
    private Long userId;
}
