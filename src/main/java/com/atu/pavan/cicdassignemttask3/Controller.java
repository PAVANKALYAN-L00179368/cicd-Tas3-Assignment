package com.atu.pavan.cicdassignemttask3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/pavan")
    public String Hello(){
        return " <h1>Hi, I am Pavan Kalyan and my L Id is L00179368</h1>";
    }
}
