package com.example.demo.model;

import java.io.Serializable;

/**
 * (InteractionEvaluation)实体类
 *
 * @author makejava
 * @since 2024-12-12 15:59:55
 */
public class InteractionEvaluation implements Serializable {
    private static final long serialVersionUID = 703953981369008789L;

    private Integer interactionId;

    private Integer achievementId;

    private Integer userId;

    private Integer rating;

    private String evaluation;

    private String interactionTime;

    private Boolean tableStatus;


    public Integer getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(Integer interactionId) {
        this.interactionId = interactionId;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getInteractionTime() {
        return interactionTime;
    }

    public void setInteractionTime(String interactionTime) {
        this.interactionTime = interactionTime;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

}

