package com.youcode.youbooking.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Hotels implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String codePostale;
    private String ville;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Rooms> rooms= new ArrayList<>();
}
