package com.july.cloud.framework.backend.vo;

import com.july.cloud.framework.backend.entity.SysUserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserVO extends SysUserEntity {

    private Set<String> roles;

}
