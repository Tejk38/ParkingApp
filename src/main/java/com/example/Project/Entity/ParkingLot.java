package com.example.Project.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "owner_email", referencedColumnName = "email", nullable = false)
//    private ParkingOwner owner;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String spotName;
    private String Address;
    private String PostCode;
    private int spots;

    private String email;


    public ParkingLot() {
    }

    public ParkingLot(String spotName, String address, String postCode, int Spots) {
        this.spotName = spotName;
        Address = address;
        PostCode = postCode;

        this.spots = Spots;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        this.PostCode = postCode;
    }

    public int getSpots() {
        return spots;
    }

    public void setSpots(int spots) {
        this.spots = spots;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public ParkingOwner getOwner() {
//        return owner;
//    }
//
//    public void setOwner(ParkingOwner owner) {
//        this.owner = owner;
//    }
}

