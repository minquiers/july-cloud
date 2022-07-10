package com.july.cloud.framework.backend.convert;

import com.july.cloud.core.convert.BeanConvert;
import com.july.cloud.framework.backend.dto.SysMenuDTO;
import com.july.cloud.framework.backend.entity.SysMenuEntity;
import com.july.cloud.framework.backend.vo.SysMenuVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysMenuConvert extends BeanConvert<SysMenuEntity, SysMenuDTO, SysMenuVO> {
}
