package com.ruoyi.community.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车位信息对象 parking_spaces
 *
 * @author yanghua
 * @date 2023-04-11
 */
public class ParkingSpaces extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer parkId;

    /**
     * 车位ID
     */
    @Excel(name = "车位ID")
    private String parkingSpaceId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 车位号
     */
    @Excel(name = "车位号")
    private String parkingSpaceNumber;

    /**
     * 是否停用
     */
    @Excel(name = "是否停用")
    private Long status;

    /**
     * 是否租用
     */
    @Excel(name = "是否租用")
    private String rent;
    private SysUser sysUser;

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public String getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(String parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    public void setParkingSpaceNumber(String parkingSpaceNumber) {
        this.parkingSpaceNumber = parkingSpaceNumber;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("parkId", getParkId())
                .append("parkingSpaceId", getParkingSpaceId())
                .append("userId", getUserId())
                .append("parkingSpaceNumber", getParkingSpaceNumber())
                .append("status", getStatus())
                .append("rent", getRent())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("sysUser", getSysUser())
                .toString();
    }
}
