package com.example.Project.Controller;

import com.example.Project.Entity.ParkingLot;
import com.example.Project.Entity.ParkingOwner;
import com.example.Project.Repository.parkingLotRepository;
import com.example.Project.Service.ParkingLotService;
import com.example.Project.Service.ParkingOwnerService;
import com.example.Project.Service.impl.ParkingLotServiceImpl;
import com.example.Project.Service.impl.ParkingOwnerServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParkingController {

    @Autowired
    ParkingLotServiceImpl parkingLotService;

    @Autowired
    ParkingOwnerServiceImpl parkingOwnerService;

//    parkingLotRepository parkingLotRepository;



    @GetMapping("/parking")
    public String list(){
        return "parking";
    }


    @GetMapping("/SpotReserve")
    public String book(@RequestParam String name,
                       @RequestParam String postcode,
                       @RequestParam int spots) {

        return "SpotReserve";
    }

    //Parking Owner side
    @GetMapping("/newParking")
    public String addParking(){
        return "AddParkingLot";
    }


    @PostMapping("/saveParkingLot")
    public String saveParkingLot(
            @RequestParam("name") String name,
            @RequestParam("address") String address,
            @RequestParam("postcode") String postcode,
            @RequestParam("spots") int spots,
            HttpSession session) {
        try {
            // Get the email of the current user from the session
            String email = (String) session.getAttribute("email");

            // Find the ParkingOwner entity for the current user


            // Create a new ParkingLot object
            ParkingLot parkingLot = new ParkingLot();
            parkingLot.setSpotName(name);
            parkingLot.setAddress(address);
            parkingLot.setPostCode(postcode);
            parkingLot.setSpots(spots);
            parkingLot.setEmail(email);

            // Set the parkingOwner property


            // Save the ParkingLot object to the database
            parkingLotService.saveParkingLot(parkingLot);

            return "ParkingOwner";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    @GetMapping("/deleteLot")
    public String getLotByOwner(@RequestParam Long id){

        parkingLotService.deleteParkingLotById(id);

        return "ParkingOwner";
    }

}
