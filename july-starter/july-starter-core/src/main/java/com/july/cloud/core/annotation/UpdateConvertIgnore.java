package com.july.cloud.core.annotation;


import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * UpdateConvertIgnore
 * public properties ignore
 */
@Retention(RetentionPolicy.CLASS)
@Mappings(value = {
    @Mapping(target = "id", ignore = true),
    @Mapping(target = "createBy", ignore = true),
    @Mapping(target = "createAt", ignore = true)
})
public @interface UpdateConvertIgnore {
}
