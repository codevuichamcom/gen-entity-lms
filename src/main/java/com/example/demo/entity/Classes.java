package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.enums.ClassStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "class_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;

    private String code;

    @Enumerated(EnumType.STRING)
    private ClassStatus status;

    private String description;

    @ManyToMany
    @JoinTable(name = "class_subject_tbl", joinColumns = @JoinColumn(name = "class_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects;

    @ManyToOne
    @JoinColumn(name = "setting_term")
    private Setting settingTerm;

    @ManyToOne
    @JoinColumn(name = "settting_branch")
    private Setting settingBranch;

    @ManyToOne
    @JoinColumn(name = "user_trainer")
    private User userTrainer;

    @ManyToOne
    @JoinColumn(name = "user_supporter")
    private User userSupporter;

    @OneToMany(mappedBy = "classes")
    private List<ClassUser> classUsers;

}
