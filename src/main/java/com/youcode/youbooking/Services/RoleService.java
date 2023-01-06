package com.youcode.youbooking.Services;

import com.youcode.youbooking.Entity.Role;
import com.youcode.youbooking.Entity.Users;

import java.util.List;

public interface RoleService {
    List<Role> ROLE_LIST();
    Role addRole(Role role);
    String deleteRole(Long id);
    Users findByRoleName(String roleName);
}
