package com.youcode.youbooking.Services;

import com.youcode.youbooking.Entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UserService {
    List<Users> USERS_LIST();
    Users addUser(Users user);
    Optional<Users> getUserById(Long id);
    Optional<Users>getUserByName(String name);
    List<Users> getAllManager();
    List<Users> getAllClient();
    List<Users> getAllAdmin();
    Users updateUser(Users user);
    String deleteUser(Long id);
    Users findByEmail(String email);
}
