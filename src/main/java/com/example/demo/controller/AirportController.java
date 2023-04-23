package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Airport;
import com.example.demo.service.AirportService;

@Controller
public class AirportController {

    @Autowired
    private AirportService airportService;

    // display list of airports
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listAirports", airportService.getAllAirports());
        return "index";
    }

    @GetMapping("/showNewAirportForm")
    public String showNewAirportForm(Model model) {
        // create model attribute to bind form data
        Airport airport = new Airport();
        model.addAttribute("airport", airport);
        return "new_airport";
    }

    @PostMapping("/saveAirport")
    public String saveAirport(@ModelAttribute("airport") Airport airport) {
        // save airport to database
        airportService.saveAirport(airport);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String airport_name, Model model) {

        // get airport from the service
        Airport airport = airportService.getAirportById(airport_name);

        // set airport as a model attribute to pre-populate the form
        model.addAttribute("airport", airport);
        return "update_airport";
    }

    @GetMapping("/deleteAirport/{id}")
    public String deleteAirport(@PathVariable(value = "id") String airport_name) {

        // call delete airport method 
        this.airportService.deleteAirportById(airport_name);
        return "redirect:/";
    }
}