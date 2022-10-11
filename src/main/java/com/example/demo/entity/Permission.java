package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.example.demo.compositekey.PermissionKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "permission_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Permission {

    @EmbeddedId
    private PermissionKey permissionId;

    @Column(name = "get_all_data")
    private boolean canGetAll;

    private boolean canDelete;

    private boolean canAdd;

    private boolean canEdit;

    @ManyToOne()
    @MapsId("screenId")
    @JoinColumn(name = "screen_id")
    private Setting screen;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @MapsId("roleId")
    private Setting role;

}
