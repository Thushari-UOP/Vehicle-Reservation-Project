package com.Vehicle_Reservation.Vehicle_Reservation_System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class VehicleServiceAreasDto {
    Integer vehicleId;
    List<Integer> serviceAreas;
}
