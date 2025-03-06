package com.example.demo.model;

import java.io.Serializable;

/**
 * (FileRecord)实体类
 *
 * @author makejava
 * @since 2024-12-12 15:58:28
 */
public class FileRecord implements Serializable {
    private static final long serialVersionUID = 286604442700871621L;

    private Integer fileId;

    private Integer achievementId;

    private String fileName;

    private String uploadTime;

    private Boolean tableStatus;

    private Integer projectId;

    private Integer userId;


    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}

