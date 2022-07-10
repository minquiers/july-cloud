package com.july.cloud.biz.framework.convert;

import com.july.cloud.biz.framework.dto.SysDictTypeDTO;
import com.july.cloud.biz.framework.entity.SysDictTypeEntity;
import com.july.cloud.biz.framework.vo.SysDictTypeVO;
import com.july.cloud.core.convert.BeanConvert;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysDictTypeConvert extends BeanConvert<SysDictTypeEntity, SysDictTypeDTO, SysDictTypeVO> {
}
