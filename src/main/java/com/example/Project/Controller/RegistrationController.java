package com.example.Project.Controller;

import com.example.Project.Dto.UserDto;
import com.example.Project.Entity.ParkingOwner;
import com.example.Project.Entity.User;
import com.example.Project.Service.EmailService;
import com.example.Project.Service.ParkingOwnerService;
import com.example.Project.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.mindrot.jbcrypt.BCrypt;


@Controller
public class RegistrationController {
    @Autowired
    UserService userService;

    @Autowired
    ParkingOwnerService parkingOwnerService;

    @Autowired
    private JavaMailSender mailSender;



    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Validated @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model,HttpSession session){
        User existing = userService.findByEmail(user.getEmail());

        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }

        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);

        userService.saveUser(user);

//        EmailService.sendEmail(user.getEmail(),"Successfully Registered");
        session.setAttribute("email",user.getEmail());

        return "parking";
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }


    @GetMapping("owner/register")
    public String showOwnerRegistrationForm(Model model){
        ParkingOwner parkingowner = new ParkingOwner();
        model.addAttribute("parkingowner", parkingowner);
        return "OwnerRegister";
    }

    // handler method to handle register user form submit request
    @PostMapping("/owner/register/save")
    public String registration(@Validated @ModelAttribute("parkingowner") ParkingOwner owner,
                               BindingResult result,
                               Model mode, HttpSession session){
        ParkingOwner existingowner = parkingOwnerService.findByEmail(owner.getEmail());
        String email = (String) session.getAttribute("email");
        if (existingowner != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            return "OwnerRegister";
        }

        String hashedPassword = hashPasswordOwner(owner.getPassword());
        owner.setPassword(hashedPassword);


        parkingOwnerService.saveOwner(owner);

//        EmailService.sendEmail(email,"Successfully Registered");


        session.setAttribute("email",owner.getEmail());

        return "ParkingOwner";
    }

    private String hashPasswordOwner(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }



}

