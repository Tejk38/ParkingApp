package com.example.Project.Repository;


import com.example.Project.Entity.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface parkingLotRepository extends JpaRepository<ParkingLot,Long> {

    List<ParkingLot> findByEmail(String email);

//    void deleteParkingLotByOwnerEmailAndPostCode(String email, String PostCode);
}
