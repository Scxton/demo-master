package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

public class SearchBody implements Serializable{
    private static final long serialVersionUID = 151695669809L;
    private List<String> achievementCategories;

    private List<String> achievementForms;

    private List<Integer> intellectualPropertyIds;

    private List<Integer> achievementBelongingOrganizations;

    private List<Integer> projectIds;

    private List<Integer> userIds;

    private String startTime;

    private String endTime;

    private List<Integer> templateIds;

    private List<String> keywords;

    private Integer pageNum;

    private Integer pageSize;

    private List<String> subjectCategorys;

    private List<String> technologyCategorys;

    public List<String> getSubjectCategorys() {
        return subjectCategorys;
    }

    public void setSubjectCategorys(List<String> subjectCategorys) {
        this.subjectCategorys = subjectCategorys;
    }

    public List<String> getTechnologyCategorys() {
        return technologyCategorys;
    }

    public void setTechnologyCategorys(List<String> technologyCategorys) {
        this.technologyCategorys = technologyCategorys;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public List<String> getAchievementCategories() {
        return achievementCategories;
    }

    public void setAchievementCategories(List<String> achievementCategories) {
        this.achievementCategories = achievementCategories;
    }

    public List<String> getAchievementForms() {
        return achievementForms;
    }

    public void setAchievementForms(List<String> achievementForms) {
        this.achievementForms = achievementForms;
    }

    public List<Integer> getIntellectualPropertyIds() {
        return intellectualPropertyIds;
    }

    public void setIntellectualPropertyIds(List<Integer> intellectualPropertyIds) {
        this.intellectualPropertyIds = intellectualPropertyIds;
    }

    public List<Integer> getAchievementBelongingOrganizations() {
        return achievementBelongingOrganizations;
    }

    public void setAchievementBelongingOrganizations(List<Integer> achievementBelongingOrganizations) {
        this.achievementBelongingOrganizations = achievementBelongingOrganizations;
    }

    public List<Integer> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(List<Integer> projectIds) {
        this.projectIds = projectIds;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<Integer> getTemplateIds() {
        return templateIds;
    }

    public void setTemplateIds(List<Integer> templateIds) {
        this.templateIds = templateIds;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }




}
