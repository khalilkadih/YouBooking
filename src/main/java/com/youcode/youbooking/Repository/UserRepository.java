package com.youcode.youbooking.Repository;

import com.youcode.youbooking.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
    List<Users> findAllByRole(String role);
    Users findByRole(String role);
    Users findByFname(String name);
}
