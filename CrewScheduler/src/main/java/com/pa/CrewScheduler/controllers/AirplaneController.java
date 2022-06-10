package com.pa.CrewScheduler.controllers;

import com.pa.CrewScheduler.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AirplaneController {
    @Autowired
    private AirplaneService service;

    @GetMapping("/airplanes")
    public String getAirplanes(Model model) {
        model.addAttribute("airplanes", service.getAllAirplanes());
        return "airplanes";
    }
}
