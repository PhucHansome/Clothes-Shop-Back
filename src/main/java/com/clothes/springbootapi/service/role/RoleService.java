package com.clothes.springbootapi.service.role;

import com.clothes.springbootapi.domain.entity.Role;
import com.clothes.springbootapi.service.IGeneralService;


public interface RoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
