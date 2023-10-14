package com.atu.pavan.cicdassignemttask3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @RequestMapping("/")
    public String Hello(){
        return " <h1>Hi, I am Pavan Kalyan and my L Id id L00179368</h1>";
    }
}
