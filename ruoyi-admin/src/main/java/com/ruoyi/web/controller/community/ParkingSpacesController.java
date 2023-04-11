package com.ruoyi.web.controller.community;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.community.domain.ParkingSpaces;
import com.ruoyi.community.service.IParkingSpacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 车位信息Controller
 *
 * @author yanghua
 * @date 2023-04-11
 */
@RestController
@RequestMapping("/community/spaces")
public class ParkingSpacesController extends BaseController {
    @Autowired
    private IParkingSpacesService parkingSpacesService;

    /**
     * 查询车位信息列表
     */
    @PreAuthorize("@ss.hasPermi('community:spaces:list')")
    @GetMapping("/list")
    public TableDataInfo list(ParkingSpaces parkingSpaces) {
        startPage();
        List<ParkingSpaces> list = parkingSpacesService.selectParkingSpacesList(parkingSpaces);
        return getDataTable(list);
    }

    /**
     * 导出车位信息列表
     */
    @PreAuthorize("@ss.hasPermi('community:spaces:export')")
    @Log(title = "车位信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ParkingSpaces parkingSpaces) {
        List<ParkingSpaces> list = parkingSpacesService.selectParkingSpacesList(parkingSpaces);
        ExcelUtil<ParkingSpaces> util = new ExcelUtil<ParkingSpaces>(ParkingSpaces.class);
        util.exportExcel(response, list, "车位信息数据");
    }

    /**
     * 获取车位信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('community:spaces:query')")
    @GetMapping(value = "/{parkId}")
    public AjaxResult getInfo(@PathVariable("parkId") Integer parkId) {
        return success(parkingSpacesService.selectParkingSpacesByParkId(parkId));
    }

    /**
     * 新增车位信息
     */
    @PreAuthorize("@ss.hasPermi('community:spaces:add')")
    @Log(title = "车位信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ParkingSpaces parkingSpaces) {
        return toAjax(parkingSpacesService.insertParkingSpaces(parkingSpaces));
    }

    /**
     * 修改车位信息
     */
    @PreAuthorize("@ss.hasPermi('community:spaces:edit')")
    @Log(title = "车位信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ParkingSpaces parkingSpaces) {
        return toAjax(parkingSpacesService.updateParkingSpaces(parkingSpaces));
    }

    /**
     * 删除车位信息
     */
    @PreAuthorize("@ss.hasPermi('community:spaces:remove')")
    @Log(title = "车位信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{parkIds}")
    public AjaxResult remove(@PathVariable Integer[] parkIds) {
        return toAjax(parkingSpacesService.deleteParkingSpacesByParkIds(parkIds));
    }
}
