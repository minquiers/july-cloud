package com.july.cloud.dictionary.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.july.cloud.dictionary.dto.SysDictTypeDTO;
import com.july.cloud.dictionary.entity.SysDictTypeEntity;
import com.july.cloud.dictionary.vo.SysDictDataVO;
import com.july.cloud.dictionary.vo.SysDictTypeVO;

import java.util.List;

/**
 * @author Minquiers
 * @description 针对表【sys_dict_type(字典类型表)】的数据库操作Service
 * @createDate 2022-07-10 10:59:35
 */
public interface ISysDictTypeService extends IService<SysDictTypeEntity> {
    /**
     * 根据所有字典类型
     *
     * @return 字典类型集合信息
     */
    List<SysDictTypeVO> selectDictTypeAll();

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    List<SysDictDataVO> selectDictDataByType(String dictType);

    /**
     * 根据字典类型ID查询信息
     *
     * @param dictId 字典类型ID
     * @return 字典类型
     */
    SysDictTypeVO selectDictTypeById(String dictId);

    /**
     * 根据字典类型查询信息
     *
     * @param dictType 字典类型
     * @return 字典类型
     */
    SysDictTypeVO selectDictTypeByType(String dictType);

    /**
     * 删除字典信息
     *
     * @param dictId 需要删除的字典ID
     */
    void deleteDictTypeById(String dictId);

    /**
     * 加载字典缓存数据
     */
    void loadingDictCache();

    /**
     * 清空字典缓存数据
     */
    void clearDictCache();

    /**
     * 重置字典缓存数据
     */
    void resetDictCache();

    /**
     * 新增保存字典类型信息
     *
     * @param dictTypeDTO 字典类型信息
     * @return 结果
     */
    String insertDictType(SysDictTypeDTO dictTypeDTO);

    /**
     * 修改保存字典类型信息
     *
     * @param dictTypeDTO 字典类型信息
     * @return 结果
     */
    String updateDictType(SysDictTypeDTO dictTypeDTO);

    /**
     * 校验字典类型称是否唯一
     *
     * @param dictTypeDTO 字典类型
     * @return 结果
     */
    String checkDictTypeUnique(SysDictTypeDTO dictTypeDTO);

    /**
     * 分页查询
     *
     * @param page
     * @param dictTypeDTO
     * @return
     */
    IPage<SysDictTypeVO> get(Page page, SysDictTypeDTO dictTypeDTO);
}
