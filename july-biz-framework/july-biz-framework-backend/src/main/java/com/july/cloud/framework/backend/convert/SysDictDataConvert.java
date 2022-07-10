package com.july.cloud.framework.backend.convert;

import com.july.cloud.framework.backend.dto.SysDictDataDTO;
import com.july.cloud.framework.backend.entity.SysDictDataEntity;
import com.july.cloud.framework.backend.vo.SysDictDataVO;
import com.july.cloud.core.convert.BeanConvert;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysDictDataConvert extends BeanConvert<SysDictDataEntity, SysDictDataDTO, SysDictDataVO> {
}
