package com.example.demo.model;

import java.util.Date;
import java.io.Serializable;

/**
 * (LogRecords)实体类
 *
 * @author makejava
 * @since 2024-12-09 14:50:57
 */
public class LogRecords implements Serializable {
    private static final long serialVersionUID = 438368707017587961L;

    private Integer logId;

    private Integer userId;

    private String logIntro;

    private Date logTime;

    private Boolean tableStatus;


    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogIntro() {
        return logIntro;
    }

    public void setLogIntro(String logIntro) {
        this.logIntro = logIntro;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

}

