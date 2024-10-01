package com.example.Project.Service;

import com.example.Project.Entity.ParkingLot;
import com.example.Project.Repository.parkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ParkingLotService {



    List<ParkingLot> getAllParkingLots();
    void saveParkingLot(ParkingLot parkingLot);
    ParkingLot getParkingLotById(long id);
    void deleteParkingLotById(long id);
    List<ParkingLot> getParkingLotsByOwner(String ownerEmail);


//    void deleteParkingLotByOwner(String email, String postcode);
}
