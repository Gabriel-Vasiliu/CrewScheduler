package com.pa.CrewScheduler.controllers;

import com.pa.CrewScheduler.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PilotController {
    @Autowired
    private PilotService service;

    @GetMapping("/pilots")
    public String getPilots(Model model) {
        model.addAttribute("pilots", service.getAllPilots());
        return "pilots";
    }
}
