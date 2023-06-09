package com.ruoyi.flowable.controller.task;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.flowable.service.task.BpmActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Api(tags = "管理后台 - 流程活动实例")
@RestController
@RequestMapping("/bpm/activity")
@Validated
public class BpmActivityController {

    @Resource
    private BpmActivityService activityService;

    @GetMapping("/list")
    @ApiOperation(value = "生成指定流程实例的高亮流程图",
            notes = "只高亮进行中的任务。不过要注意，该接口暂时没用，通过前端的 ProcessViewer.vue 界面的 highlightDiagram 方法生成")
    @ApiImplicitParam(name = "processInstanceId", value = "流程实例的编号", required = true, dataTypeClass = String.class)
    @PreAuthorize("@ss.hasPermi('bpm:task:query')")
    public AjaxResult getActivityList(@RequestParam("processInstanceId") String processInstanceId) {
        return AjaxResult.success(activityService.getActivityListByProcessInstanceId(processInstanceId));
    }
}
