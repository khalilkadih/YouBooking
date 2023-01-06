package com.youcode.youbooking.Services.userServiceImpl;

import com.youcode.youbooking.Entity.Role;
import com.youcode.youbooking.Entity.Users;
import com.youcode.youbooking.Repository.RoleRepository;
import com.youcode.youbooking.Services.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> ROLE_LIST() {
        return roleRepository.findAll();
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public String deleteRole(Long id) {
        String msg="" ;
         roleRepository.deleteById(id);
         msg="deleted successffully ";
         if (roleRepository.findById(id).isPresent()){
             msg="you have some problems";
         }
          return msg;
    }

    @Override
    public Users findByRoleName(String roleName) {
        return null;
    }
}
