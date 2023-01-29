package com.youcode.youbooking.Entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;import lombok.*;

import java.sql.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reservation {
    @javax.persistence.Id
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
    private int nombreRoomReserver;
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;



}
