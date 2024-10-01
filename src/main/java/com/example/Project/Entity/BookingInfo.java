package com.example.Project.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "booking_info")
public class BookingInfo {

//    @ManyToOne
//    @JoinColumn(name = "parkingLot_id")
//    private ParkingLot parkingLot;




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    private String email;
    private String VehicleNumber;

    private String LotName;
    private String postcode;



    public String getLotName() {
        return LotName;
    }

    public void setLotName(String lotName) {
        LotName = lotName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Long getId() {
        return id;
    }
}
