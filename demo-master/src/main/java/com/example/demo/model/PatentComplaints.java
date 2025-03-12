package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public class PatentComplaints {
    private Integer complaintId;
    private Integer intellectualPropertyId;
    private String complaintTime;
    private Integer userId;

    //private ComplaintProcessStatus complaintProcess;
    private Integer complaintProcess;
    private String complaintType;
    private String  complaintIntro;
    private Boolean tableStatus;;

//    public enum complaintProcessStatus{
//        NOT_ACCEPTED("未受理"),
//        IN_PROGRESS("受理中"),
//        ACCEPTED("已受理");
//
//        private final String description;
//
//        complaintProcessStatus(String description) {
//            this.description = description;
//        }
//
//        @JsonValue  // 确保 JSON 传输字符串
//        public String getDescription() {
//            return description;
//        }
//    }

//    public enum ComplaintProcessStatus {
//        NOT_ACCEPTED(0, "未受理"),
//        IN_PROGRESS(1, "受理中"),
//        ACCEPTED(2, "已受理");
//
//        private final int code;
//        private final String description;
//
//        ComplaintProcessStatus(int code, String description) {
//            this.code = code;
//            this.description = description;
//        }
//
//        @JsonValue  // 确保 JSON 传输整数
//        public int getCode() {
//            return code;
//        }
//
//        public String getDescription() {
//            return description;
//        }
//
//        // 通过整数获取枚举
//        @JsonCreator
//        public static ComplaintProcessStatus fromCode(int code) {
//            for (ComplaintProcessStatus status : ComplaintProcessStatus.values()) {
//                if (status.code == code) {
//                    return status;
//                }
//            }
//            throw new IllegalArgumentException("未知的投诉状态: " + code);
//        }
//    }


    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public Integer getintellectualPropertyId() {
        return intellectualPropertyId;
    }

    public void setintellectualPropertyId(Integer intellectualPropertyId) {
        this.intellectualPropertyId = intellectualPropertyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getComplaintIntro() {
        return complaintIntro;
    }

    public void setComplaintIntro(String complaintIntro) {
        this.complaintIntro = complaintIntro;
    }

//    public ComplaintProcessStatus getComplaintProcess() {
//        return complaintProcess;
//    }

//    public void setComplaintProcess(ComplaintProcessStatus complaintProcess) {
//        this.complaintProcess = complaintProcess;
//    }

    public String getComplaintTime() {
        return complaintTime;
    }

    public void setComplaintTime(String complaintTime) {
        this.complaintTime = complaintTime;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public Integer getComplaintProcess() {
        return complaintProcess;
    }

    public void setComplaintProcess(Integer complaintProcess) {
        this.complaintProcess = complaintProcess;
    }
}