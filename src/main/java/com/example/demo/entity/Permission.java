package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.compositeKey.PermissionKey;

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

}
