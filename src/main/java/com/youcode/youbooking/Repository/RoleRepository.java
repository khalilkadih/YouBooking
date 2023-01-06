package com.youcode.youbooking.Repository;

import com.youcode.youbooking.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByNameRole(String Namerole);
}
