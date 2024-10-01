package com.example.Project.Service.impl;


import com.example.Project.Entity.ParkingLot;
import com.example.Project.Repository.parkingLotRepository;
import com.example.Project.Service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    private parkingLotRepository parkingLotRepository;


    @Override
    public List<ParkingLot> getAllParkingLots(){
        return parkingLotRepository.findAll();

    }

    @Override
    public void saveParkingLot(ParkingLot parkingLot) {
        this.parkingLotRepository.save(parkingLot);
    }

    @Override
    public ParkingLot getParkingLotById(long id) {
        Optional<ParkingLot> optional = parkingLotRepository.findById(id);
        ParkingLot parkingLot = null;
        if(optional.isPresent()){
            parkingLot = optional.get();
        } else {
            throw new RuntimeException("ParkingLot not found for id ::" + id);
        }
        return parkingLot;
    }


    @Override
    public void deleteParkingLotById(long id) {
        this.parkingLotRepository.deleteById(id);
    }

    @Override
    public List<ParkingLot> getParkingLotsByOwner(String ownerEmail) {
        return parkingLotRepository.findByEmail(ownerEmail);
    }

//    @Override
//    public void deleteParkingLotByOwner(String ownerEmail,String postcode) {
//        this.parkingLotRepository.deleteParkingLotByOwnerEmailAndPostCode(ownerEmail,postcode);
//    }


}
