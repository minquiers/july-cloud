package com.july.cloud.framework.backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.july.cloud.framework.backend.dto.SysLogDTO;
import com.july.cloud.framework.backend.entity.SysLogEntity;
import com.july.cloud.framework.backend.vo.SysLogVO;

/**
* @author Minquiers
* @description 针对表【sys_log(日志表)】的数据库操作Service
* @createDate 2022-07-10 16:37:44
*/
public interface ISysLogService extends IService<SysLogEntity> {

    /**
     * 日志分页查询
     * @param page
     * @param sysLogDTO
     * @return
     */
    IPage<SysLogVO> get(Page page, SysLogDTO sysLogDTO);

    /**
     * 保存日志
     * @param sysLogDTO
     * @return
     */
    String insertLog(SysLogDTO sysLogDTO);
}
