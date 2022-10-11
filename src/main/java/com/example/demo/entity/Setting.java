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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "setting_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Setting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long settingId;

    private String settingTitle;

    @Column(name = "setting_value", unique = true)
    private String settingValue;

    private String displayOrder;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String description;

    @ManyToMany(mappedBy = "settings")
    private Set<User> users;

    @OneToMany(mappedBy = "category")
    private List<WebContact> webContacts;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Setting screen;

    @OneToMany(mappedBy = "screen")
    private List<Setting> apis;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Setting type;

    @OneToMany(mappedBy = "type")
    private List<Setting> settings;

    @OneToMany(mappedBy = "settingTerm")
    private List<Classes> classesTerm;

    @OneToMany(mappedBy = "settingBranch")
    private List<Classes> classesBranch;

    @OneToMany(mappedBy = "screen")
    private List<Permission> roles;

    @OneToMany(mappedBy = "role")
    private List<Permission> screens;
}