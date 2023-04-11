package com.ruoyi.community.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.community.domain.ParkingSpaces;
import com.ruoyi.community.mapper.ParkingSpacesMapper;
import com.ruoyi.community.service.IParkingSpacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 车位信息Service业务层处理
 *
 * @author yanghua
 * @date 2023-04-11
 */
@Service
public class ParkingSpacesServiceImpl implements IParkingSpacesService {
    @Autowired
    private ParkingSpacesMapper parkingSpacesMapper;

    /**
     * 查询车位信息
     *
     * @param parkId 车位信息主键
     * @return 车位信息
     */
    @Override
    public ParkingSpaces selectParkingSpacesByParkId(Integer parkId) {
        return parkingSpacesMapper.selectParkingSpacesByParkId(parkId);
    }

    /**
     * 查询车位信息列表
     *
     * @param parkingSpaces 车位信息
     * @return 车位信息
     */
    @Override
    public List<ParkingSpaces> selectParkingSpacesList(ParkingSpaces parkingSpaces) {
        return parkingSpacesMapper.selectParkingSpacesList(parkingSpaces);
    }

    /**
     * 新增车位信息
     *
     * @param parkingSpaces 车位信息
     * @return 结果
     */
    @Override
    public int insertParkingSpaces(ParkingSpaces parkingSpaces) {
        parkingSpaces.setCreateTime(DateUtils.getNowDate());
        return parkingSpacesMapper.insertParkingSpaces(parkingSpaces);
    }

    /**
     * 修改车位信息
     *
     * @param parkingSpaces 车位信息
     * @return 结果
     */
    @Override
    public int updateParkingSpaces(ParkingSpaces parkingSpaces) {
        parkingSpaces.setUpdateTime(DateUtils.getNowDate());
        return parkingSpacesMapper.updateParkingSpaces(parkingSpaces);
    }

    /**
     * 批量删除车位信息
     *
     * @param parkIds 需要删除的车位信息主键
     * @return 结果
     */
    @Override
    public int deleteParkingSpacesByParkIds(Integer[] parkIds) {
        return parkingSpacesMapper.deleteParkingSpacesByParkIds(parkIds);
    }

    /**
     * 删除车位信息信息
     *
     * @param parkId 车位信息主键
     * @return 结果
     */
    @Override
    public int deleteParkingSpacesByParkId(Integer parkId) {
        return parkingSpacesMapper.deleteParkingSpacesByParkId(parkId);
    }
}
