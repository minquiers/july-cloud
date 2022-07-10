package com.july.cloud.dictionary.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.july.cloud.common.core.domain.R;
import com.july.cloud.dictionary.dto.SysDictTypeDTO;
import com.july.cloud.dictionary.service.ISysDictTypeService;
import com.july.cloud.dictionary.vo.SysDictTypeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 数据字典类型
 */
@RestController
@RequestMapping("/dict/type")
@Api(tags = "数据字典类型")
public class SysDictTypeController {
    @Autowired
    private ISysDictTypeService dictTypeService;

    //@RequiresPermissions("system:dict:list")
    @GetMapping()
    @ApiOperation(value = "字典类型查询")
    public R<IPage<SysDictTypeVO>> page(Page page, SysDictTypeDTO dictTypeDTO) {
        return R.ok(dictTypeService.get(page , dictTypeDTO));
    }

    //@Log(title = "字典类型", businessType = BusinessType.EXPORT)
    //@RequiresPermissions("system:dict:export")
    /*@PostMapping("/export")
    public void export(HttpServletResponse response, SysDictType dictType) {
        List<SysDictType> list = dictTypeService.selectDictTypeList(dictType);
        ExcelUtil<SysDictType> util = new ExcelUtil<SysDictType>(SysDictType.class);
        util.exportExcel(response, list, "字典类型");
    }*/

    /**
     * 查询字典类型详细
     */
    //@RequiresPermissions("system:dict:query")
    @GetMapping(value = "/{dictId}")
    @ApiOperation(value = "根据id获取明细")
    public R<SysDictTypeVO> getInfo(@PathVariable String dictId) {
        return R.ok(dictTypeService.selectDictTypeById(dictId));
    }

    /**
     * 新增字典类型
     */
    //@RequiresPermissions("system:dict:add")
    //@Log(title = "字典类型", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation(value = "新增字典类型")
    public R<String> add(@Validated @RequestBody SysDictTypeDTO sysDictTypeDTO) {
        return R.ok(dictTypeService.insertDictType(sysDictTypeDTO));
    }

    /**
     * 修改字典类型
     */
    //@RequiresPermissions("system:dict:edit")
    //@Log(title = "字典类型", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation(value = "修改字典类型")
    public R edit(@Validated @RequestBody SysDictTypeDTO sysDictTypeDTO) {
        return R.ok(dictTypeService.updateDictType(sysDictTypeDTO));
    }

    /**
     * 删除字典类型
     */
    //@RequiresPermissions("system:dict:remove")
    //@Log(title = "字典类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{dictId}")
    @ApiOperation(value = "删除字典类型")
    public R remove(@PathVariable String dictId) {
        dictTypeService.deleteDictTypeById(dictId);
        return R.ok();
    }

    /**
     * 刷新字典缓存
     */
    //@RequiresPermissions("system:dict:remove")
    //@Log(title = "字典类型", businessType = BusinessType.CLEAN)
    @DeleteMapping("/refreshCache")
    @ApiOperation(value = "刷新缓存")
    public R refreshCache() {
        dictTypeService.resetDictCache();
        return R.ok();
    }

}
