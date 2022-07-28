package com.july.cloud.framework.backend.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.july.cloud.core.utils.StringUtils;
import com.july.cloud.framework.backend.convert.SysUserConvert;
import com.july.cloud.framework.backend.dto.SysUserDTO;
import com.july.cloud.framework.backend.entity.SysMenuEntity;
import com.july.cloud.framework.backend.entity.SysRoleEntity;
import com.july.cloud.framework.backend.entity.SysUserEntity;
import com.july.cloud.framework.backend.mapper.SysUserMapper;
import com.july.cloud.framework.backend.service.ISysMenuService;
import com.july.cloud.framework.backend.service.ISysRoleService;
import com.july.cloud.framework.backend.service.ISysUserService;
import com.july.cloud.framework.backend.vo.SysRoleVO;
import com.july.cloud.framework.backend.vo.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Minquiers
 * @description 针对表【sys_user(用户表)】的数据库操作Service实现
 * @createDate 2022-07-10 19:09:42
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity>
        implements ISysUserService {

    @Autowired
    private SysUserConvert sysUserConvert;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysMenuService sysMenuService;

    @Override
    public String insertUser(SysUserDTO userDTO) {
        SysUserEntity userEntity = sysUserConvert.dtoToEntity(userDTO);
        baseMapper.insert(userEntity);
        return userEntity.getId();
    }

    @Override
    public String updateUser(SysUserDTO userDTO) {
        SysUserEntity dbEntity = baseMapper.selectById(userDTO.getId());
        sysUserConvert.dtoUpdateEntity(userDTO, dbEntity);
        baseMapper.updateById(dbEntity);
        return dbEntity.getId();
    }

    @Override
    public String findUsername(String email, String phone) {
        if (StringUtils.isBlank(email) || StringUtils.isNotBlank(phone)) {
            LambdaQueryWrapper<SysUserEntity> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(StringUtils.isNotBlank(phone), SysUserEntity::getPhone, phone);

            List<SysUserEntity> list = baseMapper.selectList(queryWrapper);
            if (CollectionUtil.isNotEmpty(list)) {
                return list.get(0).getUsername();
            }
        }
        return null;
    }

    @Override
    public SysUserVO loginFindUserInfo(String username) {
        LambdaQueryWrapper<SysUserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUserEntity::getUsername, username);
        List<SysUserEntity> list = baseMapper.selectList(queryWrapper);
        if (CollectionUtil.isNotEmpty(list)) {
            SysUserVO sysUserVO = sysUserConvert.entityToVO(list.get(0));
            List<SysRoleVO> roleVOList = sysRoleService.findByUserId(sysUserVO.getId());
            if (CollectionUtil.isNotEmpty(roleVOList)) {
                sysUserVO.setRoles(roleVOList.stream().map(SysRoleVO::getRoleName).collect(Collectors.toSet()));
                List<SysMenuEntity> menuEntities = sysMenuService.findByRoles(roleVOList.stream().map(SysRoleEntity::getId).distinct().collect(Collectors.toList()));
                if (CollectionUtil.isNotEmpty(menuEntities)) {
                    sysUserVO.setPermissions(menuEntities.stream().map(SysMenuEntity::getPermission).collect(Collectors.toSet()));
                }
            }
            return sysUserVO;
        }
        return null;
    }

}
