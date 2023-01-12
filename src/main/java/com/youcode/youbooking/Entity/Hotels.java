package com.youcode.youbooking.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Hotels implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String adress;
    @ManyToOne
    @JoinColumn()
    private Ville ville;
/*    @OneToMany(fetch = FetchType.LAZY)
    private List<Rooms> rooms= new ArrayList<>();*/
    @ManyToOne
    @JoinColumn
    private Users manager;
}
