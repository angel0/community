package com.ruoyi.community.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.community.domain.Residents;
import com.ruoyi.community.mapper.ResidentsMapper;
import com.ruoyi.community.service.IResidentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 住户信息Service业务层处理
 *
 * @author yanghua
 * @date 2023-04-08
 */
@Service
public class ResidentsServiceImpl implements IResidentsService {
    @Autowired
    private ResidentsMapper residentsMapper;

    /**
     * 查询住户信息
     *
     * @param residentsId 住户信息主键
     * @return 住户信息
     */
    @Override
    public Residents selectResidentsByResidentsId(Integer residentsId) {
        return residentsMapper.selectResidentsByResidentsId(residentsId);
    }

    /**
     * 查询住户信息列表
     *
     * @param residents 住户信息
     * @return 住户信息
     */
    @Override
    public List<Residents> selectResidentsList(Residents residents) {
        return residentsMapper.selectResidentsList(residents);
    }

    /**
     * 新增住户信息
     *
     * @param residents 住户信息
     * @return 结果
     */
    @Override
    public int insertResidents(Residents residents) {
        residents.setCreateTime(DateUtils.getNowDate());
        return residentsMapper.insertResidents(residents);
    }

    /**
     * 修改住户信息
     *
     * @param residents 住户信息
     * @return 结果
     */
    @Override
    public int updateResidents(Residents residents) {
        residents.setUpdateTime(DateUtils.getNowDate());
        return residentsMapper.updateResidents(residents);
    }

    /**
     * 批量删除住户信息
     *
     * @param residentsIds 需要删除的住户信息主键
     * @return 结果
     */
    @Override
    public int deleteResidentsByResidentsIds(Integer[] residentsIds) {
        return residentsMapper.deleteResidentsByResidentsIds(residentsIds);
    }

    /**
     * 删除住户信息信息
     *
     * @param residentsId 住户信息主键
     * @return 结果
     */
    @Override
    public int deleteResidentsByResidentsId(Integer residentsId) {
        return residentsMapper.deleteResidentsByResidentsId(residentsId);
    }
}
