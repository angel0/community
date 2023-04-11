package com.ruoyi.community.mapper;

import com.ruoyi.community.domain.Residents;

import java.util.List;

/**
 * 住户信息Mapper接口
 *
 * @author yanghua
 * @date 2023-04-08
 */
public interface ResidentsMapper {
    /**
     * 查询住户信息
     *
     * @param residentsId 住户信息主键
     * @return 住户信息
     */
    public Residents selectResidentsByResidentsId(Integer residentsId);

    /**
     * 查询住户信息列表
     *
     * @param residents 住户信息
     * @return 住户信息集合
     */
    public List<Residents> selectResidentsList(Residents residents);

    /**
     * 新增住户信息
     *
     * @param residents 住户信息
     * @return 结果
     */
    public int insertResidents(Residents residents);

    /**
     * 修改住户信息
     *
     * @param residents 住户信息
     * @return 结果
     */
    public int updateResidents(Residents residents);

    /**
     * 删除住户信息
     *
     * @param residentsId 住户信息主键
     * @return 结果
     */
    public int deleteResidentsByResidentsId(Integer residentsId);

    /**
     * 批量删除住户信息
     *
     * @param residentsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteResidentsByResidentsIds(Integer[] residentsIds);
}
