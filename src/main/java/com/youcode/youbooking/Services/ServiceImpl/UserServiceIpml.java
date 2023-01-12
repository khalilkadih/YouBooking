package com.youcode.youbooking.Services.ServiceImpl;

import com.youcode.youbooking.Entity.Users;
import com.youcode.youbooking.Repository.UserRepository;
import com.youcode.youbooking.Services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceIpml implements UserService {

    private final UserRepository userRepository;

    public UserServiceIpml(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<Users> getUserByName(String name) {
        return Optional.ofNullable(userRepository.findByFname(name));
    }

    @Override
    public List<Users> getAllManager() {
        return userRepository.findAllByRole("MANAGER");
    }

    @Override
    public List<Users> getAllClient() {
        return userRepository.findAllByRole("CLIENT");
    }

    @Override
    public List<Users> getAllAdmin() {
        return userRepository.findAllByRole("ADMIN");
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
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
