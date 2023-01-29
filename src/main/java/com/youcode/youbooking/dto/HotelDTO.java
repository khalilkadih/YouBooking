package com.youcode.youbooking.dto;

import com.youcode.youbooking.Entity.Ville;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    private String name;
    private  String adress;
    private String villeName;

}
