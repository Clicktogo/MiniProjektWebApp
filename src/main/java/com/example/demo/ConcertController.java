package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ConcertController {

    @Autowired
    EventService service;

    @GetMapping("/")
    public String allConcerts(Model model)  {
        model.addAttribute("concertList", service.getAllConcerts());
        return "allEvents";
    }

    @GetMapping("/events")
    public String detailPage(Model model, @RequestParam int eventId)    {
        model.addAttribute("currentConcert", service.getConcertById(eventId));

        return "masterDetailConcert";
    }

}
