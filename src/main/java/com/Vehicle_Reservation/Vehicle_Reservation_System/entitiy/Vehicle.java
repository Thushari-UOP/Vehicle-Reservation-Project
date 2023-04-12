package com.Vehicle_Reservation.Vehicle_Reservation_System.entitiy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"reservations", "service"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vehicleId")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleType type;
    @Column(unique = true,nullable = false)
    private String vehicleNumber;
    @Column(unique = true,nullable = false)
    private String insuranceNo;
    @Column(nullable = false)
    private int maxDays;
    @Column(nullable = false)
    private int maxLength;
    @Column(nullable = false)
    private int maxPassengers;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_driver_id",nullable = false)
    @JsonIgnore
    private Driver driver;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "vehicle",cascade = CascadeType.ALL)
//    @JsonIgnore
    private List<VehiclePictures> vehiclePictures = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "vehicle",cascade = CascadeType.ALL)
//    @JsonIgnore
    private List<Reservation> reservations = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    @JsonIgnore
    @JoinTable(name = "service",joinColumns = @JoinColumn(name = "vehicle_id"),inverseJoinColumns = @JoinColumn(name = "service_area_id"))
    private List<ServiceArea> serviceAreas;

    public void addServiceArea(ServiceArea serviceArea){
        this.serviceAreas.add(serviceArea);
        serviceArea.getVehicles().add(this);
    }

    public void removeServiceArea(int areaId){
        ServiceArea serviceArea = this.serviceAreas.stream().filter(t -> t.getServiceAreaId() == areaId).findFirst().orElse(null);
        if (serviceArea != null){
            this.serviceAreas.remove(serviceArea);
            serviceArea.getVehicles().remove(this);
        }
    }



}
