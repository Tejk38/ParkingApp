package com.example.Project.Controller;

import com.example.Project.Entity.ParkingOwner;
import com.example.Project.Entity.User;
import com.example.Project.Service.ParkingOwnerService;
import com.example.Project.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    ParkingOwnerService parkingOwnerService;

    @GetMapping("/login")
    public String showForm() {
        return "login";
    }

    @PostMapping("/login/save")
    public String submitForm(@RequestParam String email, @RequestParam String password,
                             HttpSession session) {
        User user = userService.findByEmail(email);
        if (user != null && verifyPassword(password,user.getPassword())) {

            session.setAttribute("email",email);
            return "parking";
        }
        return "login";
    }

    private boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

    //Owner side
    @GetMapping("owner/login")
    public String showloginform(){
        return "OwnerLogin";
    }

    @PostMapping("owner/login/save")
    public String submitOwnerForm(@RequestParam String email, @RequestParam String password,
                                  HttpSession session) {
        ParkingOwner parkingOwner = parkingOwnerService.findByEmail(email);
        if (parkingOwner != null && verifyOwnerPassword(password,parkingOwner.getPassword())) {

            session.setAttribute("email",email);
            return "ParkingOwner";
        }
        return "OwnerLogin";
    }


    private boolean verifyOwnerPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}

