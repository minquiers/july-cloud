package com.july.cloud.mybatisplus.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Page Utils
 */
public class PageUtils {

    /**
     * build success baseVO
     *
     * @param pageData page data
     * @param function functional interface
     * @param <DTO>    data transfer object
     * @param <VO>     value object
     * @return the success baseVO
     */
    public static <DTO, VO> IPage<VO> buildSuccessPageVo(IPage<DTO> pageData, Function<DTO, VO> function) {
        IPage page = new Page(pageData.getCurrent(), pageData.getSize(), pageData.getTotal());
        if (function != null) {
            List<VO> data = new ArrayList<>();
            pageData.getRecords().forEach(item -> data.add(function.apply(item)));
        }
        return page;
    }

    /**
     * build success baseVO
     *
     * @param pageData page data
     * @param <DTO>    data transfer object
     * @param <VO>     value object
     * @return the success baseVO
     */
    public static <DTO, VO> IPage<VO> buildSuccessPageVo(IPage<DTO> pageData, List<VO> vos) {
        IPage page = new Page(pageData.getCurrent(), pageData.getSize(), pageData.getTotal());
        page.setRecords(vos);
        return page;
    }


}
