package com.july.cloud.framework.backend.convert;

import com.july.cloud.core.convert.BeanConvert;
import com.july.cloud.framework.backend.dto.SysUserDTO;
import com.july.cloud.framework.backend.entity.SysUserEntity;
import com.july.cloud.framework.backend.vo.SysUserVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysUserConvert extends BeanConvert<SysUserEntity, SysUserDTO, SysUserVO> {
}
