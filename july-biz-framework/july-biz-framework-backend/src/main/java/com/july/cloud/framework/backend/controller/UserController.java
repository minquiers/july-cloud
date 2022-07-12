package com.july.cloud.framework.backend.controller;

import com.july.cloud.common.core.domain.R;
import com.july.cloud.framework.backend.dto.SysUserDTO;
import com.july.cloud.framework.backend.service.ISysUserRoleService;
import com.july.cloud.framework.backend.service.ISysUserService;
import com.july.cloud.framework.backend.vo.SysUserVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理模块
 */
@RestController
@RequestMapping("/framework/sys/user")
@Api(tags = "用户管理模块")
public class UserController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserRoleService sysUserRoleService;

    /**
     * 添加用户
     *
     * @param userDTO 用户信息
     * @return 用户id
     */
    //@SysLog("添加用户")
    @PostMapping
    //@PreAuthorize("@pms.hasPermission('sys_user_add')")
    public R<String> user(@RequestBody SysUserDTO userDTO) {
        return R.ok(sysUserService.insertUser(userDTO));
    }

    /**
     * 更新用户信息
     *
     * @param userDTO 用户信息
     * @return R
     */
    //@SysLog("更新用户信息")
    @PutMapping
    //@PreAuthorize("@pms.hasPermission('sys_user_edit')")
    public R<String> updateUser(@RequestBody SysUserDTO userDTO) {
        return R.ok(sysUserService.updateUser(userDTO));
    }

    /**
     * 用户角色关联
     *
     * @param userDTO 用户信息
     * @return 用户id
     */
    //@SysLog("添加用户")
    @PostMapping("/role/related")
    //@PreAuthorize("@pms.hasPermission('sys_user_add')")
    public R userRoleRel(@RequestBody SysUserDTO userDTO) {
        sysUserRoleService.userRoleRel(userDTO);
        return R.ok();
    }

    @GetMapping("/username")
    public R<String> findUsername(@RequestParam(required = false) String email, @RequestParam(required = false) String phone) {
        return R.ok(sysUserService.findUsername(email, phone));
    }

    @GetMapping("/names/{username}")
    public R<SysUserVO> findInfoByUsername(@PathVariable("username") String username) {
        return R.ok(sysUserService.findInfoByUsername(username));
    }

}
