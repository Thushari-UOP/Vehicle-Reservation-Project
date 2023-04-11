package com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServiceArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceAreaId;
    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "serviceAreas",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles(){
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }
}
