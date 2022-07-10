package com.july.cloud.framework.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.july.cloud.core.utils.CollectionUtils;
import com.july.cloud.framework.backend.dto.SysUserDTO;
import com.july.cloud.framework.backend.entity.SysUserRoleEntity;
import com.july.cloud.framework.backend.mapper.SysUserRoleMapper;
import com.july.cloud.framework.backend.service.ISysUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author Minquiers
* @description 针对表【sys_user_role(用户角色表)】的数据库操作Service实现
* @createDate 2022-07-10 19:09:59
*/
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRoleEntity>
implements ISysUserRoleService {

    @Transactional
    @Override
    public void userRoleRel(SysUserDTO userDTO) {
        LambdaQueryWrapper<SysUserRoleEntity> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(SysUserRoleEntity::getUserId , userDTO.getId());
        baseMapper.delete(queryWrapper);

        if(CollectionUtils.isNotEmpty(userDTO.getRoles())){
            List<SysUserRoleEntity> srl = userDTO.getRoles().stream().map(e->{
                SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
                sysUserRoleEntity.setUserId(userDTO.getId());
                sysUserRoleEntity.setRoleId(e);
                return sysUserRoleEntity;
            }).distinct().collect(Collectors.toList());
            saveBatch(srl);
        }
    }

}
