package com.youcode.youbooking.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long RefRservation;

    @ManyToOne
    @JoinColumn
    private Users client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Rooms rooms;

    private double total;
    private String dateDebut;
    private String dateFin;
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;



}
