package com.example.demo.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "user_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String fullName;

    @Column(name = "username", unique = true)
    private String accountName;

    @Column(name = "email", length = 40, unique = true)
    private String email;

    private String mobile;

    private String password;

    private String avatar_url;

    private String mailToken;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String note;

    @ManyToMany
    @JoinTable(name = "user_roles_tbl", joinColumns = @JoinColumn(name = "user_Id"), inverseJoinColumns = @JoinColumn(name = "role_Id"))
    private Set<Setting> settings;

    @OneToMany(mappedBy = "staff")
    private List<WebContact> webContacts;

    @OneToMany(mappedBy = "manager")
    private List<Subject> managedSubject;

    @OneToMany(mappedBy = "expert")
    private List<Subject> expertSubject;

    @OneToMany(mappedBy = "userTrainer")
    private List<Classes> classes;

    @OneToMany(mappedBy = "userSupporter")
    private List<Classes> classList;

    @OneToMany(mappedBy = "user")
    private List<ClassUser> classUsers;

}
