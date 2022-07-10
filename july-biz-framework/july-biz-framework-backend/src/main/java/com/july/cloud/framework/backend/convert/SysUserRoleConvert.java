package com.july.cloud.framework.backend.convert;

import com.july.cloud.core.convert.BeanConvert;
import com.july.cloud.framework.backend.dto.SysUserRoleDTO;
import com.july.cloud.framework.backend.entity.SysUserRoleEntity;
import com.july.cloud.framework.backend.vo.SysUserRoleVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysUserRoleConvert extends BeanConvert<SysUserRoleEntity, SysUserRoleDTO, SysUserRoleVO> {
}
