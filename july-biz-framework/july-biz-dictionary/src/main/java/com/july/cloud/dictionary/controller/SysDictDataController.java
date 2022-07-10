package com.july.cloud.dictionary.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.july.cloud.common.core.domain.R;
import com.july.cloud.dictionary.dto.SysDictDataDTO;
import com.july.cloud.dictionary.service.ISysDictDataService;
import com.july.cloud.dictionary.service.ISysDictTypeService;
import com.july.cloud.dictionary.vo.SysDictDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据字典信息
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/dict/data")
public class SysDictDataController {
    @Autowired
    private ISysDictDataService dictDataService;

    @Autowired
    private ISysDictTypeService dictTypeService;

    //@RequiresPermissions("system:dict:list")
    @GetMapping
    public R<IPage<SysDictDataVO>> page(Page page, SysDictDataDTO dictDataDTO) {
        return R.ok(dictDataService.get(page, dictDataDTO));
    }

    //@Log(title = "字典数据", businessType = BusinessType.EXPORT)
    //@RequiresPermissions("system:dict:export")
    /*@PostMapping("/export")
    public void export(HttpServletResponse response, SysDictData dictData) {
        List<SysDictData> list = dictDataService.selectDictDataList(dictData);
        ExcelUtil<SysDictData> util = new ExcelUtil<SysDictData>(SysDictData.class);
        util.exportExcel(response, list, "字典数据");
    }*/

    /**
     * 查询字典数据详细
     */
    //@RequiresPermissions("system:dict:query")
    @GetMapping(value = "/{dictCode}")
    public R<SysDictDataVO> getInfo(@PathVariable String dictCode) {
        return R.ok(dictDataService.selectDictDataById(dictCode));
    }

    /**
     * 根据字典类型查询字典数据信息
     */
    @GetMapping(value = "/type/{dictType}")
    public R<List<SysDictDataVO>> dictType(@PathVariable String dictType) {
        return R.ok(dictTypeService.selectDictDataByType(dictType));
    }

    /**
     * 新增字典类型
     */
    //@RequiresPermissions("system:dict:add")
    //@Log(title = "字典数据", businessType = BusinessType.INSERT)
    @PostMapping
    public R<String> add(@Validated @RequestBody SysDictDataDTO dictDataDTO) {
        return R.ok(dictDataService.insertDictData(dictDataDTO));
    }

    /**
     * 修改保存字典类型
     */
    //@RequiresPermissions("system:dict:edit")
    //@Log(title = "字典数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<String> edit(@Validated @RequestBody SysDictDataDTO dictDataDTO) {
        return R.ok(dictDataService.updateDictData(dictDataDTO));
    }

    /**
     * 删除字典类型
     */
    //@RequiresPermissions("system:dict:remove")
    //@Log(title = "字典类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{dictCode}")
    public R remove(@PathVariable String dictCode) {
        dictDataService.deleteDictDataById(dictCode);
        return R.ok();
    }
}
