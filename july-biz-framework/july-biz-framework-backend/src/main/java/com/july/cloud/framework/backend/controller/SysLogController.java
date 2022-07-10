package com.july.cloud.framework.backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.july.cloud.framework.backend.dto.SysLogDTO;
import com.july.cloud.framework.backend.service.ISysLogService;
import com.july.cloud.framework.backend.vo.SysLogVO;
import com.july.cloud.common.core.domain.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 日志表 前端控制器
 * </p>
 *
 * @author lengleng
 * @since 2019/2/1
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/framework/sys/log")
@Api(tags = "日志管理模块")
public class SysLogController {

	@Autowired
	private ISysLogService sysLogService;

	/**
	 * 简单分页查询
	 * @param page 分页对象
	 * @param sysLogDTO 系统日志
	 * @return
	 */
	@GetMapping()
	@ApiOperation(value = "日志查询")
	public R<IPage<SysLogVO>> page(Page page, SysLogDTO sysLogDTO) {
		return R.ok(sysLogService.get(page, sysLogDTO));
	}

	/**
	 * 删除日志
	 * @param id ID
	 * @return success/false
	 */
	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除日志")
	//@PreAuthorize("@pms.hasPermission('sys_log_del')")
	public R<Boolean> removeById(@PathVariable String id) {
		return R.ok(sysLogService.removeById(id));
	}

	/**
	 * 插入日志
	 * @param sysLogDTO 日志实体
	 * @return success/false
	 */
	@PostMapping
	@ApiOperation(value = "保存日志")
	public R<String> save(@RequestBody SysLogDTO sysLogDTO) {
		return R.ok(sysLogService.insertLog(sysLogDTO));
	}

}
