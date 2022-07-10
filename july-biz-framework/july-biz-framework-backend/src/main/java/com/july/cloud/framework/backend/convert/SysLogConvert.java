package com.july.cloud.framework.backend.convert;

import com.july.cloud.framework.backend.dto.SysLogDTO;
import com.july.cloud.framework.backend.entity.SysLogEntity;
import com.july.cloud.framework.backend.vo.SysLogVO;
import com.july.cloud.core.convert.BeanConvert;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysLogConvert extends BeanConvert<SysLogEntity, SysLogDTO, SysLogVO> {
}
