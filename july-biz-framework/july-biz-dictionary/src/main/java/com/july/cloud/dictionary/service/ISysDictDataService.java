package com.july.cloud.dictionary.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.july.cloud.dictionary.dto.SysDictDataDTO;
import com.july.cloud.dictionary.entity.SysDictDataEntity;
import com.july.cloud.dictionary.vo.SysDictDataVO;

import java.util.List;

/**
 * @author Minquiers
 * @description 针对表【sys_dict_data(字典数据表)】的数据库操作Service
 * @createDate 2022-07-10 10:59:05
 */
public interface ISysDictDataService extends IService<SysDictDataEntity> {
    /**
     * 根据条件分页查询字典数据
     *
     * @param page 分页对象
     * @param dictDataDTO 字典数据信息
     * @return 字典数据集合信息
     */
    IPage<SysDictDataVO> get(Page page , SysDictDataDTO dictDataDTO);

    /**
     * 根据字典类型查询
     * @param dictType
     * @return
     */
    List<SysDictDataVO> selectDictDataByType(String dictType);

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    String selectDictLabel(String dictType, String dictValue);

    /**
     * 根据字典数据ID查询信息
     *
     * @param id 字典数据ID
     * @return 字典数据
     */
    SysDictDataVO selectDictDataById(String id);

    /**
     * 删除字典数据信息
     *
     * @param dictCode 需要删除的字典数据ID
     */
    void deleteDictDataById(String dictCode);

    /**
     * 新增保存字典数据信息
     *
     * @param dictDataDTO 字典数据信息
     * @return 结果
     */
    String insertDictData(SysDictDataDTO dictDataDTO);

    /**
     * 修改保存字典数据信息
     *
     * @param dictDataDTO 字典数据信息
     * @return 结果
     */
    String updateDictData(SysDictDataDTO dictDataDTO);
}
