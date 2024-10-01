package com.example.Project.Service;

import com.example.Project.Dto.UserDto;
import com.example.Project.Entity.ParkingOwner;
import com.example.Project.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;



public interface ParkingOwnerService {

    void saveOwner(ParkingOwner parkingOwner);

    ParkingOwner findByEmail(String email);

    List<ParkingOwner> findAllUsers();


}
