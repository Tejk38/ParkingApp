package com.example.Project.Controller;

import com.example.Project.Entity.ParkingLot;
import com.example.Project.Service.ParkingLotService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LotController {

    @Autowired
    ParkingLotService parkingLotService;

    @GetMapping("/parkingLots")
    public List<ParkingLot> getParkingLots(){
        return parkingLotService.getAllParkingLots();
    }

    @GetMapping("/parkingLots/owner")
    public List<ParkingLot> getParkingLotsByOwner(@RequestParam String email) {

        if (email == null) {

            return null;
        }
        return parkingLotService.getParkingLotsByOwner(email);
    }

}
