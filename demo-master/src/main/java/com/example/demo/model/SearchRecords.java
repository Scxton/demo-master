package com.example.demo.model;

import java.io.Serializable;

/**
 * (SearchRecords)实体类
 *
 * @author makejava
 * @since 2024-12-12 15:58:45
 */
public class SearchRecords implements Serializable {
    private static final long serialVersionUID = -92189407764056351L;

    private Integer searchId;

    private Integer userId;

    private String searchContent;

    private String searchTime;

    private Integer searchMethod;

    private Boolean tableStatus;


    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public String getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(String searchTime) {
        this.searchTime = searchTime;
    }

    public Integer getSearchMethod() {
        return searchMethod;
    }

    public void setSearchMethod(Integer searchMethod) {
        this.searchMethod = searchMethod;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

}

