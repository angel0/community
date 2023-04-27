package com.ruoyi.community.mapper;

import com.ruoyi.community.domain.DeviceManage;

import java.util.List;

/**
 * 设备设施管理Mapper接口
 *
 * @author yanghua
 * @date 2023-04-25
 */
public interface DeviceManageMapper {
    /**
     * 查询设备设施管理
     *
     * @param deviceId 设备设施管理主键
     * @return 设备设施管理
     */
    public DeviceManage selectDeviceManageByDeviceId(Long deviceId);

    /**
     * 查询设备设施管理列表
     *
     * @param deviceManage 设备设施管理
     * @return 设备设施管理集合
     */
    public List<DeviceManage> selectDeviceManageList(DeviceManage deviceManage);

    /**
     * 新增设备设施管理
     *
     * @param deviceManage 设备设施管理
     * @return 结果
     */
    public int insertDeviceManage(DeviceManage deviceManage);

    /**
     * 修改设备设施管理
     *
     * @param deviceManage 设备设施管理
     * @return 结果
     */
    public int updateDeviceManage(DeviceManage deviceManage);

    /**
     * 删除设备设施管理
     *
     * @param deviceId 设备设施管理主键
     * @return 结果
     */
    public int deleteDeviceManageByDeviceId(Long deviceId);

    /**
     * 批量删除设备设施管理
     *
     * @param deviceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeviceManageByDeviceIds(Long[] deviceIds);
}
