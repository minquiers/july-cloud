/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.july.cloud.framework.backend.controller;

import com.july.cloud.common.core.domain.R;
import com.july.cloud.framework.backend.convert.SysMenuConvert;
import com.july.cloud.framework.backend.dto.SysMenuDTO;
import com.july.cloud.framework.backend.service.ISysMenuService;
import com.july.cloud.framework.backend.vo.SysMenuVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单管理模块
 */
@RestController
@RequestMapping("/framework/sys/menu")
@Api(tags = "菜单管理模块")
public class SysMenuController {

	@Autowired
	private ISysMenuService sysMenuService;
	@Autowired
	private SysMenuConvert sysMenuConvert;

	/**
	 * 返回当前用户的树形菜单集合
	 * @param parentId 父节点ID
	 * @return 当前用户的树形菜单
	 *//*
	@GetMapping
	public R<List<Tree<Long>>> getUserMenu(Long parentId) {
		// 获取符合条件的菜单
		Set<SysMenu> menuSet = SecurityUtils.getRoles().stream().map(sysMenuService::findMenuByRoleId)
				.flatMap(Collection::stream).collect(Collectors.toSet());
		return R.ok(sysMenuService.filterMenu(menuSet, parentId));
	}

	*//**
	 * 返回树形菜单集合
	 * @param lazy 是否是懒加载
	 * @param parentId 父节点ID
	 * @return 树形菜单
	 *//*
	@GetMapping(value = "/tree")
	public R<List<Tree<Long>>> getTree(boolean lazy, Long parentId) {
		return R.ok(sysMenuService.treeMenu(lazy, parentId));
	}

	*//**
	 * 返回角色的菜单集合
	 * @param roleId 角色ID
	 * @return 属性集合
	 *//*
	@GetMapping("/tree/{roleId}")
	public R<List<Long>> getRoleTree(@PathVariable Long roleId) {
		return R.ok(
				sysMenuService.findMenuByRoleId(roleId).stream().map(SysMenu::getMenuId).collect(Collectors.toList()));
	}*/

	/**
	 * 通过ID查询菜单的详细信息
	 * @param id 菜单ID
	 * @return 菜单详细信息
	 */
	@GetMapping("/{id}")
	public R<SysMenuVO> getById(@PathVariable Long id) {
		return R.ok(sysMenuConvert.entityToVO(sysMenuService.getById(id)));
	}

	/**
	 * 新增菜单
	 * @param sysMenuDTO 菜单信息
	 * @return 含ID 菜单信息
	 */
	//@SysLog("新增菜单")
	@PostMapping
	//@PreAuthorize("@pms.hasPermission('sys_menu_add')")
	public R<String> save(@RequestBody SysMenuDTO sysMenuDTO) {
		return R.ok(sysMenuService.insertMenu(sysMenuDTO));
	}

	/**
	 * 删除菜单
	 * @param id 菜单ID
	 * @return success/false
	 */
	//@SysLog("删除菜单")
	@DeleteMapping("/{id}")
	//@PreAuthorize("@pms.hasPermission('sys_menu_del')")
	public R<Boolean> removeById(@PathVariable String id) {
		sysMenuService.removeById(id);
		return R.ok();
	}

	/**
	 * 更新菜单
	 * @param sysMenuDTO
	 * @return
	 */
	//@SysLog("更新菜单")
	@PutMapping
	//@PreAuthorize("@pms.hasPermission('sys_menu_edit')")
	public R<String> update(@RequestBody SysMenuDTO sysMenuDTO) {
		return R.ok(sysMenuService.updateMenu(sysMenuDTO));
	}

	/**
	 * 清除菜单缓存
	 *//*
	//@SysLog("清除菜单缓存")
	@DeleteMapping("/cache")
	//@PreAuthorize("@pms.hasPermission('sys_menu_del')")
	public R clearMenuCache() {
		sysMenuService.clearMenuCache();
		return R.ok();
	}*/

}
