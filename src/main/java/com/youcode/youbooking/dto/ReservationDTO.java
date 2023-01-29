package com.youcode.youbooking.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationDTO {

    private int NumberRoomReserved;
    private String dateDebut;
    private String dateFin;
}
