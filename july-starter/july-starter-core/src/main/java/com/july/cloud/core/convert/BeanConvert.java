package com.july.cloud.core.convert;

import com.july.cloud.core.annotation.UpdateConvertIgnore;
import org.mapstruct.*;

import java.util.List;

/**
 * BeanConvert
 *
 * @author gaoyiming
 * @date 2022-01-04
 * @description
 */
public interface BeanConvert<ENTITY, DTO, VO> {
    /**
     * dto to entity
     *
     * @param dto
     * @return
     */
    @Named(value = "dtoToEntity")
    ENTITY dtoToEntity(DTO dto);

    /**
     * dto list to entity list
     *
     * @param dtos
     * @return
     */
    @IterableMapping(qualifiedByName = "dtoToEntity")
    List<ENTITY> dtosToEntities(List<DTO> dtos);

    /**
     * entity to vo
     *
     * @param entity
     * @return
     */
    @Named(value = "entityToVO")
    VO entityToVO(ENTITY entity);

    /**
     * entity list to vo list
     *
     * @param entities
     * @return
     */
    @IterableMapping(qualifiedByName = "entityToVO")
    List<VO> entitiesToVOs(List<ENTITY> entities);

    /**
     * entity to dto
     * @param entity
     * @return
     */
    @Named(value = "entityToDto")
    DTO entityToDto(ENTITY entity);

    /**
     * vo to dto
     * @param entity
     * @return
     */
    @Named(value = "voToDto")
    DTO voToDto(VO entity);

    /**
     * vo to entity
     * @param entity
     * @return
     */
    @Named(value = "voToEntity")
    ENTITY voToEntity(VO entity);

    /**
     * vos to entities
     * @param entities
     * @return
     */
    @IterableMapping(qualifiedByName = "voToEntity")
    List<ENTITY> vosToEntities(List<VO> entities);

    /**
     * dto update entity
     * dto property null not copy to entity
     *
     * @param dto
     * @param entity
     */
    @UpdateConvertIgnore
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Named(value = "dtoUpdateEntity")
    void dtoUpdateEntity(DTO dto, @MappingTarget ENTITY entity);
}
