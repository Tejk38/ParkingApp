package com.example.Project.Repository;

import com.example.Project.Entity.ParkingOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingOwnerRepository extends JpaRepository<ParkingOwner, Long> {

    ParkingOwner findByEmail(String email);
}
