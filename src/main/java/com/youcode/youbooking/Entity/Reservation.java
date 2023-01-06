package com.youcode.youbooking.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RefRservation;

    @OneToMany
    private List<Client> client;

    @ManyToOne
    private List<Rooms> rooms;
    private double total;
    private String dateDebut;
    private String dateFin;

}
