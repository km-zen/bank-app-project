package pl.markowski.konrad.bankapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloBank {

    @GetMapping("/hello")
    public String hello(){
        return "hello bank user!";
    }
}
