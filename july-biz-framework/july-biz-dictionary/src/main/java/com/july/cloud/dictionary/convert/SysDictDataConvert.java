package com.july.cloud.dictionary.convert;

import com.july.cloud.core.convert.BeanConvert;
import com.july.cloud.dictionary.dto.SysDictDataDTO;
import com.july.cloud.dictionary.entity.SysDictDataEntity;
import com.july.cloud.dictionary.vo.SysDictDataVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysDictDataConvert extends BeanConvert<SysDictDataEntity, SysDictDataDTO, SysDictDataVO> {
}
