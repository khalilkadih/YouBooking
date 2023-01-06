package com.youcode.youbooking.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Rooms implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Status status;
    private float prix;
    private int capacity;
    @ManyToOne
    private  Hotels hotels;
    @OneToMany
    private  Reservation reservation;

}
