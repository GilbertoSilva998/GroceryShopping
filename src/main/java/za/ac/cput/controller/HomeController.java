package za.ac.cput.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
//@CrossOrigin("http://localhost:3000")
public class HomeController {

    @GetMapping
    public String home(Principal principal){
        return "Hello , JWT" + principal.getName();
    }
}
