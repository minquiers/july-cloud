package com.july.cloud.dictionary.convert;

import com.july.cloud.core.convert.BeanConvert;
import com.july.cloud.dictionary.dto.SysDictTypeDTO;
import com.july.cloud.dictionary.entity.SysDictTypeEntity;
import com.july.cloud.dictionary.vo.SysDictTypeVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysDictTypeConvert extends BeanConvert<SysDictTypeEntity, SysDictTypeDTO, SysDictTypeVO> {
}
