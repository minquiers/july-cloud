package com.july.cloud.biz.framework.convert;

import com.july.cloud.biz.framework.dto.SysLogDTO;
import com.july.cloud.biz.framework.entity.SysLogEntity;
import com.july.cloud.biz.framework.vo.SysLogVO;
import com.july.cloud.core.convert.BeanConvert;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SysLogConvert extends BeanConvert<SysLogEntity, SysLogDTO, SysLogVO> {
}
