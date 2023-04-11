package com.ruoyi.community.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 住户信息对象 residents
 *
 * @author yanghua
 * @date 2023-04-08
 */
public class Residents extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 住户id
     */
    private Integer residentsId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 楼号
     */
    @Excel(name = "楼号")
    private String buildingNumber;

    /**
     * 单元号
     */
    @Excel(name = "单元号")
    private Long unitNumber;

    /**
     * 房屋面积
     */
    @Excel(name = "房屋面积")
    private String area;

    /**
     * 居住地址
     */
    @Excel(name = "居住地址")
    private String address;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remarks;

    /**
     * 0正常1停用
     */
    @Excel(name = "0正常1停用")
    private Long status;

    private SysUser sysUser;
    /**
     * 0表示存在2表示删除
     */
    private String delFlag;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public Integer getResidentsId() {
        return residentsId;
    }

    public void setResidentsId(Integer residentsId) {
        this.residentsId = residentsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Long getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(Long unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
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
                .append("residentsId", getResidentsId())
                .append("userId", getUserId())
                .append("buildingNumber", getBuildingNumber())
                .append("unitNumber", getUnitNumber())
                .append("area", getArea())
                .append("address", getAddress())
                .append("remarks", getRemarks())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("sysUser", getSysUser())
                .toString();
    }
}
