package com.youcode.youbooking.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public abstract class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String telephone;
    @ManyToOne
    private Role role;

}
