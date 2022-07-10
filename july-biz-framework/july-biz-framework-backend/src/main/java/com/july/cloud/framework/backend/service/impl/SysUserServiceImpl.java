package com.july.cloud.framework.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.july.cloud.core.utils.CollectionUtils;
import com.july.cloud.framework.backend.convert.SysUserConvert;
import com.july.cloud.framework.backend.dto.SysUserDTO;
import com.july.cloud.framework.backend.entity.SysUserEntity;
import com.july.cloud.framework.backend.entity.SysUserRoleEntity;
import com.july.cloud.framework.backend.mapper.SysUserMapper;
import com.july.cloud.framework.backend.service.ISysUserRoleService;
import com.july.cloud.framework.backend.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private ISysUserRoleService sysUserRoleService;

    @Override
    public String insertUser(SysUserDTO userDTO) {
        SysUserEntity userEntity = sysUserConvert.dtoToEntity(userDTO);
        baseMapper.insert(userEntity);
        return userEntity.getId();
    }

    @Override
    public String updateUser(SysUserDTO userDTO) {
        SysUserEntity dbEntity = baseMapper.selectById(userDTO.getId());
        sysUserConvert.dtoUpdateEntity(userDTO , dbEntity);
        baseMapper.updateById(dbEntity);
        return dbEntity.getId();
    }

}
