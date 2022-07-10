package com.july.cloud.framework.backend.convert;

import com.july.cloud.core.convert.BeanConvert;
import com.july.cloud.framework.backend.dto.SysRoleDTO;
import com.july.cloud.framework.backend.entity.SysRoleEntity;
import com.july.cloud.framework.backend.vo.SysRoleVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysRoleConvert extends BeanConvert<SysRoleEntity, SysRoleDTO, SysRoleVO> {
}
