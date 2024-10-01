package com.example.Project.Service.impl;

import com.example.Project.Entity.ParkingOwner;
import com.example.Project.Repository.ParkingOwnerRepository;
import com.example.Project.Service.ParkingOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingOwnerServiceImpl implements ParkingOwnerService {

    private ParkingOwnerRepository ownerRepository;



    public ParkingOwnerServiceImpl(ParkingOwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;

    }

    @Override
    public void saveOwner(ParkingOwner parkingOwner) {
        ParkingOwner owner = new ParkingOwner();
        owner.setFirstName(parkingOwner.getFirstName() );
        owner.setLastName(parkingOwner.getLastName());
        owner.setEmail(parkingOwner.getEmail());


        owner.setPassword(parkingOwner.getPassword());

        ownerRepository.save(owner);
    }

    @Override
    public ParkingOwner findByEmail(String email) {
        return ownerRepository.findByEmail(email);
    }

    @Override
    public List<ParkingOwner> findAllUsers() {
        List<ParkingOwner> owners = ownerRepository.findAll();
        return owners.stream().map((owner) -> convertEntityToDto(owner))
                .collect(Collectors.toList());
    }

    private ParkingOwner convertEntityToDto(ParkingOwner owner){
        ParkingOwner parkingOwner = new ParkingOwner();
        String firstname = owner.getFirstName();
        String lastname = owner.getLastName();
        parkingOwner.setFirstName(firstname);
        parkingOwner.setLastName(lastname);
        parkingOwner.setEmail(parkingOwner.getEmail());

        return parkingOwner;
    }
}
