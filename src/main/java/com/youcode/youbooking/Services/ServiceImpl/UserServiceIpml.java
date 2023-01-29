package com.youcode.youbooking.Services.ServiceImpl;

import com.youcode.youbooking.Entity.Users;
import com.youcode.youbooking.Repository.UserRepository;
import com.youcode.youbooking.Services.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
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
    public Users getUserByName(String name) {
        return (userRepository.findByFname(name));
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

        return userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("user not found"));
    }






    /*///////////////////////////////////////////////////*/



      private final static List<UserDetails> USER_APPLICATION= Arrays.asList(
            new User("khalil@gmail.com","khalil", Collections.singleton(new SimpleGrantedAuthority("ADMIN"))),
            new User("omar@gmail.com","omar", Collections.singleton(new SimpleGrantedAuthority("USER"))),
            new User("omar@gmail.com","omar", Collections.singleton(new SimpleGrantedAuthority("Fournisseur")))
    );
}
