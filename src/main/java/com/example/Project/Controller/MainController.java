package com.example.Project.Controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(){
        return "index";
    }

    @GetMapping("/getEmail")
    @ResponseBody
    public ResponseEntity<String> getEmail(HttpSession session) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return new ResponseEntity<>("Email not found in session", HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(email, HttpStatus.OK);
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/directions")
    public String mapdirection(){
        return "directions";
    }

}
