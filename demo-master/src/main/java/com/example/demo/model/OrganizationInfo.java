package com.example.demo.model;

import java.io.Serializable;

/**
 * (OrganizationInfo)实体类
 *
 * @author makejava
 * @since 2024-12-11 15:56:07
 */
public class OrganizationInfo implements Serializable {
    private static final long serialVersionUID = -91229959997852511L;

    private Integer organizationId;

    private String organizationName;

    private Integer organizationProjectCount;

    private Integer organizationProjectTotalCount;

    private Boolean tableStatus;
    // 单位地址  单位电话  联系人 联系人电话
    private String organizationAddress;
    private String organizationPhone;
    private String contactsName;
    private String contactsPhone;


    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Integer getOrganizationProjectCount() {
        return organizationProjectCount;
    }

    public void setOrganizationProjectCount(Integer organizationProjectCount) {
        this.organizationProjectCount = organizationProjectCount;
    }

    public Integer getOrganizationProjectTotalCount() {
        return organizationProjectTotalCount;
    }

    public void setOrganizationProjectTotalCount(Integer organizationProjectTotalCount) {
        this.organizationProjectTotalCount = organizationProjectTotalCount;
    }

    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }
    public String getOrganizationAddress() {
        return organizationAddress;
    }
    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }
    public String getOrganizationPhone() {
        return organizationPhone;
    }
    public void setOrganizationPhone(String organizationPhone) {
        this.organizationPhone = organizationPhone;
    }
    public String getContactsName() {
        return contactsName;
    }
    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }
    public String getContactsPhone() {
        return contactsPhone;
    }
    public void setContactsPhone(String contactsPhone) {
        this.contactsPhone = contactsPhone;
    }

}

