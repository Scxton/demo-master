package com.example.demo.model;

import java.io.Serializable;

/**
 * (RoleTable)实体类
 *
 * @author makejava
 * @since 2024-12-06 16:11:03
 */
public class RoleTable implements Serializable {
    private static final long serialVersionUID = 300593593836845787L;

    private Integer roleId;

    private String roleName;

    private Boolean tableStatus;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

}

