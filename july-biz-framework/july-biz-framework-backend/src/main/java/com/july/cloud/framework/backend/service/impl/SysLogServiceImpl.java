package com.july.cloud.framework.backend.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.july.cloud.framework.backend.convert.SysLogConvert;
import com.july.cloud.framework.backend.dto.SysLogDTO;
import com.july.cloud.framework.backend.entity.SysLogEntity;
import com.july.cloud.framework.backend.mapper.SysLogMapper;
import com.july.cloud.framework.backend.service.ISysLogService;
import com.july.cloud.framework.backend.vo.SysLogVO;
import com.july.cloud.mybatisplus.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Minquiers
 * @description 针对表【sys_log(日志表)】的数据库操作Service实现
 * @createDate 2022-07-10 16:37:44
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogEntity>
        implements ISysLogService {

    @Autowired
    private SysLogConvert sysLogConvert;

    @Override
    public IPage<SysLogVO> get(Page page, SysLogDTO sysLogDTO) {
        IPage<SysLogEntity> iPage = baseMapper.selectPage(page, Wrappers.query(sysLogDTO));
        return PageUtils.buildSuccessPageVo(iPage, sysLogConvert.entitiesToVOs(iPage.getRecords()));
    }

    @Override
    public String insertLog(SysLogDTO sysLogDTO) {
        SysLogEntity entity = sysLogConvert.dtoToEntity(sysLogDTO);
        baseMapper.insert(entity);
        return entity.getId();
    }
}
