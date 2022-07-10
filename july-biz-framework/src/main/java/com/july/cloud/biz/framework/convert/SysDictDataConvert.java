package com.july.cloud.biz.framework.convert;

import com.july.cloud.biz.framework.dto.SysDictDataDTO;
import com.july.cloud.biz.framework.entity.SysDictDataEntity;
import com.july.cloud.biz.framework.vo.SysDictDataVO;
import com.july.cloud.core.convert.BeanConvert;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysDictDataConvert extends BeanConvert<SysDictDataEntity, SysDictDataDTO, SysDictDataVO> {
}
