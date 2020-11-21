package de.bockhorn.codechallenge;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @RequestMapping("/")
    public String TestPage() {
        return "It worked!";
    }

}
