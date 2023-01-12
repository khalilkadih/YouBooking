package com.youcode.youbooking.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Rooms implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float prix;
    private int capacity;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn
    private Hotels hotels;


}
