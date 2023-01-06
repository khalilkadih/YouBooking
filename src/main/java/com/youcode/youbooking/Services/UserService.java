package com.youcode.youbooking.Services;

import com.youcode.youbooking.Entity.Users;

import java.util.List;

public interface UserService {
    List<Users> USERS_LIST();
    Users addUser(Users user);
    Users updateUser(Users user);
    void addRoleToUser(String roleName, String email);
    String deleteUser(Long id);
    Users findByEmail(String email);
}
