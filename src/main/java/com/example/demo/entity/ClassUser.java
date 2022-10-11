package com.example.demo.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.example.demo.compositeKey.ClassUserKey;
import com.example.demo.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "class_user_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ClassUser {

    @EmbeddedId
    private ClassUserKey id;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String note;

    private Date dropoutDate;

    private String ongoingEval;

    private String finalEval;

    private String topicEval;

}
