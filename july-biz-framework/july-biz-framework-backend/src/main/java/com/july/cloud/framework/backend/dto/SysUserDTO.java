package com.july.cloud.framework.backend.dto;

import com.july.cloud.framework.backend.entity.SysUserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserDTO extends SysUserEntity {

    private List<String> roles;

}
