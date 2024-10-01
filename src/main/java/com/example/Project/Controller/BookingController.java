package com.example.Project.Controller;

import com.example.Project.Entity.BookingInfo;
import com.example.Project.Entity.BookingRequest;
import com.example.Project.Entity.ParkingLot;
import com.example.Project.Entity.User;
import com.example.Project.Repository.BookingInfoRepository;
import com.example.Project.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookingController {

    @Autowired
    private BookingInfoRepository bookingInfoRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/bookings/save")
    @ResponseBody
    public ResponseEntity<Map<String, String>> createBooking(@RequestBody BookingRequest bookingRequest, HttpSession session) {
        try {
            String email = (String) session.getAttribute("email");
            BookingInfo bookingInfo = new BookingInfo();

            bookingInfo.setEmail(email);
            bookingInfo.setLotName(bookingRequest.getName());
            bookingInfo.setPostcode(bookingRequest.getPostcode());
            bookingInfo.setVehicleNumber(bookingRequest.getVehicleNumber());

            bookingInfoRepository.save(bookingInfo);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Booking created successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, String> response = new HashMap<>();
            response.put("error", "Error creating booking");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @GetMapping("/bookings")
    public String getBookingsByUser(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        List<BookingInfo> bookingInfoList = bookingInfoRepository.findByEmail(email);
        model.addAttribute("bookingInfoList", bookingInfoList);
        return "bookinginfo";
    }


    @GetMapping("/bookingspage")
    public String info(){
        return "bookinginfo";
    }
}

