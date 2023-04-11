package com.ruoyi.community.mapper;

import com.ruoyi.community.domain.ParkingSpaces;

import java.util.List;

/**
 * 车位信息Mapper接口
 *
 * @author yanghua
 * @date 2023-04-11
 */
public interface ParkingSpacesMapper {
    /**
     * 查询车位信息
     *
     * @param parkId 车位信息主键
     * @return 车位信息
     */
    public ParkingSpaces selectParkingSpacesByParkId(Integer parkId);

    /**
     * 查询车位信息列表
     *
     * @param parkingSpaces 车位信息
     * @return 车位信息集合
     */
    public List<ParkingSpaces> selectParkingSpacesList(ParkingSpaces parkingSpaces);

    /**
     * 新增车位信息
     *
     * @param parkingSpaces 车位信息
     * @return 结果
     */
    public int insertParkingSpaces(ParkingSpaces parkingSpaces);

    /**
     * 修改车位信息
     *
     * @param parkingSpaces 车位信息
     * @return 结果
     */
    public int updateParkingSpaces(ParkingSpaces parkingSpaces);

    /**
     * 删除车位信息
     *
     * @param parkId 车位信息主键
     * @return 结果
     */
    public int deleteParkingSpacesByParkId(Integer parkId);

    /**
     * 批量删除车位信息
     *
     * @param parkIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteParkingSpacesByParkIds(Integer[] parkIds);
}
