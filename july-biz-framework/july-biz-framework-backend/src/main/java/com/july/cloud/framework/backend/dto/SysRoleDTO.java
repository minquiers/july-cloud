package com.july.cloud.framework.backend.dto;

import com.july.cloud.framework.backend.entity.SysRoleEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleDTO extends SysRoleEntity {

    private List<String> menus;
}
