package com.july.cloud.framework.backend.convert;

import com.july.cloud.core.convert.BeanConvert;
import com.july.cloud.framework.backend.dto.SysRoleMenuDTO;
import com.july.cloud.framework.backend.entity.SysRoleMenuEntity;
import com.july.cloud.framework.backend.vo.SysRoleMenuVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysRoleMenuConvert extends BeanConvert<SysRoleMenuEntity, SysRoleMenuDTO, SysRoleMenuVO> {
}
