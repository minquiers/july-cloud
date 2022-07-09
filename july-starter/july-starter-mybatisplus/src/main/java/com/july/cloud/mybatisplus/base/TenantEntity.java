package com.july.cloud.mybatisplus.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TenantEntity extends BaseEntity {
    /**
     * 租户id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "租户id")
    private String tenantId;

}
