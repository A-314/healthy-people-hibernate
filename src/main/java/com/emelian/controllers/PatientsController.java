package com.emelian.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patients")
public class PatientsController {
    @GetMapping()
    public String getPagePatient(){

        return "patients/index";
    }
}
