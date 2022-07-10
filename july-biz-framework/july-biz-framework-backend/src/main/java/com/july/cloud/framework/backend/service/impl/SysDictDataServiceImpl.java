package com.july.cloud.framework.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.july.cloud.framework.backend.convert.SysDictDataConvert;
import com.july.cloud.framework.backend.dto.SysDictDataDTO;
import com.july.cloud.framework.backend.entity.SysDictDataEntity;
import com.july.cloud.framework.backend.mapper.SysDictDataMapper;
import com.july.cloud.framework.backend.service.ISysDictDataService;
import com.july.cloud.framework.backend.vo.SysDictDataVO;
import com.july.cloud.mybatisplus.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Minquiers
 * @description 针对表【sys_dict_data(字典数据表)】的数据库操作Service实现
 * @createDate 2022-07-10 10:59:05
 */
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictDataEntity>
        implements ISysDictDataService {
    @Autowired
    private SysDictDataMapper dictDataMapper;

    @Autowired
    private SysDictDataConvert sysDictDataConvert;

    /**
     * 根据条件分页查询字典数据
     *
     * @param dictDataDTO 字典数据信息
     * @return 字典数据集合信息
     */
    @Override
    public IPage<SysDictDataVO> get(Page page, SysDictDataDTO dictDataDTO) {
        IPage<SysDictDataEntity> iPage = baseMapper.selectPage(page, Wrappers.query(dictDataDTO));
        return PageUtils.buildSuccessPageVo(iPage, sysDictDataConvert.entitiesToVOs(iPage.getRecords()));
    }

    @Override
    public List<SysDictDataVO> selectDictDataByType(String dictType) {
        LambdaQueryWrapper<SysDictDataEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysDictDataEntity::getDictType, dictType);
        return sysDictDataConvert.entitiesToVOs(baseMapper.selectList(queryWrapper));
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue) {
        LambdaQueryWrapper<SysDictDataEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysDictDataEntity::getDictType, dictType)
                .eq(SysDictDataEntity::getDictValue, dictValue);
        SysDictDataEntity sysDictDataEntity = baseMapper.selectOne(queryWrapper);
        if (null != sysDictDataEntity) {
            return sysDictDataEntity.getDictLabel();
        }
        return null;
    }

    /**
     * 根据字典数据ID查询信息
     *
     * @param id 字典数据ID
     * @return 字典数据
     */
    @Override
    public SysDictDataVO selectDictDataById(String id) {
        return sysDictDataConvert.entityToVO(dictDataMapper.selectById(id));
    }

    /**
     * 新增保存字典数据信息
     *
     * @param dictDataDTO 字典数据信息
     * @return 结果
     */
    @Override
    public String insertDictData(SysDictDataDTO dictDataDTO) {
        SysDictDataEntity dictDataEntity = sysDictDataConvert.dtoToEntity(dictDataDTO);
        baseMapper.insert(dictDataEntity);
        return dictDataEntity.getId();
    }

    /**
     * 修改保存字典数据信息
     *
     * @param dictDataDTO 字典数据信息
     * @return 结果
     */
    @Override
    public String updateDictData(SysDictDataDTO dictDataDTO) {
        SysDictDataEntity dbEntity = baseMapper.selectById(dictDataDTO.getId());
        sysDictDataConvert.dtoUpdateEntity(dictDataDTO, dbEntity);
        baseMapper.updateById(dbEntity);
        return dbEntity.getId();
    }
}
