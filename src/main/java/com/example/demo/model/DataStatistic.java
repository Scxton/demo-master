package com.example.demo.model;

import java.util.Date;

public class DataStatistic {
    private Integer statisticId;
    private String userName;
    private Integer downloadCount;
    private Integer averageRating;
    private Integer userId;
    //private Date statisticTime;
    private Boolean tableStatus;
    private String logInTime;
    private String logOutTime;
    private String duration;
    private Integer achievementId;


    public Integer getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(Integer statisticId) {
        this.statisticId = statisticId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Integer getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Integer averageRating) {
        this.averageRating = averageRating;
    }
    //    public Date getStatisticTime() {
//        return statisticTime;
//    }
//
//    public void setStatisticTime(Date statisticTime) {
//        this.statisticTime = statisticTime;
//    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public String getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(String logInTime) {
        this.logInTime = logInTime;
    }

    public String getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime(String logOutTime) {
        this.logOutTime = logOutTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getAchievementId() {
        return achievementId;
    }
    public void setAchievementId(Integer achievementId) {}
}
