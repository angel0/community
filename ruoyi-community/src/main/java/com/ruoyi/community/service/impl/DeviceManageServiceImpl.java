package com.ruoyi.community.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.community.domain.DeviceManage;
import com.ruoyi.community.mapper.DeviceManageMapper;
import com.ruoyi.community.service.IDeviceManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设备设施管理Service业务层处理
 *
 * @author yanghua
 * @date 2023-04-25
 */
@Service
public class DeviceManageServiceImpl implements IDeviceManageService {
    @Autowired
    private DeviceManageMapper deviceManageMapper;

    /**
     * 查询设备设施管理
     *
     * @param deviceId 设备设施管理主键
     * @return 设备设施管理
     */
    @Override
    public DeviceManage selectDeviceManageByDeviceId(Long deviceId) {
        return deviceManageMapper.selectDeviceManageByDeviceId(deviceId);
    }

    /**
     * 查询设备设施管理列表
     *
     * @param deviceManage 设备设施管理
     * @return 设备设施管理
     */
    @Override
    public List<DeviceManage> selectDeviceManageList(DeviceManage deviceManage) {
        return deviceManageMapper.selectDeviceManageList(deviceManage);
    }

    /**
     * 新增设备设施管理
     *
     * @param deviceManage 设备设施管理
     * @return 结果
     */
    @Override
    public int insertDeviceManage(DeviceManage deviceManage) {
        deviceManage.setCreateTime(DateUtils.getNowDate());
        return deviceManageMapper.insertDeviceManage(deviceManage);
    }

    /**
     * 修改设备设施管理
     *
     * @param deviceManage 设备设施管理
     * @return 结果
     */
    @Override
    public int updateDeviceManage(DeviceManage deviceManage) {
        deviceManage.setUpdateTime(DateUtils.getNowDate());
        return deviceManageMapper.updateDeviceManage(deviceManage);
    }

    /**
     * 批量删除设备设施管理
     *
     * @param deviceIds 需要删除的设备设施管理主键
     * @return 结果
     */
    @Override
    public int deleteDeviceManageByDeviceIds(Long[] deviceIds) {
        return deviceManageMapper.deleteDeviceManageByDeviceIds(deviceIds);
    }

    /**
     * 删除设备设施管理信息
     *
     * @param deviceId 设备设施管理主键
     * @return 结果
     */
    @Override
    public int deleteDeviceManageByDeviceId(Long deviceId) {
        return deviceManageMapper.deleteDeviceManageByDeviceId(deviceId);
    }
}
