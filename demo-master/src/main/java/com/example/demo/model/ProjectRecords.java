package com.example.demo.model;

import java.io.Serializable;

/**
 * (ProjectRecords)实体类
 *
 * @author makejava
 * @since 2025-03-21 13:43:57
 */
public class ProjectRecords implements Serializable {
    private static final long serialVersionUID = -46306719424202308L;

    private Integer projectId;

    private Integer achievementId;

    private String projectName;

    private Integer organizationId;

    private String projectIntro;

    private Boolean tableStatus;


    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getProjectIntro() {
        return projectIntro;
    }

    public void setProjectIntro(String projectIntro) {
        this.projectIntro = projectIntro;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

}

