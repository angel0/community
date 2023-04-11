package com.ruoyi.community.service;

import com.ruoyi.community.domain.Residents;

import java.util.List;

/**
 * 住户信息Service接口
 *
 * @author yanghua
 * @date 2023-04-08
 */
public interface IResidentsService {
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
     * 批量删除住户信息
     *
     * @param residentsIds 需要删除的住户信息主键集合
     * @return 结果
     */
    public int deleteResidentsByResidentsIds(Integer[] residentsIds);

    /**
     * 删除住户信息信息
     *
     * @param residentsId 住户信息主键
     * @return 结果
     */
    public int deleteResidentsByResidentsId(Integer residentsId);
}
