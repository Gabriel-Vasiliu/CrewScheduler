package com.pa.CrewScheduler.controllers;

import com.pa.CrewScheduler.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {
    @Autowired
    private AirportService service;

    @GetMapping("/home")
    public String home() {
        service.readData();
        return "home";
    }

    @GetMapping("/")
    public String home1() {
        service.readData();
        return "home";
    }

    @GetMapping("/flights")
    public String getFlights(Model model) {
        model.addAttribute("flights", service.getFlights());
        model.addAttribute("airplanesWithoutStaff", service.getAirplanesWithoutStaff());
        return "flights";
    }

    @GetMapping("/airplanes-without-staff")
    public String getAirplanesWithoutStaff(Model model) {
        model.addAttribute("airplanesWithoutStaff", service.getAirplanesWithoutStaff());
        return "airplanes-without-staff";
    }
}
