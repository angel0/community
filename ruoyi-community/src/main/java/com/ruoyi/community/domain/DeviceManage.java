package com.ruoyi.community.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 设备设施管理对象 device_manage
 *
 * @author yanghua
 * @date 2023-04-25
 */
public class DeviceManage extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Long deviceId;

    /**
     * 设备设施名称
     */
    @Excel(name = "设备设施名称")
    private String deviceName;

    /**
     * 设备设施编号
     */
    @Excel(name = "设备设施编号")
    private String deviceNo;

    /**
     * 设备设施类型
     */
    @Excel(name = "设备设施类型")
    private String deviceType;

    /**
     * 设备设施状态
     */
    @Excel(name = "设备设施状态")
    private String deviceState;

    /**
     * 设备设施位置
     */
    @Excel(name = "设备设施位置")
    private String deviceLocation;

    /**
     * 设备设施责任人
     */
    @Excel(name = "设备设施责任人")
    private String deviceUser;

    /**
     * 设备设施购买时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "设备设施购买时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deviceBuyTime;

    /**
     * 设备设施保修期限
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "设备设施保修期限", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deviceWarrantyPeriod;

    /**
     * 设备设施维护记录
     */
    @Excel(name = "设备设施维护记录")
    private String deviceMaintainRecords;

    /**
     * 设备设施使用说明书
     */
    @Excel(name = "设备设施使用说明书")
    private String deviceUseDesc;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(String deviceState) {
        this.deviceState = deviceState;
    }

    public String getDeviceLocation() {
        return deviceLocation;
    }

    public void setDeviceLocation(String deviceLocation) {
        this.deviceLocation = deviceLocation;
    }

    public String getDeviceUser() {
        return deviceUser;
    }

    public void setDeviceUser(String deviceUser) {
        this.deviceUser = deviceUser;
    }

    public Date getDeviceBuyTime() {
        return deviceBuyTime;
    }

    public void setDeviceBuyTime(Date deviceBuyTime) {
        this.deviceBuyTime = deviceBuyTime;
    }

    public Date getDeviceWarrantyPeriod() {
        return deviceWarrantyPeriod;
    }

    public void setDeviceWarrantyPeriod(Date deviceWarrantyPeriod) {
        this.deviceWarrantyPeriod = deviceWarrantyPeriod;
    }

    public String getDeviceMaintainRecords() {
        return deviceMaintainRecords;
    }

    public void setDeviceMaintainRecords(String deviceMaintainRecords) {
        this.deviceMaintainRecords = deviceMaintainRecords;
    }

    public String getDeviceUseDesc() {
        return deviceUseDesc;
    }

    public void setDeviceUseDesc(String deviceUseDesc) {
        this.deviceUseDesc = deviceUseDesc;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("deviceId", getDeviceId())
                .append("deviceName", getDeviceName())
                .append("deviceNo", getDeviceNo())
                .append("deviceType", getDeviceType())
                .append("deviceState", getDeviceState())
                .append("deviceLocation", getDeviceLocation())
                .append("deviceUser", getDeviceUser())
                .append("deviceBuyTime", getDeviceBuyTime())
                .append("deviceWarrantyPeriod", getDeviceWarrantyPeriod())
                .append("deviceMaintainRecords", getDeviceMaintainRecords())
                .append("deviceUseDesc", getDeviceUseDesc())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
