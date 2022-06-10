package com.pa.CrewScheduler.controllers;

import com.pa.CrewScheduler.service.FlightAttendantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FlightAttendantController {
    @Autowired
    private FlightAttendantService service;

    @GetMapping("/attendants")
    public String getAttendants(Model model) {
        model.addAttribute("attendants", service.getAllFlightAttendants());
        return "attendants";
    }
}
