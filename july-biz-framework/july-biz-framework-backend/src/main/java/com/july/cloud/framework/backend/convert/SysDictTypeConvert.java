package com.july.cloud.framework.backend.convert;

import com.july.cloud.framework.backend.dto.SysDictTypeDTO;
import com.july.cloud.framework.backend.entity.SysDictTypeEntity;
import com.july.cloud.framework.backend.vo.SysDictTypeVO;
import com.july.cloud.core.convert.BeanConvert;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysDictTypeConvert extends BeanConvert<SysDictTypeEntity, SysDictTypeDTO, SysDictTypeVO> {
}
