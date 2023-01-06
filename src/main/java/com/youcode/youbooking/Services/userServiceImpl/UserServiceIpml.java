package com.youcode.youbooking.Services.userServiceImpl;

import com.youcode.youbooking.Entity.Role;
import com.youcode.youbooking.Entity.Users;
import com.youcode.youbooking.Repository.RoleRepository;
import com.youcode.youbooking.Repository.UserRepository;
import com.youcode.youbooking.Services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceIpml implements UserService {

    private  final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceIpml(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Users> USERS_LIST() {
        return userRepository.findAll();
    }

    @Override
    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public void addRoleToUser(String roleName, String email) {
        Users findUser=findByEmail(email);
        if(findUser!=null){
            Role role=roleRepository.findRoleByNameRole(roleName);
            findUser.setRole(role);
        }
    }

    @Override
    public String deleteUser(Long id) {
        return null;
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
