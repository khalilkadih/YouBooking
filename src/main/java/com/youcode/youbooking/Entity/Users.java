package com.youcode.youbooking.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Entity
@Table
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Getter @Setter
public  class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String telephone;
   @Enumerated(EnumType.STRING)
    private Role role;

}
