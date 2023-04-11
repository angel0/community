package com.ruoyi.web.controller.community;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.community.domain.Residents;
import com.ruoyi.community.service.IResidentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 住户信息Controller
 *
 * @author yanghua
 * @date 2023-04-08
 */
@RestController
@RequestMapping("/community/residents")
public class ResidentsController extends BaseController {
    @Autowired
    private IResidentsService residentsService;

    /**
     * 查询住户信息列表
     */
    @PreAuthorize("@ss.hasPermi('community:residents:list')")
    @GetMapping("/list")
    public TableDataInfo list(Residents residents) {
        startPage();
        List<Residents> list = residentsService.selectResidentsList(residents);
        return getDataTable(list);
    }

    /**
     * 导出住户信息列表
     */
    @PreAuthorize("@ss.hasPermi('community:residents:export')")
    @Log(title = "住户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Residents residents) {
        List<Residents> list = residentsService.selectResidentsList(residents);
        ExcelUtil<Residents> util = new ExcelUtil<Residents>(Residents.class);
        util.exportExcel(response, list, "住户信息数据");
    }

    /**
     * 获取住户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('community:residents:query')")
    @GetMapping(value = "/{residentsId}")
    public AjaxResult getInfo(@PathVariable("residentsId") Integer residentsId) {
        return success(residentsService.selectResidentsByResidentsId(residentsId));
    }

    /**
     * 新增住户信息
     */
    @PreAuthorize("@ss.hasPermi('community:residents:add')")
    @Log(title = "住户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Residents residents) {
        return toAjax(residentsService.insertResidents(residents));
    }

    /**
     * 修改住户信息
     */
    @PreAuthorize("@ss.hasPermi('community:residents:edit')")
    @Log(title = "住户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Residents residents) {
        return toAjax(residentsService.updateResidents(residents));
    }

    /**
     * 删除住户信息
     */
    @PreAuthorize("@ss.hasPermi('community:residents:remove')")
    @Log(title = "住户信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{residentsIds}")
    public AjaxResult remove(@PathVariable Integer[] residentsIds) {
        return toAjax(residentsService.deleteResidentsByResidentsIds(residentsIds));
    }
}
