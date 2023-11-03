package com.atu.pavan.cicdassignemttask3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/pavan")
    public String Hello(){
        return " <h1 align=\"center\">Welcome to Task-3 CICD-pipeline</h1>\n" +
                "<h1 align=\"center\"> Hi I am Pavan Kalyan Varikolu, my student L id is L0017936 </h1>";
    }
}
