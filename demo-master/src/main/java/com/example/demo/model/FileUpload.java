package com.example.demo.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class FileUpload {
    AchievementTable achievementTable;
    List<MultipartFile> files;
    public AchievementTable getAchievementTable() {
        return achievementTable;
    }
    public void setAchievementTable(AchievementTable achievementTable) {
        this.achievementTable = achievementTable;
    }
    public List<MultipartFile> getFiles() {
        return files;
    }
    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    
}
