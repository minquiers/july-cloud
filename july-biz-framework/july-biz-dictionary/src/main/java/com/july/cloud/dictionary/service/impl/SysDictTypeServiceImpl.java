package com.july.cloud.dictionary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.july.cloud.dictionary.convert.SysDictTypeConvert;
import com.july.cloud.dictionary.dto.SysDictTypeDTO;
import com.july.cloud.dictionary.entity.SysDictTypeEntity;
import com.july.cloud.dictionary.mapper.SysDictTypeMapper;
import com.july.cloud.dictionary.service.ISysDictDataService;
import com.july.cloud.dictionary.service.ISysDictTypeService;
import com.july.cloud.dictionary.vo.SysDictDataVO;
import com.july.cloud.dictionary.vo.SysDictTypeVO;
import com.july.cloud.mybatisplus.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Minquiers
 * @description 针对表【sys_dict_type(字典类型表)】的数据库操作Service实现
 * @createDate 2022-07-10 10:59:35
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictTypeEntity>
        implements ISysDictTypeService {
    @Autowired
    private SysDictTypeMapper dictTypeMapper;

    @Autowired
    private ISysDictDataService sysDictDataService;

    @Autowired
    private SysDictTypeConvert sysDictTypeConvert;

    /**
     * 项目启动时，初始化字典到缓存
     */
    @PostConstruct
    public void init() {
        loadingDictCache();
    }


    /**
     * 根据所有字典类型
     *
     * @return 字典类型集合信息
     */
    @Override
    public List<SysDictTypeVO> selectDictTypeAll() {
        return sysDictTypeConvert.entitiesToVOs(dictTypeMapper.selectList(null));
    }

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    @Override
    public List<SysDictDataVO> selectDictDataByType(String dictType) {
        /*List<SysDictData> dictDatas = DictUtils.getDictCache(dictType);
        if (StringUtils.isNotEmpty(dictDatas)) {
            return dictDatas;
        }*/
        return sysDictDataService.selectDictDataByType(dictType);
        /*if (StringUtils.isNotEmpty(dictDatas)) {
            DictUtils.setDictCache(dictType, dictDatas);
            return dictDatas;
        }*/
    }

    /**
     * 根据字典类型ID查询信息
     *
     * @param dictId 字典类型ID
     * @return 字典类型
     */
    @Override
    public SysDictTypeVO selectDictTypeById(String dictId) {
        return sysDictTypeConvert.entityToVO(dictTypeMapper.selectById(dictId));
    }

    /**
     * 根据字典类型查询信息
     *
     * @param dictType 字典类型
     * @return 字典类型
     */
    @Override
    public SysDictTypeVO selectDictTypeByType(String dictType) {
        LambdaQueryWrapper<SysDictTypeEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysDictTypeEntity::getDictType, dictType);
        return sysDictTypeConvert.entityToVO(baseMapper.selectOne(queryWrapper));
    }

    /**
     * 删除字典类型信息
     *
     * @param dictId 需要删除的字典ID
     */
    @Override
    public void deleteDictTypeById(String dictId) {
        dictTypeMapper.deleteById(dictId);
        //DictUtils.removeDictCache(dictType.getDictType());
    }

    /**
     * 加载字典缓存数据
     */
    @Override
    public void loadingDictCache() {
        /*SysDictData dictData = new SysDictData();
        dictData.setStatus("0");
        Map<String, List<SysDictData>> dictDataMap = dictDataMapper.selectDictDataList(dictData).stream().collect(Collectors.groupingBy(SysDictData::getDictType));
        for (Map.Entry<String, List<SysDictData>> entry : dictDataMap.entrySet()) {
            DictUtils.setDictCache(entry.getKey(), entry.getValue().stream().sorted(Comparator.comparing(SysDictData::getDictSort)).collect(Collectors.toList()));
        }*/
    }

    /**
     * 清空字典缓存数据
     */
    @Override
    public void clearDictCache() {
        //DictUtils.clearDictCache();
    }

    /**
     * 重置字典缓存数据
     */
    @Override
    public void resetDictCache() {
        clearDictCache();
        loadingDictCache();
    }

    /**
     * 新增保存字典类型信息
     *
     * @param sysDictTypeDTO 字典类型信息
     * @return 结果
     */
    @Override
    public String insertDictType(SysDictTypeDTO sysDictTypeDTO) {
        int row = dictTypeMapper.insert(sysDictTypeDTO);
       /* if (row > 0) {
            DictUtils.setDictCache(dict.getDictType(), null);
        }*/
        return sysDictTypeDTO.getId();
    }

    /**
     * 修改保存字典类型信息
     *
     * @param sysDictTypeDTO 字典类型信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateDictType(SysDictTypeDTO sysDictTypeDTO) {
        SysDictTypeEntity oldDict = dictTypeMapper.selectById(sysDictTypeDTO.getId());

        sysDictTypeConvert.dtoUpdateEntity(sysDictTypeDTO, oldDict);
        baseMapper.updateById(oldDict);

        /*dictDataMapper.updateDictDataType(oldDict.getDictType(), dict.getDictType());
        int row = dictTypeMapper.updateDictType(dict);
        if (row > 0) {
            List<SysDictData> dictDatas = dictDataMapper.selectDictDataByType(dict.getDictType());
            DictUtils.setDictCache(dict.getDictType(), dictDatas);
        }*/
        return sysDictTypeDTO.getId();
    }

    @Override
    public String checkDictTypeUnique(SysDictTypeDTO dictTypeDTO) {
        return null;
    }

    @Override
    public IPage<SysDictTypeVO> get(Page page, SysDictTypeDTO dictTypeDTO) {
        IPage<SysDictTypeEntity> iPage = baseMapper.selectPage(page, Wrappers.query(dictTypeDTO));
        return PageUtils.buildSuccessPageVo(iPage, sysDictTypeConvert.entitiesToVOs(iPage.getRecords()));
    }

    /**
     * 校验字典类型称是否唯一
     *
     * @param dict 字典类型
     * @return 结果
     *//*
    @Override
    public String checkDictTypeUnique(SysDictType dict) {
        Long dictId = StringUtils.isNull(dict.getDictId()) ? -1L : dict.getDictId();
        SysDictType dictType = dictTypeMapper.checkDictTypeUnique(dict.getDictType());
        if (StringUtils.isNotNull(dictType) && dictType.getDictId().longValue() != dictId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }*/
}
