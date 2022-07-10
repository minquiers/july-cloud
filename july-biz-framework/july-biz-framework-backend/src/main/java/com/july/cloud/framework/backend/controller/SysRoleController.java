package com.july.cloud.framework.backend.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.july.cloud.common.core.domain.R;
import com.july.cloud.framework.backend.convert.SysRoleConvert;
import com.july.cloud.framework.backend.dto.SysRoleDTO;
import com.july.cloud.framework.backend.service.ISysRoleMenuService;
import com.july.cloud.framework.backend.service.ISysRoleService;
import com.july.cloud.framework.backend.vo.SysRoleVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色管理模块
 */
@RestController
@RequestMapping("/framework/sys/role")
@Api(tags = "角色管理模块")
public class SysRoleController {

	@Autowired
	private ISysRoleService sysRoleService;

	@Autowired
	private ISysRoleMenuService sysRoleMenuService;

	@Autowired
	private SysRoleConvert sysRoleConvert;

	/**
	 * 通过ID查询角色信息
	 * @param id ID
	 * @return 角色信息
	 */
	@GetMapping("/{id}")
	public R<SysRoleVO> getById(@PathVariable String id) {
		return R.ok(sysRoleConvert.entityToVO(sysRoleService.getById(id)));
	}

	/**
	 * 添加角色
	 * @param sysRoleDTO 角色信息
	 * @return id
	 */
	//@SysLog("添加角色")
	@PostMapping
	//@PreAuthorize("@pms.hasPermission('sys_role_add')")
	public R<String> save(@RequestBody SysRoleDTO sysRoleDTO) {
		return R.ok(sysRoleService.insertRole(sysRoleDTO));
	}

	/**
	 * 修改角色
	 * @param sysRoleDTO 角色信息
	 * @return success/false
	 */
	//@SysLog("修改角色")
	@PutMapping
	//@PreAuthorize("@pms.hasPermission('sys_role_edit')")
	public R<String> update(@RequestBody SysRoleDTO sysRoleDTO) {
		return R.ok(sysRoleService.updateRole(sysRoleDTO));
	}

	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	//@SysLog("删除角色")
	@DeleteMapping("/{id}")
	//@PreAuthorize("@pms.hasPermission('sys_role_del')")
	public R removeById(@PathVariable String id) {
		sysRoleService.removeById(id);
		return R.ok();
	}

	/**
	 * 获取角色列表
	 * @return 角色列表
	 */
	@GetMapping("/list")
	public R<List<SysRoleVO>> listRoles() {
		return R.ok(sysRoleConvert.entitiesToVOs(sysRoleService.list(Wrappers.emptyWrapper())));
	}

	/**
	 * 分页查询角色信息
	 * @param page 分页对象
	 * @return 分页对象
	 */
	@GetMapping
	public R<IPage<SysRoleVO>> getRolePage(Page page , SysRoleDTO roleDTO) {
		return R.ok(sysRoleService.get(page, roleDTO));
	}

	/**
	 * 更新角色菜单
	 * @param roleDTO 角色对象
	 * @return
	 */
	//@SysLog("更新角色菜单")
	@PutMapping("/menu")
	//@PreAuthorize("@pms.hasPermission('sys_role_perm')")
	public R saveRoleMenus(@RequestBody SysRoleDTO roleDTO) {
		sysRoleMenuService.saveRoleMenus(roleDTO.getId(), roleDTO.getMenus());
		return R.ok();
	}

}
