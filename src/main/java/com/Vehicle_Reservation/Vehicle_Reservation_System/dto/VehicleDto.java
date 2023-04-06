package com.Vehicle_Reservation.Vehicle_Reservation_System.dto;

import com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private String vehicleNumber;
    private String insuranceNo;
    private int maxDays;
    private int maxLength;
    private int maxPassengers;
    private VehicleType type;
    private int fkDriverId;
    private List<Integer> serviceAreas;
}
