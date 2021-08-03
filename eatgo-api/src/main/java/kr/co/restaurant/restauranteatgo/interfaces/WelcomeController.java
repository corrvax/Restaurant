package kr.co.restaurant.restauranteatgo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //web connection
public class WelcomeController {
    @GetMapping("/") //http connection
    public String hello(){
        return "Hello, Eun Jo Web Page!";
    }
}
